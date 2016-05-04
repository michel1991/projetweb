/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.utilisateurs.gestionnaire;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import lpae.entites.Ecole;
import lpae.entites.Utilisateur;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author michel
 */
@Stateless
public class GreUtilisateur {
    @PersistenceContext//(unitName = "LPAE2PU")
    private EntityManager em;

    public Utilisateur persist(Utilisateur utilisateur) {
        em.persist(utilisateur);
        em.flush();
        return utilisateur;
    }
    
    
    public List<Utilisateur> obtenirTousLesUtilisateurs()
    {
        Query query =em.createQuery("SELECT u FROM Utilisateur u ORDER BY u.nom, u.prenom");
        return query.getResultList();
    }
    
    /**
     * 
     * @param email email de l'utilisateur pour se connecter
     * @param mdp mot de passe de l'utilisateur qui sera encrypter
     * @return 
     */
    public Utilisateur connectionUtilisateurFE(String email, String mdp)
    {
        Utilisateur user = null;
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(mdp);
        
        Query query =em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:email");
        System.out.println("email " + email + " mdp " +mdp + " encrypter " + encryptedPassword);
        query.setParameter("email", email);
       //.setParameter("mdp", encryptedPassword);
        
        try{
              user = (Utilisateur) query.getSingleResult();
        }catch(NoResultException noreE)
        {
            System.out.println("pas de resultat connection Utilisateur Front End Gestionnaire Utilisateur" + noreE.getMessage());
            user = null;
        }catch(NonUniqueResultException nonUnique)
        {
            user = null;
            System.out.println("plusieurs resultat connection Utilisateur Front End  Gestionnaire Utilisateur" + nonUnique.getMessage());
        }catch(IllegalStateException illegal)
        {
            user = null;
            System.out.println("paramètre de requete incorrect connection Utilisateur Front End  Gestionnaire Utilisateur" + illegal.getMessage());
        }
        
        return user;
    }
    /**
     * methode utile pour recherche les cookies dans le navigateur du client
     * @param emailEncrypted email encrypté
     * @param mdpEncrypted mdp encrypté
     * @return 
     */
    public Utilisateur rechercheUtilisateurPourCookie(String emailEncrypted, String mdpEncrypted)
    {
        Utilisateur user = null;
        Query query =em.createQuery("SELECT u FROM Utilisateur u WHERE u.emailEncode=:emailEncode AND u.mdp=:mdpEncrypted");
        
        query.setParameter("emailEncode", emailEncrypted);
        query.setParameter("mdpEncrypted", mdpEncrypted);
        
        try{
              user = (Utilisateur) query.getSingleResult();
        }catch(NoResultException noreE)
        {
            System.out.println("pas de resultat rechrche information pour cookies Front End Gestionnaire Utilisateur" + noreE.getMessage());
            user = null;
        }catch(NonUniqueResultException nonUnique)
        {
            user = null;
            System.out.println("plusieurs resultat rechrche information pour cookies Front End  Gestionnaire Utilisateur" + nonUnique.getMessage());
        }catch(IllegalStateException illegal)
        {
            user = null;
            System.out.println("paramètre de requete incorrect rechrche information pour cookies Utilisateur Front End  Gestionnaire Utilisateur" + illegal.getMessage());
        }
        
        return user;
    }
    
    /**
     * 
     * @param idUtilisateur
     * @return 
     */
    public Utilisateur rechercherUtilisateurParId(int idUtilisateur)
    {
        Utilisateur user =null;
        try{
             user = em.find(Utilisateur.class, idUtilisateur);
             
        }catch(IllegalArgumentException illegal)
        {
            user = null;
            System.out.println("illegal exception recherche utilisateur par id : gestionnaire utilisateur " +illegal.getMessage());
        }
        return user;
    }
    
    /**
     * Pour encoder l'email sous attend que l'email doit être unique dans la bd
     * @param utilisateur 
     */
    public void encoderEmailUtilisateurPourCookie(Utilisateur utilisateur,  String emailEncrypted)
    {
        //Utilisateur user =this.rechercherUtilisateurParId(idUtilisateur);
       utilisateur= em.merge(utilisateur);
       /*StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
       String encryptedPassword = passwordEncryptor.encryptPassword(utilisateur.getEmail());*/
       utilisateur.setEmailEncode(emailEncrypted);
        
    }
    
    public Utilisateur miseAjourUtilisateur(Utilisateur user)
    {
         Utilisateur utilisateur= null;
        try{
            utilisateur= em.find(Utilisateur.class, user.getId());
            utilisateur.setSexe(user.getSexe());
            utilisateur.setProfession(user.getProfession());
            utilisateur.setDetailProf(user.getDetailProf());
            utilisateur.setNom(user.getNom());
            utilisateur.setPrenom(user.getPrenom());
            utilisateur.setAdresse(user.getAdresse());
            utilisateur.setCp(user.getCp());
            utilisateur.setTel(user.getTel());
            utilisateur.setLogin(utilisateur.getLogin());
            utilisateur.setEmail(user.getEmail());
            utilisateur.setDetailCursus(user.getDetailCursus());
            utilisateur.setDateNaissance(user.getDateNaissance());
         }catch(TransactionRequiredException transaction)
        {
           
            System.out.println("Mise a jour Utilisateur Gestionnaire Utilisateur Transaction Utilisateur: " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
          
            System.out.println("Mise a jour Utilisateur TransactionEntiteNotFound Utilisateur: " + except.getMessage());
        }
        return utilisateur;
    }
    
    
    
}
