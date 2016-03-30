/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.categorie.gestionnaire;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import lpae.entites.Categorie;
import lpae.entites.TypeCategorie;
import lpae.mdle.utilitaire.HelpClass;

/**
 * Ce bean va gerer les types de categories et les categories
 * @author michel
 */
@Stateless
public class GreCategorie {
   @PersistenceContext//(unitName = "LPAEPU")
    private EntityManager em;

    public TypeCategorie persist(TypeCategorie tc) {
        tc.setDateCreation(HelpClass.getCurrentDate());
        em.persist(tc);
        em.flush();
        return tc;
    }
    
    public Categorie persistCategorie(Categorie c) {
        c.setDateCreation(HelpClass.getCurrentDate());
        em.persist(c);
        em.flush();
        return c;
    }
    
    public TypeCategorie getTypeCategorie(int idCategorie) {
       return  em.find(TypeCategorie.class, idCategorie);
    }

    /**
     * 
     * @return 
     */
    public Collection<TypeCategorie> obtenirToutesLesTypeDeCategorie()
    {
        Query query =em.createQuery("SELECT tc FROM TypeCategorie tc ORDER BY tc.nomTyp");
        return query.getResultList();
    }
    
    /**
     * 
     * @return 
     */
    public Collection<Categorie> obtenirToutesLesCategorie()
    {
        Query query =em.createQuery("SELECT c FROM Categorie c ORDER BY c.libelle");
        return query.getResultList();
    }
    
    
    /**
     * 
     * @param tc
     * @return 
     */
    
    public TypeCategorie miseAjourTypeCategorie(TypeCategorie tc)
    {
        TypeCategorie tcu = null;
        try{
              tcu= em.find(TypeCategorie.class, tc.getId());
            tcu.setNomTyp(tc.getNomTyp());
         }catch(TransactionRequiredException transaction)
        {
           
            System.out.println("Mise a jour Type Transaction Transaction : " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
          
            System.out.println("Mise a jour Type TransactionEntiteNotFound : " + except.getMessage());
        }
        return tcu;
    }
    
    public Categorie miseAjourCategorie(int idCategorie, Categorie c)
    {
        Categorie cu = null;
        try{
              cu= em.find(Categorie.class, idCategorie);
              cu.setLibelle(c.getLibelle());
              cu.setTypeCategorie(c.getTypeCategorie());
         }catch(TransactionRequiredException transaction)
        {
           
            System.out.println("Mise a jour Type Transaction Categorie : " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
          
            System.out.println("Mise a jour Type TransactionEntiteNotFound Categorie: " + except.getMessage());
        }
        return cu;
    }
    
    public int supprimerLesTypeCategorie(int[] tableauIdTypeCategorie)
    {
        int resultat = 0;
        try{
            for (int u : tableauIdTypeCategorie) {
            TypeCategorie tc = em.find(TypeCategorie.class, u);
            if(tc!=null)
            {
                em.remove(tc);
            }
          }
        }catch(IllegalArgumentException illegal)
        {
            resultat=1;
            System.out.println("Suppression TypeCategorie IllegalException: " + illegal.getMessage());
        }catch(TransactionRequiredException transaction)
        {
            resultat=1;
            System.out.println("Suppression TypeCategorie Transaction : " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
            
            resultat=1;
            System.out.println("Suppression TypeCategorie EntiteNotFound : " + except.getMessage());
        }
        return resultat;
    }
    
    /**
     * supprimer les categories
     * @param tableauIdCategorie
     * @return 
     */
    public int supprimerLesCategorie(int[] tableauIdCategorie)
    {
        int resultat = 0;
        try{
            for (int u : tableauIdCategorie) {
            Categorie c = em.find(Categorie.class, u);
            if(c!=null)
            {
                em.remove(c);
            }
          }
        }catch(IllegalArgumentException illegal)
        {
            resultat=1;
            System.out.println("Suppression Categorie IllegalException Gestionnaire categorie: " + illegal.getMessage());
        }catch(TransactionRequiredException transaction)
        {
            resultat=1;
            System.out.println("Suppression Categorie Transaction Gestionnaire categorie : " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
            
            resultat=1;
            System.out.println("Suppression Categorie EntiteNotFound Gestionnaire categorie: " + except.getMessage());
        }
        return resultat;
    }
    
    
    
}
