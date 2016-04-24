/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.ecole.gestionnaire;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import lpae.entites.Ecole;

/**
 *
 * @author michel
 */
@Stateless
public class GreEcole {
    @PersistenceContext//(unitName = "LPAEPU")
    private EntityManager em;

    public Collection<Ecole> obtenirToutesLesEcoles()
    {
        Query query =em.createQuery("SELECT ec FROM Ecole ec ORDER BY ec.nom");
        return query.getResultList();
    }
    
    public Ecole persist(Ecole ec) {
        em.persist(ec);
        em.flush();
        return ec;
    }
    
    public Ecole getEcoleById(int id)
    {
        Ecole ecole = null;
      try{
          ecole = em.find(Ecole.class,id);
      }catch(IllegalArgumentException illegal)
        {
            ecole = null;
            System.out.println("Obtenir Ecole par id IllegalException: Gestionnaire Ecole " + illegal.getMessage());
        }
      return ecole;
    }
    
    public Ecole miseAjourTypeCategorie(Ecole ec)
    {
         Ecole ecu = null;
        try{
            ecu= em.find(Ecole.class, ec.getId());
            ecu.setAdresse(ec.getAdresse());
            ecu.setCp(ec.getCp());
            ecu.setNom(ec.getNom());
         }catch(TransactionRequiredException transaction)
        {
           
            System.out.println("Mise a jour Type Transaction Transaction Ecole: " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
          
            System.out.println("Mise a jour Type TransactionEntiteNotFound Ecole: " + except.getMessage());
        }
        return ecu;
    }
    
    public int supprimerLesEcoles(int[] tableauIdEcole)
    {
        int resultat = 0;
        try{
            for (int u : tableauIdEcole) {
            Ecole ec = em.find(Ecole.class, u);
            if(ec!=null)
            {
                em.remove(ec);
            }
          }
        }catch(IllegalArgumentException illegal)
        {
            resultat=1;
            System.out.println("Suppression Ecoles IllegalException: Gestionnaire Ecole " + illegal.getMessage());
        }catch(TransactionRequiredException transaction)
        {
            resultat=1;
            System.out.println("Suppression Ecoles Transaction : Gestionnaire Ecole " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
            
            resultat=1;
            System.out.println("Suppression Ecoles EntiteNotFound Gestionnaire Ecole : " + except.getMessage());
        }
        return resultat;
    }
    
    /**
     * retourne une ecole sachant que le nom unique d'une ecole n'a pas étét gerer faire attention
     * @param nom
     * @return 
     */
    public List<Ecole> obtenirEcoleParNom(String nom)
    {
        Query query =em.createQuery("SELECT ec FROM Ecole ec WHERE ec.nom=:nomEcole ORDER BY ec.nom");
        query.setParameter("nomEcole", nom);
        return query.getResultList();
    }
}
