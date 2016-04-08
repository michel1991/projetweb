/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.categorie;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lpae.categorie.gestionnaire.GreCategorie;
import lpae.entites.Categorie;
import lpae.entites.TypeCategorie;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralCategorie", urlPatterns = {"/ControllerCentralCategorie"})
public class ControllerCentralCategorie extends HttpServlet {
    @EJB
    private GestionnaireSecurite gestionnaireSecurite;

     @EJB
    private GreCategorie greCategorie;
    
    private final String PAGE_ACCUIEL_PRESENTATION="/admin/categorie/accueilCategorie.jsp";//
    
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
                    request.setAttribute("informationSurAction", "Categorie");
                    switch (action)
                    {
                        case "accueil": {
                            request.setAttribute("tc", greCategorie.obtenirToutesLesTypeDeCategorie());
                            //request.setAttribute("cg", greCategorie.obtenirToutesLesTypeDeCategorie());
                            request.getRequestDispatcher(PAGE_ACCUIEL_PRESENTATION).forward(request, response);
                            break;
                        }

                    }
                }
            }catch(IllegalStateException illegal){
                System.out.println("cannot forward controller central categorie" + illegal.getMessage());
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
            System.out.println("action post " + action);
            
            
            String libelle = null;
            String id = null;
            String typeCategorie = null;
            String isSousAnnonce = null;
            
            JSONParser parser = new JSONParser();
            try
            {
                if(action!=null && action.equals("add"))
                {
                    PrintWriter out = response.getWriter();
                   br= new BufferedReader(new InputStreamReader(request.getInputStream()));
                   String json = "";
                    if (br != null) {
                        json = br.readLine();
                    }
                    JSONObject jsonCategorie = new JSONObject();
                    if(json!=null && json.length()>0)
                    {
                        jsonCategorie = (JSONObject) parser.parse(json);
                        libelle = (String) jsonCategorie.get("libelle");
                        id = (String) jsonCategorie.get("id");
                        typeCategorie=(String) jsonCategorie.get("typeCategorie");
                        isSousAnnonce = (String) jsonCategorie.get("sousAnnoce"); // pas de modification prise pour cette valeur a faire plus tard
                      
                        if(libelle!=null && libelle.length()>0 && typeCategorie!=null && typeCategorie.length()>0)
                        {
                            Categorie categorie = new Categorie();
                            categorie.setLibelle(libelle);
                            if(isSousAnnonce!=null && isSousAnnonce.equals("1"))
                            {
                                categorie.setIsSubAnnonce(true); // sous annonce 
                            }else if(isSousAnnonce!=null && isSousAnnonce.equals("0"))
                            {
                                categorie.setIsSubAnnonce(false); // uniquement la table annonce
                            }else {
                                categorie.setIsSubAnnonce(false);
                            }
                            
                            try
                            {
                                int idTypeCategorie = Integer.parseInt(typeCategorie);
                                TypeCategorie  typeCat = greCategorie.getTypeCategorie(idTypeCategorie);
                                if(typeCat!=null)
                                {
                                    categorie.setTypeCategorie(typeCat);
                                    if(id!=null && id.length()==0)
                                    {
                                        categorie = greCategorie.persistCategorie(categorie);
                                        jsonCategorie.put("op", "add");
                                    }else{
                                        try{
                                            int idCategorie = Integer.parseInt(id);
                                            categorie = greCategorie.miseAjourCategorie(idCategorie, categorie);
                                            jsonCategorie.put("op", "upd");
                                        }
                                        catch(NumberFormatException numberFormatException){
                                            System.out.println("Erreur ControllerCentralCategorie au niveau du casting de l'id categorie update : " + id + " info "+ numberFormatException.getMessage());
                                        }
                                    }

                                    /**
                                     * verification pour la mise a jour
                                     */
                                    if(categorie!=null)
                                    {
                                        jsonCategorie.put("libelle", categorie.getLibelle());
                                        jsonCategorie.put("id", categorie.getId());
                                        jsonCategorie.put("libelleTypeCat", categorie.getTypeCategorie().getNomTyp());
                                        jsonCategorie.put("idTypeCat", categorie.getTypeCategorie().getId());
                                        jsonCategorie.put("sousAnnoce", categorie.isIsSubAnnonce());
                                    }

                                }
                                out.println(jsonCategorie);

                            }catch(NumberFormatException numberFormatException){
                                System.out.println("Erreur au niveau du casting du type de categorie: " + typeCategorie + " info "+ numberFormatException.getMessage());
                            }


                        }
                    } 
                }else if(action!=null && action.equals("data"))
                {
                    PrintWriter out = response.getWriter();
                    Collection<Categorie> listesCategories = greCategorie.obtenirToutesLesCategorie();
                    JSONArray jSONArray = new JSONArray();
                    for (Iterator<Categorie> iterator = listesCategories.iterator(); iterator.hasNext();) {
                        Categorie next = iterator.next();
                        JSONObject jsonCategorie = new JSONObject();
                        jsonCategorie.put("libelle", next.getLibelle());
                        jsonCategorie.put("id", next.getId());
                        jsonCategorie.put("libelleTypeCat", next.getTypeCategorie().getNomTyp());
                        jsonCategorie.put("idTypeCat", next.getTypeCategorie().getId());
                        jsonCategorie.put("sousAnnoce", next.isIsSubAnnonce());
                        jSONArray.add(jsonCategorie);
                        
                    }
                    out.println(jSONArray);
                }else if(action!=null && action.equals("delete"))
               {
                   br= new BufferedReader(new InputStreamReader(request.getInputStream()));
                    String json = "";
                    if (br != null) {
                        json = br.readLine();
                    }
                    int[] tableau = new int[4];
                    ObjectMapper mapper = new ObjectMapper();
                    int[] tableauId = mapper.readValue(json, tableau.getClass());
                    int resultat = 1;
                    if(tableauId!=null && tableauId.length>0)
                    {
                       resultat = greCategorie.supprimerLesCategorie(tableauId);
                        
                    }
                    //mapper.writeValueAsString(resultat);
                    System.out.println("resultat " + resultat);
                    mapper.writeValue(response.getOutputStream(), resultat);
               }
            }catch(ParseException ex){
                Logger.getLogger(ControllerCentralCategorie.class.getName()).log(Level.SEVERE, null, ex);
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
