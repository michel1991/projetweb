/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import static lpae.entites.Utilisateur_.mdp;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author michel
 */
public class jasyptVerification {
    public static void main(String[] args) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword("michel");
        StrongPasswordEncryptor passwordEncryptor1 = new StrongPasswordEncryptor();
        if(passwordEncryptor1.checkPassword("michel", encryptedPassword))
        {
            System.out.println("trouver");
        }else{
           System.out.println("non trouver"); 
        }
    }
    
}
