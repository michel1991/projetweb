/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author michel
 */
public class HelpClass {
    
    public static final String PAGE_ACCUEIL_FRONT_END="page-accueil.jsp";
    public static final String COOKIE_NAME_MDP="troc_student_cookie_mdp";
    public static final String COOKIE_NAME_EMAIL="troc_student_cookie_email";
    public static final String NOM_SERVLET_CONTROLLER_END="ServletControllerIndex";
    public static final String REPERTOIRE_PHOTOS_ANNONCE="resources"+ File.separator + "imagesAnnonces";
    public static final String MESSAGE_SUCCES_DEPOT_ANNONCE_ACTION="successDepotAnnonce";// message envoyer par la servlet depot annonce
    public static final String MESSAGE_UTILISATEUR_SUCCES_DEPOT_ANNONCE="Votre annonce sauvée";
    public static final String MESSAGE_ECHEC_DEPOT_ANNONCE_ACTION="echecDepotAnnonce";// envoyer par la sevlet centrale de depot d'annonce
    public static final String MESSAGE_UTILISATEUR_ECHEC_DEPOT_ANNONCE="Impossible de sauver votre annonce";// message final à destination de l'utilisateur
    public static final String MESSAGE_RESULTAT_ACTION="messageResultatAction"; // servira pour clé dans setAttribute pour tous les message à destionation de l'utilisateur
    
    public static final int MAX_DATA_TO_RETRIEVE_ANNONCE=10;
    public static final String PAGE_ACCUEIL_MES_ANNONCES="ControllerCentralMesAnnonces?action=MesAnnonces";
    
    public static final int DUREE_COOKIE=172800; // DEUX JOURS EN SECONDE
    
    public static final int NOMBRE_PHOTO=3;
    
    public static Date getCurrentDate()
    {
        DateTime dt = new DateTime();
        return dt.toDate();
    }
    
    public static Date getDateByString(String stringDate)
    {
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dt = formatter.parseDateTime(stringDate);
        return dt.toDate();
    }
    
    public static  void ecritureImageSurLeDisque(InputStream filecontent, String filePath) throws IOException {
        OutputStream out = null;
        try {

            out = new FileOutputStream(new File(filePath));
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

        } finally {

            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
    }
    
    
    /**
     * 
     * @param filePath chemin vers le fichier
     * @throws IOException 
     */
    public static void supprimerImageSurLeDisque(String filePath) throws IOException {
        File file = new File(filePath);
        if(file!=null && file.exists())
        {
           boolean resultat =file.delete();
        }
    }
    
   
    
    public static String getFileName(final Part part) {

        final String partHeader = part.getHeader("content-disposition");

        String[] sections = partHeader.split(";");
        String nomFichier = "";

        for (String content : sections) {

            if (content.trim().startsWith("filename")) {

                nomFichier = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                break;

            }

        }
        return nomFichier;
    }
    
    /**
     * methode permettant d'ajouter des informations pour différencier les photos
     * @return 
     */
    public static String ajoutInformationNomPhoto()
    {
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMddHHmmss");
        DateTime dt3 = new DateTime();
        return formatter.print(dt3);
    }
    
    /**
     * methode calculant la pagination pour le nombre des annonces à afficher par page
     * @param nombreElement
     * @return 
     */
    public static int calculPagination(int nombreElement)
    {
        System.out.println("nombre division help classe " +  Double.parseDouble(String.valueOf(nombreElement))/HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        double resultat =  Math.ceil(Double.parseDouble(String.valueOf(nombreElement))/HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        
        String conversion = String.valueOf(resultat);
        String partieEntiere  = "";
        int monResultatFinal = 0;
        if(conversion.contains("."))
        {
             partieEntiere = conversion.substring(0, conversion.indexOf("."));
             monResultatFinal = Integer.parseInt(partieEntiere);
             
        }else{
            monResultatFinal = Integer.parseInt(conversion);
        }
        //System.out.println("resultat " + resultat + " partie entiere " + monResultatFinal);
        //(int) Math.floor(nombreElement/HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE) avec cel
        return monResultatFinal;
    }
}


