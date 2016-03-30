/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author michel
 */
public class HelpClass {
    public static Date getCurrentDate()
    {
        DateTime dt = new DateTime();
        return dt.toDate();
    }
}
