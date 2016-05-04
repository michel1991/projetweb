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
import lpae.entites.Ecole;
import lpae.entites.EcoleUtilisateur;
import lpae.entites.PhotoAnnonce;
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.GestionnaireSecurite;
import lpae.utilisateurs.gestionnaire.GreUtilisateur;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentrerGererMesAnnonces", urlPatterns = {"/ControllerCentrerGererMesAnnonces"})
public class ControllerCentrerGererMesAnnonces extends HttpServlet {

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
     
    @EJB
    private GestionnaireSecurite greSecurite;
    
    @EJB
    private GreUtilisateur greUtilisateur;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String redirection ="ServletControllerIndex";
            
            /**
             *  J AI PAS GERER LE CAS DES ECHECS AVEC CETTE CLASSE
             */
            if((action!=null && action.equals("freshToAll")))
            {
                String idAnnonce = request.getParameter("keyPlot");
                int intAnnonce = 0;
                boolean flatParsing = true;
                
                if(idAnnonce!=null)
                {
                  try{
                        intAnnonce = Integer.parseInt(idAnnonce );
                        Annonce annonce = greAnnonce.rechercherAnnonceParId(intAnnonce);
                        int idUtilisateur = greSecurite.obtenirIdentifiantUtilisateurFE(request);
                        //System.out.println("id utilisteur " + idUtilisateur);
                        Utilisateur utilisateur =greUtilisateur.rechercherUtilisateurParId(idUtilisateur);
                        
                        if(annonce!=null && utilisateur!=null)
                        {
                            Collection<Annonce> annonces= new ArrayList<>();
                            annonces.add(annonce);
                            
                            List<List<PhotoAnnonce>> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotosEnListe(annonces);
                            request.setAttribute("annonce", annonce);
                            request.setAttribute("photosAnnoncesUpdate", photosAnnonces);
                            
                            Ecole ecole = new Ecole();
                            Collection<EcoleUtilisateur> ecoleUtilisateurs = utilisateur.getEcoleUtilisateurs();

                            if (ecoleUtilisateurs != null && ecoleUtilisateurs.size() > 0) {
                                for (EcoleUtilisateur ecoleUtilisateur : ecoleUtilisateurs) {
                                    ecole = ecoleUtilisateur.getEcole();
                                    request.setAttribute("ecole", ecole);
                                    break;
                                }
                            }
                            
                            request.setAttribute("monTypeAnnonce", annonce.getTypeAnnonce().getLibelle());
                            request.setAttribute("idCategorie", annonce.getCategorie().getId());
                            request.setAttribute("urgenteAnnonce", annonce.isUrgente());
                            //request.getRequestDispatcher("modify-annonce.jsp").forward(request, response);
                            redirection= "modify-annonce.jsp";
                        }else{
                            // prevoit quelque chose peut être une redirection pas trouver l'annonce on le redirige vers la page des annonces
                           // request.getRequestDispatcher("ControllerCentralMesAnnonces").forward(request, response);
                            redirection= "ControllerCentralMesAnnonces";
                        }
                        
                    }catch(NumberFormatException formatException)
                    {
                        flatParsing=false;
                        System.out.println("Impossible de caster l'id de l'annonce controller Gerer Mes Annonces: controller central Mes Annonce valeur page " + idAnnonce);
                    }
                }
                
                request.getRequestDispatcher(redirection).forward(request, response);// c'est vraiment un intru
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
