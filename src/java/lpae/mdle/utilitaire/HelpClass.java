/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author michel
 */
public class HelpClass {
    
    public static final String PAGE_ACCUEIL_FRONT_END="index.jsp";
    public static final String COOKIE_NAME_MDP="troc_student_cookie_mdp";
    public static final String COOKIE_NAME_EMAIL="troc_student_cookie_email";
    public static final String NOM_SERVLET_CONTROLLER_END="ServletControllerIndex";
    
    public static final int DUREE_COOKIE=172800; // DEUX JOURS EN SECONDE
    
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
}


