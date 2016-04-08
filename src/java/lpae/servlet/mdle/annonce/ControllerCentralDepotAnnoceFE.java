/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.annonce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import lpae.annonce.gestionnaire.GreAnnonce;
import lpae.categorie.gestionnaire.GreCategorie;
import lpae.entites.Annonce;
import lpae.entites.Categorie;
import lpae.entites.Ecole;
import lpae.entites.EcoleUtilisateur;
import lpae.entites.PhotoAnnonce;
import lpae.entites.TypeAnnonce;
import lpae.entites.TypeCategorie;
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.GestionnaireSecuriteFE;
import lpae.mdle.utilitaire.HelpClass;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralDepotAnnoceFE", urlPatterns = {"/ControllerCentralDepotAnnoceFE"})
@MultipartConfig
public class ControllerCentralDepotAnnoceFE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private GreCategorie greCategorie;

    @EJB
    private GreAnnonce greAnnonce;

    @EJB
    private GestionnaireSecuriteFE greSecurite;

    @EJB
    private GreUtilisateur greUtilisateur;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (greSecurite.getIdUtilisateurSession(request) != null) {
                int idUtilisateurSession = (int) greSecurite.getIdUtilisateurSession(request);
                Utilisateur utilisateur = greUtilisateur.rechercherUtilisateurParId(idUtilisateurSession);
                if (utilisateur != null) {
                    request.setAttribute("utilisateur", utilisateur);
                    Ecole ecole = new Ecole();
                    Collection<EcoleUtilisateur> ecoleUtilisateurs = utilisateur.getEcoleUtilisateurs();

                    if (ecoleUtilisateurs != null && ecoleUtilisateurs.size() > 0) {
                        for (EcoleUtilisateur ecoleUtilisateur : ecoleUtilisateurs) {
                            ecole = ecoleUtilisateur.getEcole();
                            request.setAttribute("ecole", ecole);
                            break;
                        }
                    }

                }
                request.getRequestDispatcher("deposer-annonce.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher(HelpClass.PAGE_ACCUEIL_FRONT_END).forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //System.out.println(" ajout infos " + HelpClass.ajoutInformationNomPhoto());
        try {
            String action = request.getParameter("action");
            String redirection = HelpClass.NOM_SERVLET_CONTROLLER_END;
            if (action != null && action.equals("categorie")) {
                PrintWriter out = response.getWriter();
                Collection<TypeCategorie> typesCategories = greCategorie.obtenirToutesLesTypeDeCategorie();
                JSONArray data = new JSONArray();
                if (typesCategories != null && typesCategories.size() > 0) {
                    for (TypeCategorie typeCategorie : typesCategories) {

                        Collection<Categorie> categories = greCategorie.obtenirToutesLesCategorieParIdTypeCategorie(typeCategorie.getId());
                        if (categories != null && categories.size() > 0) {
                            JSONObject jsonOb = new JSONObject();
                            jsonOb.put("idTypeCat", typeCategorie.getId());
                            jsonOb.put("nomTypeCat", typeCategorie.getNomTyp());

                            JSONArray listeDesCategories = new JSONArray();
                            for (Categorie cat : categories) {
                                JSONObject jsonObCat = new JSONObject();
                                jsonObCat.put("idCat", cat.getId());
                                jsonObCat.put("nomCat", cat.getLibelle());
                                listeDesCategories.add(jsonObCat);
                            }
                            jsonOb.put("categories", listeDesCategories);
                            data.add(jsonOb);
                        }
                    }
                }
                out.println(data);
            } else if (action != null && action.equals("add")) {
                // verification que l'utilisateur existe bien dans la session avant le traitement indispensable
                BufferedReader br = null;
                JSONParser parser = new JSONParser();
                String categorieAnnonce = null;
                String titreAnnonce = null;
                String textAnnonce = null;
                String prix = null;
                String type = null;
                String MarquerPhoneAnnce = null;
                String anncePart = null;

                String actionPost = ControllerCentralDepotAnnoceFE.getParameterValue(request, "action");
                //System.out.println("action post" + actionPost);
                if (actionPost != null && actionPost.equals("add")) {

                    /*
                     ON SAUVE D'ABORD L'ANNONCE AVANT DE DEBUTER L'ECRITURE DES PHOTOS
                     */
                    categorieAnnonce = request.getParameter("categorieAnnonce");
                    type = request.getParameter("radios");

                    /*System.out.println("radios " + type + " " +request.getParameter("prix")
                     + " titre " + request.getParameter("titreAnnonce")
                     + " description " + " desc " + request.getParameter("textAnnonce")
                     + " marquer " + request.getParameter("MarquerPhone") +
                     " partenaire " + request.getParameter("anncePart"));*/
                    boolean flatIdCategorie = true; // on suppose que l'insertion va bien se derouler
                    int idCategorieAnnonce = 0;
                    int idTypeAnnonce = 0;
                    boolean flatIdTypeAnnonce = true, flatPrix = true;

                    prix = request.getParameter("prix");
                    MarquerPhoneAnnce = request.getParameter("MarquerPhone");
                    anncePart = request.getParameter("anncePart");
                    textAnnonce = request.getParameter("textAnnonce");
                    titreAnnonce = request.getParameter("titreAnnonce");
                    double prixDouble = 0.0;
                    System.out.println("categorie " + categorieAnnonce + " type " + type);
                    if ((categorieAnnonce != null && categorieAnnonce.length() > 0) && (type != null && type.length() > 0)) {
                        //System.out.println("firest entry");
                        try {
                            idCategorieAnnonce = Integer.parseInt(categorieAnnonce);
                        } catch (NumberFormatException numberException) {
                            flatIdCategorie = false;
                            System.out.println("impossible de caster la categorie de l'annonce gestionnaire de depot des annonce " + categorieAnnonce + " " + numberException);
                        }

                        try {
                            if (prix!=null && prix.length() > 0) {
                                prixDouble = Double.parseDouble(prix);
                            } else {
                                prixDouble = 0.0;
                            }

                        } catch (NumberFormatException numberException) {
                            flatPrix = false;
                            System.out.println("impossible de caster le cout de l'annonce gestionnaire de depot des annonce " + prix + " " + numberException);
                        }
                    //System.out.println(flatIdCategorie +" " + flatIdTypeAnnonce +" "+flatPrix);
                    /*
                         le castin s'est bien passé
                         */
                        if (flatIdCategorie) { //&& flatPrix
                            TypeAnnonce typeAnnonce = greAnnonce.rechercheTypeAnnonceParLibelle(type);
                            Categorie cat = greCategorie.rechercherCategorieParId(idCategorieAnnonce);
                        //A ce niveau si tout se bien aucune erreur
                            //System.out.println("type " + typeAnnonce + "cat " + cat);
                            if (typeAnnonce != null && cat != null) {
                                Annonce annonce = new Annonce();
                                annonce.setDateCreation(HelpClass.getCurrentDate());

                                System.out.println(" ajout infos " + HelpClass.ajoutInformationNomPhoto());
                                annonce.setDescription(textAnnonce);
                                annonce.setTitre(titreAnnonce);
                                annonce.setCategorie(cat);
                                annonce.setTypeAnnonce(typeAnnonce);
                                annonce.setCout(prixDouble);
                                annonce.setEtat(false); // visible

                                int idUtilisateurSession = (int) greSecurite.getIdUtilisateurSession(request);//bugger si pas d'utilisateur dans la session
                                 Utilisateur utilisateur = greUtilisateur.rechercherUtilisateurParId(idUtilisateurSession);
                                 annonce.setUtilisateur(utilisateur);
                                if (MarquerPhoneAnnce != null && MarquerPhoneAnnce.equals("1")) {
                                    annonce.setMarquerPhoneAnnce(true);
                                } else {
                                    annonce.setMarquerPhoneAnnce(false);
                                }

                                if (anncePart != null && anncePart.equals("1")) {
                                    annonce.setAnncePart(true);
                                } else {
                                    annonce.setAnncePart(false);
                                }
                                ArrayList<PhotoAnnonce> photosAnnonces = new ArrayList<PhotoAnnonce>();
                                /**
                                 * INSERTION DES PHOTOS RESPECTIVES
                                 */
                                final Part filePart = request.getPart("fichier1");
                                final Part filePart2 = request.getPart("fichier2");
                                final Part filePart3 = request.getPart("fichier3");

                                final String fileName1 = HelpClass.getFileName(filePart);
                                final String fileName2 = HelpClass.getFileName(filePart2);
                                final String fileName3 = HelpClass.getFileName(filePart3);

                                System.out.println("file1 " + fileName1 + " file 2" + fileName2 + " file name 3 " + fileName3);

                                String contextRealPath = getServletContext().getRealPath("/");
                                String locationFichier = contextRealPath + HelpClass.REPERTOIRE_PHOTOS_ANNONCE;
                                String remplace = "build"+File.separator;
                                //System.out.println("remplace " +locationFichier.replace(remplace, ""));
                               locationFichier=locationFichier.replace(remplace, "");

                                System.out.println("file name1 " + fileName1 + " contextPath " + contextRealPath + " orignie " + locationFichier);

                                if (fileName1 != null && fileName1.length() > 0) {
                                    final String MfileName1 = HelpClass.ajoutInformationNomPhoto() + fileName1;// on ajiut le time pour la distinction
                                    String archiveFichier1 = locationFichier + File.separator + MfileName1;
                                    PhotoAnnonce photo1 = new PhotoAnnonce();
                                    photo1.setNomLocalisation(MfileName1); //MfileName1 archiveFichier1
                                    photo1.setNomPropre(fileName1);
                                    //photosAnnonces.add(photo1);
                                    annonce.addPhoto(photo1);

                                    HelpClass.ecritureImageSurLeDisque(filePart.getInputStream(), archiveFichier1);
                                }
                                if (fileName2 != null && fileName2.length() > 0) {
                                    final String MfileName2 = HelpClass.ajoutInformationNomPhoto() + fileName2;
                                    String archiveFichier2 = locationFichier + File.separator + MfileName2;
                                    PhotoAnnonce photo2 = new PhotoAnnonce();
                                    photo2.setNomLocalisation(MfileName2);//MfileName2 archiveFichier2
                                    photo2.setNomPropre(fileName2);
                                    //photosAnnonces.add(photo2);
                                    annonce.addPhoto(photo2);
                                    HelpClass.ecritureImageSurLeDisque(filePart2.getInputStream(), archiveFichier2);
                                }
                                if (fileName3 != null && fileName3.length() > 0) {
                                    final String MfileName3 = HelpClass.ajoutInformationNomPhoto() + fileName3;
                                    String archiveFichier3 = locationFichier + File.separator + MfileName3;
                                    PhotoAnnonce photo3 = new PhotoAnnonce();
                                    photo3.setNomLocalisation(MfileName3);//MfileName3 archiveFichier3
                                    photo3.setNomPropre(fileName3);
                                    //photosAnnonces.add(photo3);
                                    annonce.addPhoto(photo3);
                                    HelpClass.ecritureImageSurLeDisque(filePart3.getInputStream(), archiveFichier3);

                                }

                                //on ajoute toutes les photos
                                //annonce.setPhotos(photosAnnonces);
                                greAnnonce.persist(annonce);
                                System.out.println("annonce persister");
                                //Tout s'est bien passer on redirige vers la page des index pour qu'elle redirige vers la même page de depot d'annonce
                                redirection += "?action=" + HelpClass.MESSAGE_SUCCES_DEPOT_ANNONCE_ACTION;
                                response.sendRedirect(redirection);

                            }
                        } /*Un probleme de code peut subvenir redirection*/ else {
                            System.out.println("Gesttion depot Annonce certaine condition non respectees");
                            redirection += "?action=" + HelpClass.MESSAGE_ECHEC_DEPOT_ANNONCE_ACTION;
                            response.sendRedirect(redirection);
                        }
                    } // redirection part defaut
                    else {
                        System.out.println("redirection par defaut servlet centrale depot annonce");
                        redirection += "?action=" + HelpClass.MESSAGE_ECHEC_DEPOT_ANNONCE_ACTION;
                        response.sendRedirect(redirection);
                    }

                }

            }//fin else
        } catch (IllegalStateException illegal) {
            System.out.println("cannot forward controller central depot annonce" + illegal.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold

    public static String getParameterValue(HttpServletRequest request, String nameParemeter) {
        String parameterValue = "";
        try {
            Part part = request.getPart(nameParemeter);
            if (part != null) {
                Scanner scanner = new Scanner(part.getInputStream());
                parameterValue = scanner.nextLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(ControllerCentralDepotAnnoceFE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ControllerCentralDepotAnnoceFE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parameterValue;
    }
}
