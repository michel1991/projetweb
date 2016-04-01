/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.utilisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import lpae.servlet.mdle.annonce.ControllerCentralTypeAnnonce;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerUtilisateur", urlPatterns = {"/ControllerUtilisateur"})
public class ControllerUtilisateur extends HttpServlet {

    private final String PAGE_ACCUIEL_PRESENTATION="/admin/compteUtilisateur/accueilUtilisateur.jsp";
    
    @EJB
    private GestionnaireSecurite gestionnaireSecurite;
    
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
            System.out.println("utilisateur requete");
            gestionnaireSecurite.verificationAccesUtilisateurAdmin("redirection", request, response);
            try{
                String action = request.getParameter("action");
                //System.out.println("action voulu par l'utilisateur " + action);
                ObjectMapper mapper = new ObjectMapper();
                if(action!=null)
                {
                    request.setAttribute("informationSurAction", "Utilisateur");
                    switch (action)
                    {
                        case "accueil": {
                            request.getRequestDispatcher(PAGE_ACCUIEL_PRESENTATION).forward(request, response);
                            break;
                            
                        }
                        default:
                            request.getRequestDispatcher(ControllerCentralTypeAnnonce.PAGE_ACCUIEL_ADMIN).forward(request, response);

                    }
                    
                }
            }catch(IllegalStateException illegal){
                System.out.println("cannot forward " + illegal.getMessage());
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
