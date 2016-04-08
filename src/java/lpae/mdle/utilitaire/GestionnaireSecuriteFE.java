/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lpae.entites.Utilisateur;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;

/**
 *
 * @author michel
 */
@Stateless
public class GestionnaireSecuriteFE {
    @PersistenceContext//(unitName = "LPAE2PU")
    private EntityManager em;
    
    @EJB
    private GreUtilisateur greUtilisateur;

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void verificationCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
         Cookie[] cookies = request.getCookies();
         String mdpEncrypted = "";
         String emailEncrypted ="";
         
        if(cookies != null) {
            for (int i = 0; i < cookies.length; i++) 
            {
                Cookie cookie = cookies[i];
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                if(cookieName.equals(HelpClass.COOKIE_NAME_EMAIL) && cookieValue.length()>0)
                {
                    emailEncrypted=cookieValue;
                }
                
                if(cookieName.equals(HelpClass.COOKIE_NAME_MDP) && cookieValue.length()>0)
                {
                    mdpEncrypted=cookieValue;
                }
                
            }
            
            if(mdpEncrypted.length()>0 && emailEncrypted.length()>0)
            {
                Utilisateur utilisateur = greUtilisateur.rechercheUtilisateurPourCookie(emailEncrypted, mdpEncrypted);
                HttpSession session = request.getSession();
                if(utilisateur!=null)
                {
                     session.setAttribute("idUserFrontEnd", utilisateur.getId());
                    session.setAttribute("loginUserFrontEnd", utilisateur.getLogin());
                }
               
            }
         }
    }
    
    /**
     * 
     * @param request
     * @return id de l'utilisateur dans la session
     */
    public Object getIdUtilisateurSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("idUserFrontEnd")!=null)
        {
            return  session.getAttribute("idUserFrontEnd");
        }else{
            return null;
        }
    }
    
    public void verificationAccesUtilisateurFE(String typeRequete, HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("idUser")==null )
        {
            try {
                request.getRequestDispatcher(HelpClass.PAGE_ACCUEIL_FRONT_END).forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(GestionnaireSecuriteFE.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
