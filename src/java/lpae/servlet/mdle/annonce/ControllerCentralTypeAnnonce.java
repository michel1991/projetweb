/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.annonce;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lpae.annonce.gestionnaire.GreAnnonce;
import lpae.entites.TypeAnnonce;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import org.json.simple.JSONObject;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralTypeAnnonce", urlPatterns = {"/ControllerCentralTypeAnnonce"})
public class ControllerCentralTypeAnnonce extends HttpServlet {
    @EJB
    private GreAnnonce greAnnonce;
    @EJB
    private GestionnaireSecurite gestionnaireSecurite;
    
    private final String PAGE_ACCUIEL_PRESENTATION="/admin/annonce/accueilTypeAnnonce.jsp";//
    
    public static final String PAGE_ACCUIEL_ADMIN="/admin/index.jsp";//region/accueilRegion.jsp  menuGauche.jsp
    
    
    
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
            gestionnaireSecurite.verificationAccesUtilisateurAdmin("redirection", request, response);
            try{
                String action = request.getParameter("action");
                //System.out.println("action voulu par l'utilisateur " + action);
                ObjectMapper mapper = new ObjectMapper();
                if(action!=null)
                {
                    request.setAttribute("informationSurAction", "Type Annonce");
                    switch (action)
                    {
                        case "accueil": {
                            request.setAttribute("ta", greAnnonce.obtenirToutesLesTypeAnnonces());
                            request.getRequestDispatcher(PAGE_ACCUIEL_PRESENTATION).forward(request, response);
                            break;
                        }

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
           BufferedReader br=null;
            String action = request.getParameter("action");
            //System.out.println("action post " + action);
            
            if(action!=null)
            {
                
               if(action.equals("add"))
               {
                    ObjectMapper mapper = new ObjectMapper();
                    PrintWriter out = response.getWriter();
                    br= new BufferedReader(new InputStreamReader(request.getInputStream()));
                    String json = "";
                    if (br != null) {
                        json = br.readLine();
                    }
                   
                    TypeAnnonce typeAnnonce = mapper.readValue(json, TypeAnnonce.class);
                    //System.out.println("Type annonce " + typeAnnonce);
                    JSONObject jsonTypeAnnonce = new JSONObject();
                    
                    if(typeAnnonce.getLibelle()!=null && typeAnnonce.getLibelle().length()>0)
                    {
                        if(typeAnnonce.getId()==0)
                        {
                            jsonTypeAnnonce.put("op", "add");
                            typeAnnonce = greAnnonce.persist(typeAnnonce);
                        }else{
                            jsonTypeAnnonce.put("op", "upd");
                            typeAnnonce = greAnnonce.miseAjourTypeCategorie(typeAnnonce);
                        }
                    }
                    if(typeAnnonce!=null)
                    {
                      jsonTypeAnnonce.put("libelle" , typeAnnonce.getLibelle());
                      jsonTypeAnnonce.put("id", typeAnnonce.getId());
                    }
                    out.println(jsonTypeAnnonce);
               }else if(action.equals("delete"))
               {
                   ObjectMapper mapper = new ObjectMapper();
                   br= new BufferedReader(new InputStreamReader(request.getInputStream()));
                    String json = "";
                    if (br != null) {
                        json = br.readLine();
                    }
                    int[] tableau = new int[4];
                    int[] tableauId = mapper.readValue(json, tableau.getClass());
                    int resultat = 1;
                    if(tableauId!=null && tableauId.length>0)
                    {
                        resultat=greAnnonce.supprimerLesTypeAnnonce(tableauId);
                        
                    }
                    //mapper.writeValueAsString(resultat);
                    mapper.writeValue(response.getOutputStream(), resultat);
               }
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
    }// </editor-fold>

}
