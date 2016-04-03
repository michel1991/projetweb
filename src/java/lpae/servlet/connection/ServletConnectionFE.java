/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.connection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.HelpClass;
import static lpae.servlet.connection.ServletConnectionAdmin.pageIndex;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author michel
 */
@WebServlet(name = "ServletConnectionFE", urlPatterns = {"/ServletConnectionFE"})
public class ServletConnectionFE extends HttpServlet {

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
            /*Pour indiquer de l'action */
            String indice = request.getParameter("indice");
            if(indice!=null && indice.equals("connect"))
            {
                String email = request.getParameter("emailCFE");
                String mdp = request.getParameter("mdpCFE");
                String rememberMe = request.getParameter("rememberCFE");
                 StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                
                if(email!=null && email.length()>0 && mdp!=null && mdp.length()>0)
                {
                    
                    Utilisateur utilisateur = greUtilisateur.connectionUtilisateurFE(email, mdp);
                    if(utilisateur!=null && passwordEncryptor.checkPassword(mdp, utilisateur.getMdp()))/*les parametres de l'utilisateur sont corrects*/
                    {
                        //System.out.println("trouver");
                        HttpSession session = request.getSession();
                        session.setAttribute("idUserFrontEnd", utilisateur.getId());
                        session.setAttribute("loginUserFrontEnd", utilisateur.getLogin());
                        
                        if(rememberMe!=null && rememberMe.length()>0 && rememberMe.equals("1"))
                        {
                           
                            String encryptedEmail = passwordEncryptor.encryptPassword(String.valueOf(utilisateur.getEmail()));
                            //Cookie c = new Cookie(HelpClass.COOKIE_NAME_MDP, utilisateur.getMdp());
                            Cookie c = new Cookie(HelpClass.COOKIE_NAME_EMAIL, encryptedEmail);
                            Cookie c2 = new Cookie(HelpClass.COOKIE_NAME_MDP, utilisateur.getMdp());
                            
                            greUtilisateur.encoderEmailUtilisateurPourCookie(utilisateur, encryptedEmail); // encoder l'email sous attend que lemail doit être unique
                            c.setMaxAge(HelpClass.DUREE_COOKIE); //deux jours
                            response.addCookie(c);
                            response.addCookie(c2);
                            
                        }
                        response.sendRedirect("ServletControllerIndex?action=connectionSuccess");
                        
                    }else{
                        /**
                         * utilisateur non trouver parametre de connection incorrects
                         */
                        String informationComplementaire ="&email="+email+"&remember="+rememberMe; 
                        response.sendRedirect(HelpClass.NOM_SERVLET_CONTROLLER_END+"?action=connectionEchec"+informationComplementaire);
                    }
                    
                }else{
                    /**
                    * utilisateur non trouver parametre de connection incorrects
                    */
                    String informationComplementaire ="&email="+email+"&remember="+rememberMe; 
                    response.sendRedirect(HelpClass.NOM_SERVLET_CONTROLLER_END+"?action=connectionEchec"+informationComplementaire);
                }
            }else if (indice!=null && indice.equals("deconnect")){
               /*deconnection de l'utilisateur*/
                HttpSession session = request.getSession();
                if(session.getAttribute("idUserFrontEnd")!=null)
                    {
                        try{
                              session.invalidate();
                        }catch(IllegalStateException exception){
                            System.out.println("Servlet Connection frond end deconnection Invalidation session " +exception.getLocalizedMessage());
                        }
                        response.sendRedirect(HelpClass.PAGE_ACCUEIL_FRONT_END); // gestion des simples appels vers cette page
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
