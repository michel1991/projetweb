/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.ecole;

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
import lpae.ecole.gestionnaire.GreEcole;
import lpae.entites.Ecole;
import lpae.entites.TypeAnnonce;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import org.json.simple.JSONObject;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralEcole", urlPatterns = {"/ControllerCentralEcole"})
public class ControllerCentralEcole extends HttpServlet {
    @EJB
    private GreEcole greEcole;

    private final String PAGE_ACCUIEL_PRESENTATION="/admin/ecole/accueilEcole.jsp";//
    
    public static final String PAGE_ACCUIEL_ADMIN="/admin/index.jsp";
    
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
            gestionnaireSecurite.verificationAccesUtilisateurAdmin("redirection", request, response);
            try{
                String action = request.getParameter("action");
                //System.out.println("action voulu par l'utilisateur " + action);
                ObjectMapper mapper = new ObjectMapper();
                if(action!=null)
                {
                    request.setAttribute("informationSurAction", "Ecole");
                    switch (action)
                    {
                        case "accueil": {
                            request.setAttribute("ecoles", greEcole.obtenirToutesLesEcoles());
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
                   
                    Ecole ecole = mapper.readValue(json, Ecole.class);
                    System.out.println("Ecole " + ecole);
                    JSONObject jsonEcole = new JSONObject();
                    
                    if(ecole.getId()==0)
                        {
                            jsonEcole.put("op", "add");
                            ecole = greEcole.persist(ecole);
                        }else{
                            jsonEcole.put("op", "upd");
                            ecole = greEcole.miseAjourTypeCategorie(ecole);
                        }
                    if(ecole!=null)
                    {
                      jsonEcole.put("nom" , ecole.getNom());
                      jsonEcole.put("id", ecole.getId());
                      jsonEcole.put("cp", ecole.getCp());
                      jsonEcole.put("adresse", ecole.getAdresse());
                    }
                    out.println(jsonEcole);
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
                        resultat=greEcole.supprimerLesEcoles(tableauId);
                        
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
