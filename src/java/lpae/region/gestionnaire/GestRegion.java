/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.region.gestionnaire;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import lpae.entites.Region;
import lpae.mdle.utilitaire.HelpClass;

/**
 *
 * @author michel
 */
@Stateless
public class GestRegion {
    @PersistenceContext//(unitName = "LPAE2PU")
    private EntityManager em;

    /**
     * Ajouter une region
     * @param region 
     * @return  
     */
    public Region persiste(Region region) {
        
        region.setDateCreatRegion(HelpClass.getCurrentDate());
        em.persist(region);
        em.flush();
        return region;
    }

    /**
     * obtenir la liste des regions
     * @return 
     */
    public List<Region> obtenirToutesLesRegions()
    {
        Query query =em.createQuery("SELECT r FROM Region r ORDER BY r.nomRe");
        return query.getResultList();
    }
    
    /**
     *  Supprime les regions
     * @param tableauIdRegion tableau des id
     * @return resultat flat pour savoir si la suppression s'est bien deroulé
     */
    public int supprimerLesRegions(int[] tableauIdRegion)
    {
        int resultat = 0;
        try{
            for (int u : tableauIdRegion) {
            Region r = em.find(Region.class, u);
            if(r!=null)
            {
                em.remove(r);
            }
          }
        }catch(IllegalArgumentException illegal)
        {
            resultat=1;
            System.out.println("Suppression Region IllegalException: " + illegal.getMessage());
        }catch(TransactionRequiredException transaction)
        {
            resultat=1;
            System.out.println("Suppression Region Transaction : " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
            
            resultat=1;
            System.out.println("Suppression Region EntiteNotFound : " + except.getMessage());
        }
        return resultat;
    }
    
    public Region miseAjour(Region r)
    {
        Region regionUpdate = null;
        try{
              regionUpdate= em.find(Region.class, r.getId());
             regionUpdate.setNomRe(r.getNomRe());
         }catch(TransactionRequiredException transaction)
        {
           
            System.out.println("Mise a jour Region Transaction : " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
          
            System.out.println("Mise a jour Region EntiteNotFound : " + except.getMessage());
        }
        return regionUpdate;
    }
    
    
    
}
