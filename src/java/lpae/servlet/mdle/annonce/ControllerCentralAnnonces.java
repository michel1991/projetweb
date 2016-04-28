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
import lpae.categorie.gestionnaire.GreCategorie;
import lpae.ecole.gestionnaire.GreEcole;
import lpae.entites.Annonce;
import lpae.entites.Categorie;
import lpae.entites.Ecole;
import lpae.entites.PhotoAnnonce;
import lpae.entites.TypeAnnonce;
import lpae.mdle.utilitaire.HelpClass;

/**
 *
 * @author michel
 */
@WebServlet(name = "ControllerCentralAnnonce", urlPatterns = {"/ControllerCentralAnnonce"})
public class ControllerCentralAnnonces extends HttpServlet {

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
    private GreEcole greEcole;
    
    @EJB
    private GreCategorie greCategorie;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            //System.out.println("action " + action);
            
             String page = request.getParameter("key");
             int pageInt = 0;
             boolean flatParsing = true;
             if(page==null)
             {
                 page="0";
             }
             
             try{
                   pageInt = Integer.parseInt(page);
             }catch(NumberFormatException formatException)
             {
                 flatParsing=false;
                 System.out.println("Impossible de caster la page : controller central Annonce valeur page " + page);
             }
            if((action!=null && action.equals("Offres")) || (action!=null && action.equals("Recherches")))
            {
                request.setAttribute("action", action);
                 request.setAttribute("whichAction", action);
                if(flatParsing)
                {
                    TypeAnnonce typeAnnonce = greAnnonce.rechercheTypeAnnonceParLibelle(action);//"Offres"
                    if(typeAnnonce!=null)
                    {
                        Collection<Annonce> annonces= greAnnonce.obtenirToutesLesAnnonces(typeAnnonce, false);

                        if(annonces!=null && annonces.size()>0)
                        {
                            //int nombreDePage = (int) Math.ceil(annonces.size()/HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
                            int nombreDePage = HelpClass.calculPagination(annonces.size());
                            //request.setAttribute("pagination", nombreDePage);
                            request.setAttribute("pagination", nombreDePage);
                            request.setAttribute("nbreAnnonce", annonces.size());
                            System.out.println("nombre de page " + nombreDePage);


                            Collection<Annonce> annonceAEnvoyer= greAnnonce.obtenirTouteAnnoncePage(pageInt, typeAnnonce, false);
                            List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                            request.setAttribute("annonces", annonceAEnvoyer);
                            request.setAttribute("photos", photosAnnonces);
                            //request.setAttribute("action", action);

                            System.out.println("nombre annonces " + annonceAEnvoyer.size() + " photos " +photosAnnonces.size());
                        }else{
                            request.setAttribute("nbreAnnonce", 0);
                        }
                        //request.getRequestDispatcher("offres.jsp").forward(request, response);

                    }else{
                        request.setAttribute("nbreAnnonce", 0);
                    }
                }
                
                request.getRequestDispatcher("offres.jsp").forward(request, response);
            }
            else if((action!=null && action.equals("Aecoles")))
            {
                String nomEcole = request.getParameter("nomEcole");
                request.setAttribute("nomEcole", nomEcole);
                request.setAttribute("action", "Par ecole");
                request.setAttribute("whichAction", action);
                
                if(nomEcole!=null)
                {
                    List<Ecole> ecoles = greEcole.obtenirEcoleParNom(nomEcole);
                    if(ecoles!=null && ecoles.size()>0)
                    {
                        Ecole ecole = ecoles.get(0);
                        System.out.println("ecole **********" + ecole);
                        List<Annonce> annonces= greAnnonce.obtenirAnnoncesEcole(ecole, false);
                        if(annonces!=null && annonces.size()>0)
                        {
                            int nombreDePage = HelpClass.calculPagination(annonces.size());
                            //request.setAttribute("pagination", nombreDePage);
                            request.setAttribute("pagination", nombreDePage);
                            request.setAttribute("nbreAnnonce", annonces.size());
                            System.out.println("nombre de page " + nombreDePage);
                            
                            // premier appel pageInt =0
                            Collection<Annonce> annonceAEnvoyer= greAnnonce. obtenirAnnonceParPageEcole(pageInt, ecole, false);
                            List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                            request.setAttribute("annonces", annonceAEnvoyer);
                            request.setAttribute("photos", photosAnnonces);
                            //request.setAttribute("action", action);
                        }else{
                          request.setAttribute("nbreAnnonce", 0);  
                        }
                    }else{
                        //pas de resultat renvoyer une liste vide
                         request.setAttribute("nbreAnnonce", 0); // je ne me rappelle plus de cette condition mais je l'ajoute
                    }
                }
                request.getRequestDispatcher("offres.jsp").forward(request, response); // redirection vers la page des offres
            } else if((action!=null && action.equals("rAnnonces")))
            {
                //String nomEcole = request.getParameter("nomEcole");
                request.setAttribute("action", "Par recherche");
                request.setAttribute("whichAction", action);
                
                Categorie categorie = null;
                Ecole ecole = null;
                
                String titre = request.getParameter("titreA");
                request.setAttribute("titreA", titre);
                
                String categorieiD = request.getParameter("cateId");
                //request.setAttribute("cateId", categorieiD);
                System.out.println("categorie ***" + categorieiD);
                
                String ecoleId = request.getParameter("ecoleId");
                
                
                boolean boolRechercheT = false; // pas de recherche par le titre
                boolean boolUrgenteT = false; // pas de recherche dans les annonces urgentes
                
                if(categorieiD!=null && categorieiD.length()>0)
                {
                    try{
                         int categorieInt = Integer.valueOf(categorieiD);
                         request.setAttribute("cateId", categorieInt);
                         
                         categorie = greCategorie.rechercherCategorieParId(categorieInt);
                         System.out.println("categorie " + categorie);
                         
                    }catch(NumberFormatException formatException)
                    {
                        System.out.println("erreur casting recherche annonce id catgorie " + categorieiD);
                        categorie =null;
                    }
                }
                
                if(ecoleId!=null && ecoleId.length()>0)
                {
                    try{
                         int ecoleInt = Integer.valueOf(ecoleId);
                         ecole = greEcole.getEcoleById(ecoleInt);
                         request.setAttribute("ecoleId", ecoleInt);
                         
                    }catch(NumberFormatException formatException)
                    {
                        System.out.println("erreur casting recherche annonce id ecole " + categorieiD);
                        ecole =null;
                    }
                }
                String other = request.getParameter("other");
                request.setAttribute("other", other);
                
                String rechercherT = request.getParameter("findT");
                request.setAttribute("findT", rechercherT);
                
                if(rechercherT!=null)
                {
                    if(rechercherT.equals("1"))
                    {
                        boolRechercheT= true; // recherche pas le titre
                    }else{
                        boolRechercheT=false;
                    }
                }
                String urgent = request.getParameter("urgent");
                request.setAttribute("urgent", urgent);
                
                if(urgent!=null)
                {
                    if(urgent.equals("1"))
                    {
                        boolUrgenteT= true; // recherche pas le titre
                    }else{
                        boolUrgenteT=false;
                    }
                }
                
                
                 List<Annonce> annonces =greAnnonce.rechercheAnnoncesParRecherche(titre, boolRechercheT ,false, categorie, ecole, other, boolUrgenteT);
                 System.out.println("ecole " +ecole + " categorie " + categorie + " size " + annonces.size());
                 if(annonces!=null && annonces.size()>0)
                {
                    int nombreDePage = HelpClass.calculPagination(annonces.size());
                    //request.setAttribute("pagination", nombreDePage);
                    request.setAttribute("pagination", nombreDePage);
                    request.setAttribute("nbreAnnonce", annonces.size());
                    System.out.println("nombre de page " + nombreDePage);

                    // premier appel pageInt =0
                    Collection<Annonce> annonceAEnvoyer= greAnnonce.obtenirAnnonceParPageRecherche(pageInt, titre, boolRechercheT ,false, categorie, ecole, other, boolUrgenteT);
                    List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                    request.setAttribute("annonces", annonceAEnvoyer);
                    request.setAttribute("photos", photosAnnonces);
                    //request.setAttribute("action", action);
                }else{
                  request.setAttribute("nbreAnnonce", 0);  
                }
                 
               request.getRequestDispatcher("offres.jsp").forward(request, response); // redirection vers la page des offres
               
                 
            }
            /*else if((action!=null && action.equals("take")))
            {
                String page = request.getParameter("key");
                String typeAnnonce = request.getParameter("about");
                try{
                    int pageInt = Integer.parseInt(page);
                    
                    if(typeAnnonce!=null)
                    {
                        TypeAnnonce typeAnnonceEntity = greAnnonce.rechercheTypeAnnonceParLibelle(typeAnnonce);
                        Collection<Annonce> annonces= greAnnonce.obtenirToutesLesAnnonces(typeAnnonceEntity, false);
                        
                        if(annonces!=null && annonces.size()>0)
                        {
                            int nombreDePage = HelpClass.calculPagination(annonces.size());
                            request.setAttribute("pagination", nombreDePage);
                            request.setAttribute("nbreAnnonce", annonces.size());
                            System.out.println("nombre de page " + nombreDePage);
                            
                            Collection<Annonce> annonceAEnvoyer= greAnnonce.obtenirTouteAnnoncePage(pageInt, typeAnnonceEntity, false);
                            List<PhotoAnnonce> photosAnnonces = greAnnonce.obtenirTableauDeToutesLesPhotos(annonceAEnvoyer);
                            request.setAttribute("annonces", annonceAEnvoyer);
                            request.setAttribute("photos", photosAnnonces);
                            request.setAttribute("action", typeAnnonce);
                            System.out.println("nombre annonces " + annonceAEnvoyer.size() + " photos " +photosAnnonces.size());
                        }
                    }
                    
                }catch(NumberFormatException formatException)
                {
                    
                }
                
                request.getRequestDispatcher("offres.jsp").forward(request, response);
            }*/
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
