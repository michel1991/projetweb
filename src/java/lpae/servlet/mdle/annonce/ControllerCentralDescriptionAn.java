/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.annonce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lpae.annonce.gestionnaire.GreAnnonce;
import lpae.entites.Annonce;
import lpae.entites.Ecole;
import lpae.entites.EcoleUtilisateur;
import lpae.entites.PhotoAnnonce;
import lpae.entites.Utilisateur;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralDescriptionAn", urlPatterns = {"/ControllerCentralDescriptionAn"})
public class ControllerCentralDescriptionAn extends HttpServlet {

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
    private GreUtilisateur greUtilisateur;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            System.out.println("action " + action);
            if (action != null && action.equals("desc"));
            {
                String keyAnnonce = request.getParameter("flatI");
                boolean flatIdAnnonce = true;
                if (keyAnnonce != null && keyAnnonce.length() > 0) 
                {
                    try {
                        int idAnnonce = Integer.parseInt(keyAnnonce);
                        Annonce annonce = greAnnonce.rechercherAnnonceParId(idAnnonce);
                        if (annonce == null) {
                            annonce = new Annonce();
                        } else {
                            Collection<Annonce> annonceAEnvoyer = new ArrayList<>();
                            annonceAEnvoyer.add(annonce);
                            List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                            Utilisateur utilisateur = annonce.getUtilisateur();
                            //request.setAttribute("annonces", annonceAEnvoyer);
                            request.setAttribute("utilisateur", utilisateur);
                            if (utilisateur != null) {
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
                            request.setAttribute("photos", photosAnnonces);
                        }
                        request.setAttribute("annonce", annonce);
                    } catch (NumberFormatException numberException) {
                        flatIdAnnonce = false;
                        System.out.println("impossible de caster le type de l'annonce controller description produit " + keyAnnonce + " " + numberException);
                    }
                    
                    /**
                     * ANNONCE A UNE
                     */
                    Collection<Annonce> annoncesALaUne = greAnnonce.obtenirToutesLesAnnoncesALaUne(false, true);
                    //List<List<PhotoAnnonce>> photosAnnonce = greAnnonce.obtenirTableauDeToutesLesPhotosEnListe(annoncesALaUne);
                     List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annoncesALaUne);
                    
                    request.setAttribute("annonceALaUnes", annoncesALaUne);
                    request.setAttribute("photosAnnoncesAlaUne", photosAnnonces);
                    request.getRequestDispatcher("product.jsp").forward(request, response);
                } else {
                    // redirection vers les pages d'erreurs
                }
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
