/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.annonce;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import lpae.mdle.utilitaire.HelpClass;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentrerGererMesAnnonces", urlPatterns = {"/ControllerCentrerGererMesAnnonces"})
@MultipartConfig
public class ControllerCentrerGererMesAnnonces extends HttpServlet {

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
    private GreAnnonce greAnnonce;
     
    @EJB
    private GestionnaireSecurite greSecurite;
    
    @EJB
    private GreUtilisateur greUtilisateur;
    
    @EJB
    private GreCategorie greCategorie;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String redirection ="ServletControllerIndex";
            //System.out.println("action " + action + ControllerCentralDepotAnnoceFE.getParameterValue(request, "action") + request.getParameter("action"));
            
            /**
             *  J AI PAS GERER LE CAS DES ECHECS AVEC CETTE CLASSE
             */
            if((action!=null && action.equals("freshToAll")))
            {
                String idAnnonce = request.getParameter("keyPlot");
                int intAnnonce = 0;
                boolean flatParsing = true;
                
                if(idAnnonce!=null)
                {
                  try{
                        intAnnonce = Integer.parseInt(idAnnonce );
                        Annonce annonce = greAnnonce.rechercherAnnonceParId(intAnnonce);
                        int idUtilisateur = greSecurite.obtenirIdentifiantUtilisateurFE(request);
                        //System.out.println("id utilisteur " + idUtilisateur);
                        Utilisateur utilisateur =greUtilisateur.rechercherUtilisateurParId(idUtilisateur);
                        
                        if(annonce!=null && utilisateur!=null)
                        {
                            Collection<Annonce> annonces= new ArrayList<>();
                            annonces.add(annonce);
                            
                            List<List<PhotoAnnonce>> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotosEnListe(annonces);
                            request.setAttribute("annonce", annonce);
                            request.setAttribute("photosAnnoncesUpdate", photosAnnonces);
                            PhotoAnnonce photo1 = new PhotoAnnonce();
                            PhotoAnnonce photo2 = new PhotoAnnonce();
                            PhotoAnnonce photo3 = new PhotoAnnonce();
                            
                            if(photosAnnonces!=null && photosAnnonces.size()>0)
                            {
                                List<PhotoAnnonce> listesDesPhotoPourCetteAnnonce = photosAnnonces.get(0);
                                for (int i = 0; i < listesDesPhotoPourCetteAnnonce.size(); i++) {
                                    switch(i)
                                    {
                                        case 0:
                                            photo1= listesDesPhotoPourCetteAnnonce.get(i);
                                            System.out.println("photo3 " + photo1.getNomLocalisation());
                                            request.setAttribute("photo1", photo1);
                                            break;
                                            
                                        case 1:
                                            photo2= listesDesPhotoPourCetteAnnonce.get(i);
                                            request.setAttribute("photo2", photo2);
                                            break;
                                            
                                        case 2:
                                            photo3= listesDesPhotoPourCetteAnnonce.get(i);
                                            System.out.println("photo3 " + photo3.getNomLocalisation());
                                            request.setAttribute("photo3", photo3);
                                            break;
                                            
                                    }
                                    
                                }
                                
                            }
                            
                            Ecole ecole = new Ecole();
                            Collection<EcoleUtilisateur> ecoleUtilisateurs = utilisateur.getEcoleUtilisateurs();

                            if (ecoleUtilisateurs != null && ecoleUtilisateurs.size() > 0) {
                                for (EcoleUtilisateur ecoleUtilisateur : ecoleUtilisateurs) {
                                    ecole = ecoleUtilisateur.getEcole();
                                    request.setAttribute("ecole", ecole);
                                    break;
                                }
                            }
                            
                            request.setAttribute("monTypeAnnonce", annonce.getTypeAnnonce().getLibelle());
                            request.setAttribute("idCategorie", annonce.getCategorie().getId());
                            request.setAttribute("urgenteAnnonce", annonce.isUrgente());
                            //request.getRequestDispatcher("modify-annonce.jsp").forward(request, response);
                            redirection= "modify-annonce.jsp";
                        }else{
                            // prevoit quelque chose peut être une redirection pas trouver l'annonce on le redirige vers la page des annonces
                           // request.getRequestDispatcher("ControllerCentralMesAnnonces").forward(request, response);
                            redirection= "ControllerCentralMesAnnonces";
                        }
                        
                    }catch(NumberFormatException formatException)
                    {
                        flatParsing=false;
                        System.out.println("Impossible de caster l'id de l'annonce controller Gerer Mes Annonces: controller central Mes Annonce valeur page " + idAnnonce);
                    }
                }
                
                request.getRequestDispatcher(redirection).forward(request, response);// c'est vraiment un intru
            }
            
