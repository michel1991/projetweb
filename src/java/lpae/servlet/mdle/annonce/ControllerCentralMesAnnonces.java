/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.annonce;

import java.io.IOException;
import java.io.PrintWriter;
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
import lpae.entites.PhotoAnnonce;
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import lpae.mdle.utilitaire.HelpClass;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralMesAnnonces", urlPatterns = {"/ControllerCentralMesAnnonces"})
public class ControllerCentralMesAnnonces extends HttpServlet {
    @EJB
    private GreAnnonce greAnnonce;
   
    
     
    @EJB
    private GestionnaireSecurite greSecurite;
    
    @EJB
    private GreUtilisateur greUtilisateur;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            //System.out.println("action " + action);
            String page = request.getParameter("key");
            int pageInt = 0;
            boolean flatParsing = true;
            if(page==null)
            {
                page="0";
            }

            try{
                  pageInt = Integer.parseInt(page);
            }catch(NumberFormatException formatException)
            {
                flatParsing=false;
                System.out.println("Impossible de caster la page : controller central Mes Annonce valeur page " + page);
            }
            
            if((action!=null && action.equals("MesAnnonces")))
            {
                int idUtilisateur = greSecurite.obtenirIdentifiantUtilisateurFE(request);
                //System.out.println("id utilisteur " + idUtilisateur);
                Utilisateur utilisateur =null;
                if(idUtilisateur!=0)
                {
                    utilisateur = greUtilisateur.rechercherUtilisateurParId(idUtilisateur);
                    
                    if(utilisateur!=null)
                    {
                        Collection<Annonce> annonces= greAnnonce.obtenirToutesLesAnnoncesDeUtilisateur(utilisateur);

                        if(annonces!=null && annonces.size()>0)
                        {
                            int nombreDePage = HelpClass.calculPagination(annonces.size());
                            request.setAttribute("pagination", nombreDePage);
                            request.setAttribute("nbreAnnonce", annonces.size());
                            //System.out.println("nombre de page " + nombreDePage);


                            Collection<Annonce> annonceAEnvoyer= greAnnonce.obtenirToutesLesAnnoncesDeUtilisateurParPage(pageInt, utilisateur);
                            List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                            request.setAttribute("annoncesMesAnnonces", annonceAEnvoyer);
                            request.setAttribute("photosMesAnnonces", photosAnnonces);
                            //System.out.println("nombre annonces " + annonceAEnvoyer.size() + " photos " +photosAnnonces.size());
                        }else{
                            request.setAttribute("nbreAnnonce", 0);
                        }
                    }else{
                        request.setAttribute("nbreAnnonce", 0);
                    }
                }else{
                    request.setAttribute("nbreAnnonce", 0);
                }
                
                request.getRequestDispatcher("mes-annonces.jsp").forward(request, response);
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
