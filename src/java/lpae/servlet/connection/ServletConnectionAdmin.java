/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.connection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author michel
 */
@WebServlet(name = "ServletConnectionAdmin", urlPatterns = {"/ServletConnectionAdmin"})
public class ServletConnectionAdmin extends HttpServlet {

   private static final String LOGIN="tp2";
    
    private static final String PASSWORD="tp2";
    
    private static final int IDENTIFIANT=2015;
    public static String pageIndex = "admin/index.jsp";
    

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
            String connexion = request.getParameter("action");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            //int idUser = request.getSession()
            System.out.println("login " + login + " password " +password);
            
            if(connexion!=null && connexion.equals("con"))
            {
                if(password!=null && login!=null)
                {
                    if(login.equals(LOGIN) && password.equals(PASSWORD))
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("idUser", IDENTIFIANT);
                        session.setAttribute("messageConnexion", "Bienvenue " +LOGIN);
                        //request.setAttribute("messageConnection", "Bienvenue " + LOGIN);
                        response.sendRedirect(pageIndex);
                    }else{
                        response.sendRedirect(pageIndex+"?messageConnexion=Erreur identifiants de connexion");
                    }
                     
                }
                
            }else if(connexion!=null && connexion.equals("decon"))
            {
                HttpSession session = request.getSession();
                if(session!=null)
                {
                    
                    if(session.getAttribute("idUser")!=null || login==null || password==null)
                    {
                        try{
                              session.invalidate();
                        }catch(IllegalStateException exception){
                            System.out.println("Servlet Connection Invalidation session " +exception.getLocalizedMessage());
                        }
                        response.sendRedirect(pageIndex);
                    }
                }
            }else{
                response.sendRedirect(pageIndex);
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