            else if(request.getParameter("action")!=null && request.getParameter("action").equals("supprimerAnnonce")) 
            {
                String idAnnonceChaine = request.getParameter("idAnnonce");
                Annonce annonce = null;
                int intIdAnnonce = 0;
                
                try{
                        intIdAnnonce = Integer.parseInt(idAnnonceChaine);
                        annonce = greAnnonce.rechercherAnnonceParId(intIdAnnonce);
                        
                        if(annonce!=null)
                        {
                            String contextRealPath = getServletContext().getRealPath("/");
                            String locationFichier = contextRealPath + HelpClass.REPERTOIRE_PHOTOS_ANNONCE;
                            String remplace = "build"+File.separator;
                            locationFichier=locationFichier.replace(remplace, "");
                            
                            Collection<PhotoAnnonce> listesPhoto = annonce.getPhotos();
                            for (PhotoAnnonce photo : listesPhoto) {
                                String cheminCompletFichierSupprimer1 = locationFichier + File.separator + photo.getNomLocalisation();
                                 HelpClass.supprimerImageSurLeDisque(cheminCompletFichierSupprimer1);
                            }
                            

                            greAnnonce.supprimerAnnonce(annonce);
                        }
                        
                }catch(NumberFormatException numberException)
                {
                    System.out.println("impossible de caster l'id de l'annonce gestionnaire central mes annonces " + idAnnonceChaine + " " + numberException);
                }
                
                response.sendRedirect("ControllerCentralMesAnnonces?action=MesAnnonces");
            }
            /**
             * pour cette modification on aurait pu utiliser la page de création de l'annonce mais je craignais de tout faire....
             */
            else if(request.getParameter("action2")!=null && request.getParameter("action2").equals("updateFull")) 
            {
                
                String idAnnonceChaine = request.getParameter("idAnnonce");
                Annonce annonce = null;
                int intIdAnnonce = 0;
                
                String categorieAnnonce = null;
                String titreAnnonce = null;
                String textAnnonce = null;
                String prix = null;
                String type = null;
                String MarquerPhoneAnnce = null;
                String anncePart = null;
                
                int idCategorieAnnonce = 0;
                int idTypeAnnonce = 0;
                
                if(idAnnonceChaine!=null)
                {
                    try{
                        intIdAnnonce = Integer.parseInt(idAnnonceChaine);
                        annonce = greAnnonce.rechercherAnnonceParId(intIdAnnonce);
                        
                        /**
                         * LE VRAI BOULOT COMMENCE SI ON TROUVER L'ANNONCE
                         */
                        
                        categorieAnnonce = request.getParameter("categorieAnnonce");
                        type = request.getParameter("radios");
                        String urgenteAnnonce = request.getParameter("annonceUrgente");
                        prix = request.getParameter("prix");
                        MarquerPhoneAnnce = request.getParameter("MarquerPhone");
                     
                        
                        textAnnonce = request.getParameter("textAnnonce");
                        titreAnnonce = request.getParameter("titreAnnonce");
                        double prixDouble = 0.0;
                        
                        //System.out.println("urgente " + urgenteAnnonce + " categorie " + categorieAnnonce + " type " + type + " prix " + prix + " marquer " + MarquerPhoneAnnce);
                        //System.out.println("titre annonce " + titreAnnonce + " texte annonce " + textAnnonce);
                        
                          boolean flatIdTypeAnnonce = true, flatPrix = true;
                          boolean flatIdCategorie = true;
                        
                        if((categorieAnnonce != null && categorieAnnonce.length() > 0) && (type != null && type.length() > 0)) 
                        {
                            try {
                                idCategorieAnnonce = Integer.parseInt(categorieAnnonce);
                            } catch (NumberFormatException numberException) {
                                flatIdCategorie = false;
                                System.out.println("impossible de caster la categorie de l'annonce gestionnaire central mes annonces " + categorieAnnonce + " " + numberException);
                            }

                            try {
                                if (prix!=null && prix.length() > 0) {
                                    prixDouble = Double.parseDouble(prix);
                                } else {
                                    prixDouble = 0.0;
                                }

                            } catch (NumberFormatException numberException) {
                                flatPrix = false;
                                System.out.println("impossible de caster le cout de l'annonce gestionnaire central mes annonces " + prix + " " + numberException);
                            }
                            
                            if (flatIdCategorie) 
                            {
                                TypeAnnonce typeAnnonce = greAnnonce.rechercheTypeAnnonceParLibelle(type);
                                Categorie cat = greCategorie.rechercherCategorieParId(idCategorieAnnonce);
                                
                                if (typeAnnonce != null && cat != null) 
                                {
                                    annonce.setDescription(textAnnonce);
                                    annonce.setTitre(titreAnnonce);
                                    annonce.setCategorie(cat);
                                    annonce.setTypeAnnonce(typeAnnonce);
                                    annonce.setCout(prixDouble);
                                    
                                    if (urgenteAnnonce != null && urgenteAnnonce.equals("1")) 
                                    {
                                       annonce.setUrgente(true);
                                    } else{
                                       annonce.setUrgente(false);
                                    }

                                   if (MarquerPhoneAnnce != null && MarquerPhoneAnnce.equals("1")) {
                                       annonce.setMarquerPhoneAnnce(true);
                                    } else {
                                       annonce.setMarquerPhoneAnnce(false);
                                    }
                                   
                                    Collection<PhotoAnnonce> photosAnnonces = annonce.getPhotos();
                                    if(photosAnnonces!=null)
                                    {
                                        final Part filePart = request.getPart("fichier1");
                                        final Part filePart2 = request.getPart("fichier2");
                                        final Part filePart3 = request.getPart("fichier3");

                                        final String fileName1 = HelpClass.getFileName(filePart);
                                        final String fileName2 = HelpClass.getFileName(filePart2);
                                        final String fileName3 = HelpClass.getFileName(filePart3);
                                        
                                        ArrayList<String> listesChainesFichiers = new ArrayList<>();
                                        String contextRealPath = getServletContext().getRealPath("/");
                                        String locationFichier = contextRealPath + HelpClass.REPERTOIRE_PHOTOS_ANNONCE;
                                        String remplace = "build"+File.separator;
                                        locationFichier=locationFichier.replace(remplace, "");
                                        //System.out.println("file name1 " + fileName1 + " contextPath " + contextRealPath + " orignie " + locationFichier);
                                        
                                        if (fileName1 != null && fileName1.length() > 0) 
                                        {
                                            final String MfileName1 = HelpClass.ajoutInformationNomPhoto() + fileName1;
                                            String archiveFichier1 = locationFichier + File.separator + MfileName1;
                                            
                                            String ancienFichier1 = request.getParameter("oldFichier1");
                                            if(ancienFichier1!=null && !fileName1.equals(ancienFichier1))
                                            {
                                                String cheminCompletFichierSupprimer1 = locationFichier + File.separator + ancienFichier1;
                                                HelpClass.supprimerImageSurLeDisque(cheminCompletFichierSupprimer1);
                                                PhotoAnnonce annoncePhoto1 = greAnnonce.recherchePhotoAnnonce(ancienFichier1);
                                                
                                                if(annoncePhoto1!=null)
                                                {
                                                    greAnnonce.supprimerPhotoAnnonce(annoncePhoto1);
                                                }
                                            }
                                            
                                            PhotoAnnonce photo1 = new PhotoAnnonce();
                                            photo1.setNomLocalisation(MfileName1);
                                            photo1.setNomPropre(fileName1);
                                            annonce.addPhoto(photo1);
                                            //System.out.println("mfilename "+MfileName1 + " filename " + fileName1 +" archive " +archiveFichier1);
                                            HelpClass.ecritureImageSurLeDisque(filePart.getInputStream(), archiveFichier1);
                                        }
                                        
                                        if (fileName2 != null && fileName2.length() > 0)
                                        {

                                            final String MfileName2 = HelpClass.ajoutInformationNomPhoto() + fileName2;
                                            String archiveFichier2 = locationFichier + File.separator + MfileName2;
                                            
                                            String ancienFichier2 = request.getParameter("oldFichier2");
                                            if(ancienFichier2!=null && !fileName2.equals(ancienFichier2))
                                            {
                                                String cheminCompletFichierSupprimer2 = locationFichier + File.separator + ancienFichier2;
                                                HelpClass.supprimerImageSurLeDisque(cheminCompletFichierSupprimer2);
                                                PhotoAnnonce annoncePhoto2 = greAnnonce.recherchePhotoAnnonce(ancienFichier2);
                                                
                                                if(annoncePhoto2!=null)
                                                {
                                                    greAnnonce.supprimerPhotoAnnonce(annoncePhoto2);
                                                }
                                            }
                                            
                                            PhotoAnnonce photo2 = new PhotoAnnonce();
                                            photo2.setNomLocalisation(MfileName2);
                                            photo2.setNomPropre(fileName2);
                                            annonce.addPhoto(photo2);
                                            HelpClass.ecritureImageSurLeDisque(filePart2.getInputStream(), archiveFichier2);
                                        }
                                        if (fileName3 != null && fileName3.length() > 0) 
                                        {
                                            final String MfileName3 = HelpClass.ajoutInformationNomPhoto() + fileName3;
                                            String archiveFichier3 = locationFichier + File.separator + MfileName3;
                                            
                                            String ancienFichier3 = request.getParameter("oldFichier3");
                                            if(ancienFichier3!=null && !fileName3.equals(ancienFichier3))
                                            {
                                                String cheminCompletFichierSupprimer3 = locationFichier + File.separator + ancienFichier3;
                                                HelpClass.supprimerImageSurLeDisque(cheminCompletFichierSupprimer3);
                                                PhotoAnnonce annoncePhoto3 = greAnnonce.recherchePhotoAnnonce(ancienFichier3);
                                                
                                                if(annoncePhoto3!=null)
                                                {
                                                    greAnnonce.supprimerPhotoAnnonce(annoncePhoto3);
                                                }
                                            }
                                            PhotoAnnonce photo3 = new PhotoAnnonce();
                                            photo3.setNomLocalisation(MfileName3);
                                            photo3.setNomPropre(fileName3);
                                            annonce.addPhoto(photo3);
                                            HelpClass.ecritureImageSurLeDisque(filePart3.getInputStream(), archiveFichier3);
                                        }
                                       
                                    }
                                    greAnnonce.miseAjourAnnonce(annonce);
                                }
                            }
                        }// FIN DE LA CONDITION CATEGORIE ANNONCE
                        
                       
                    }catch (NumberFormatException numberException) {
                           
                        System.out.println("impossible de caster l'id de l'annonce pour la modification " + idAnnonceChaine + " " + numberException);
                    }
                }
                System.out.println("fin de update ");
                response.sendRedirect(HelpClass.PAGE_ACCUEIL_MES_ANNONCES);
                //request.getRequestDispatcher("ControllerCentralMesAnnonces").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
