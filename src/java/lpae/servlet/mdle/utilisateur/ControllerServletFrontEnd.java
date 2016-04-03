/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.servlet.mdle.utilisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;
import lpae.ecole.gestionnaire.GreEcole;
import lpae.entites.Ecole;
import lpae.entites.EcoleUtilisateur;
import lpae.entites.Region;
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import lpae.mdle.utilitaire.HelpClass;
import lpae.region.gestionnaire.GestRegion;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerServletFrontEnd", urlPatterns = {"/ControllerServletFrontEnd"})
public class ControllerServletFrontEnd extends HttpServlet {

    @EJB
    private GestionnaireSecurite gestionnaireSecurite;
    
     @EJB
    private GreEcole greEcole;
     
     @EJB
    private GreUtilisateur greUtilisateur;
     
     @EJB
     private GestRegion greRegion;
     
    public static final String PAGE_ACCUIEL_PRESENTATION="creer-compte.jsp";
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
            
            //gestionnaireSecurite.verificationAccesUtilisateurAdmin("redirection", request, response); // apres ce module je passe à la connection
            
            String action = request.getParameter("action");
                //System.out.println("action voulu par l'utilisateur " + action);
                ObjectMapper mapper = new ObjectMapper();
                if(action!=null)
                {
                    switch (action)
                    {
                        case "accueil": {
                            Collection<Region> regions = greRegion.obtenirToutesLesRegions();
                            request.setAttribute("regions", regions);
                            request.getRequestDispatcher(PAGE_ACCUIEL_PRESENTATION).forward(request, response);
                            break;
                            
                        }
                        default:
                            request.getRequestDispatcher(HelpClass.PAGE_ACCUEIL_FRONT_END).forward(request, response);

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
         String action = request.getParameter("action");
            //System.out.println("action post " + action);
            JSONParser parser = new JSONParser();
            BufferedReader br=null;
            String civilte = null;
            String profession = null;
            String detailProf= null;
            String nom = null;
            String prenom = null;
            String adresse = null;
            String cp = null;
            String tel=null;
            String dateN=null;
            String login =null;
            String mdp = null;
            String ecole = null;
            String descF = null;
            String email = null;
            String recevoirOffre = null;
            String acceptationCondition = null;
            try
            {
                if(action!=null)
                {
                    if(action.equals("add"))
                   {
                        PrintWriter out = response.getWriter();
                       br= new BufferedReader(new InputStreamReader(request.getInputStream()));
                       String json = "";
                        if (br != null) {
                            json = br.readLine();
                        }
                        JSONObject jsonUtilisateur = new JSONObject();
                        if(json!=null && json.length()>0)
                        {
                            jsonUtilisateur = (JSONObject) parser.parse(json);
                            civilte = (String) jsonUtilisateur.get("civilite");
                            profession = (String) jsonUtilisateur.get("profession");
                            detailProf = (String) jsonUtilisateur.get("detailProf");
                            
                            nom = (String) jsonUtilisateur.get("nom");
                            prenom = (String) jsonUtilisateur.get("prenom");
                            adresse = (String) jsonUtilisateur.get("adresse");
                            cp = (String) jsonUtilisateur.get("cp");
                            
                            tel = (String) jsonUtilisateur.get("myPhone");
                            dateN= (String) jsonUtilisateur.get("dateN");
                            login = (String) jsonUtilisateur.get("login");
                            mdp = (String) jsonUtilisateur.get("mdp");
                            
                            ecole= (String) jsonUtilisateur.get("ecole");
                            descF = (String) jsonUtilisateur.get("descF");
                            email = (String) jsonUtilisateur.get("email");
                            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                            recevoirOffre=(String) jsonUtilisateur.get("recevoirOffre");
                            acceptationCondition=(String) jsonUtilisateur.get("acceptCondi");
                            
                            if(ecole!=null && ecole.length()>0)
                            {
                                try{
                                      int idEcole = Integer.parseInt(ecole);
                                      Ecole ecoleEntity = greEcole.getEcoleById(idEcole);
                                        if(ecoleEntity!=null)
                                        {
                                            Utilisateur utilisateur = new Utilisateur();
                                            utilisateur.setSexe(civilte);
                                            utilisateur.setProfession(profession);
                                            utilisateur.setDetailProf(detailProf);
                                            utilisateur.setNom(nom);
                                            utilisateur.setPrenom(prenom);
                                            utilisateur.setAdresse(adresse);
                                            utilisateur.setCp(cp);
                                            utilisateur.setTel(tel);
                                            if(dateN!=null && dateN.length()>0)
                                            {
                                                utilisateur.setDateNaissance(HelpClass.getDateByString(dateN));
                                            }

                                            utilisateur.setLogin(login);
                                            mdp = passwordEncryptor.encryptPassword(mdp);
                                            utilisateur.setMdp(mdp);
                                            EcoleUtilisateur ecoleUtilisateur = new EcoleUtilisateur();
                                            ecoleUtilisateur.setUtilisateur(utilisateur);
                                            ecoleUtilisateur.setEcole(ecoleEntity);
                                            utilisateur.addEcoleUtilisateur(ecoleUtilisateur);
                                            utilisateur.setDetailCursus(descF);
                                            utilisateur.setEmail(email);
                                            
                                            if(recevoirOffre!=null && recevoirOffre.equals("1"))
                                            {
                                                 utilisateur.setRecevoirOffre(true);
                                            }else{
                                                utilisateur.setRecevoirOffre(false);
                                            }
                                            
                                            if(acceptationCondition!=null && acceptationCondition.equals("1"))
                                            {
                                                 utilisateur.setAcceptCondi(true);
                                            }else{
                                                utilisateur.setAcceptCondi(false);
                                            }

                                            utilisateur.setDateCreation(HelpClass.getCurrentDate());
                                            utilisateur = greUtilisateur.persist(utilisateur);
                                            HttpSession session = request.getSession();
                                            session.setAttribute("idUserFrontEnd", utilisateur.getId());
                                            session.setAttribute("loginUserFrontEnd", utilisateur.getLogin());
                                            
                                            jsonUtilisateur.put("result", "success");
                                            jsonUtilisateur.put("id", utilisateur.getId());
                                            
                                        }
                                        out.println(jsonUtilisateur);
                                      
                                      
                                }catch(NumberFormatException numberFormatException)
                                {
                                  System.out.println("Erreur au niveau du casting de l'id de l' Ecole controller Gestion Utilisateur: " + ecole + " info "+ numberFormatException.getMessage());
                                }
                                
                            }
                            
                        
                            
                            
                            
                        }
                   }else if(action.equals("dataEcole"))
                   {
                       PrintWriter out = response.getWriter();
                        Collection<Ecole> listesEcoles = greEcole.obtenirToutesLesEcoles();
                        JSONArray jSONArray = new JSONArray();
                        for (Iterator<Ecole> iterator = listesEcoles.iterator(); iterator.hasNext();) {
                        Ecole next = iterator.next();
                        JSONObject jsonEcole = new JSONObject();
                        jsonEcole.put("nom", next.getNom());
                        jsonEcole.put("id", next.getId());
                       
                        jSONArray.add(jsonEcole);
                        
                    }
                    out.println(jSONArray);
                   }
                }
            }catch(ParseException ex){
                Logger.getLogger(ControllerUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
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
