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
import lpae.entites.PhotoAnnonce;
import lpae.entites.TypeAnnonce;
import lpae.mdle.utilitaire.HelpClass;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralAnnonce", urlPatterns = {"/ControllerCentralAnnonce"})
public class ControllerCentralAnnonces extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            //System.out.println("action " + action);
            if((action!=null && action.equals("Offres")) || (action!=null && action.equals("Recherches")))
            {
                TypeAnnonce typeAnnonce = greAnnonce.rechercheTypeAnnonceParLibelle(action);//"Offres"
                if(typeAnnonce!=null)
                {
                    Collection<Annonce> annonces= greAnnonce.obtenirToutesLesAnnonces(typeAnnonce, false);
                    
                    if(annonces!=null && annonces.size()>0)
                    {
                        //int nombreDePage = (int) Math.ceil(annonces.size()/HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
                        int nombreDePage = HelpClass.calculPagination(annonces.size());
                        //request.setAttribute("pagination", nombreDePage);
                        request.setAttribute("pagination", nombreDePage);
                        request.setAttribute("nbreAnnonce", annonces.size());
                        System.out.println("nombre de page " + nombreDePage);
                        
                        
                        Collection<Annonce> annonceAEnvoyer= greAnnonce.obtenirTouteAnnoncePage(0, typeAnnonce, false);
                        List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                        request.setAttribute("annonces", annonceAEnvoyer);
                        request.setAttribute("photos", photosAnnonces);
                        request.setAttribute("action", action);
                        
                        System.out.println("nombre annonces " + annonceAEnvoyer.size() + " photos " +photosAnnonces.size());
                    }else{
                        request.setAttribute("nbreAnnonce", 0);
                    }
                    //request.getRequestDispatcher("offres.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("nbreAnnonce", 0);
                }
                request.getRequestDispatcher("offres.jsp").forward(request, response);
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
