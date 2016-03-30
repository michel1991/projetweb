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
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author michel
 */
@Stateless
public class GestionnaireSecurite {
   
    /**
     * Permet de verifier si l'utilisateur accès à la ressource
     * @param typeRequete type de requete
     * @param request
     * @param response 
     */
    private final String PAGE_ACCUIEL_PRESENTATION="/admin/region/accueilRegion.jsp";//region/accueilRegion.jsp  menuGauche.jsp
    
    public static final String PAGE_ACCUIEL_ADMIN="/admin/index.jsp";//region/accueilRegion.jsp  menuGauche.jsp
    
    public void verificationAccesUtilisateurAdmin(String typeRequete, HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession();
        if(session.getAttribute("idUser")==null )
        {
            try {
                    switch(typeRequete)
                    {
                        case "redirection":{
                            request.getRequestDispatcher(PAGE_ACCUIEL_ADMIN).forward(request, response);
                            break;
                        }
                        case "json":
                            mapper.writeValueAsString("intru!!");
                    }
                }catch (IOException ex) 
                {
                    Logger.getLogger(GestionnaireSecurite.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
    }
    
    /**
     * obtenir toutes les sous classes de annonce
     */
    public void sousClasseAnnoce()
    {
        try {
            Class c = Class.forName("lpae.entites.Annonce");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionnaireSecurite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
