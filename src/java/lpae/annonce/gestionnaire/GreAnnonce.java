/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.annonce.gestionnaire;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import lpae.entites.TypeAnnonce;

/**
 *
 * @author michel
 */
@Stateless
public class GreAnnonce {

    @PersistenceContext//(unitName = "LPAEPU")
    private EntityManager em;
    
    
    public Collection<TypeAnnonce> obtenirToutesLesTypeAnnonces()
    {
        Query query =em.createQuery("SELECT ta FROM TypeAnnonce ta ORDER BY ta.libelle");
        return query.getResultList();
    }
    
    public TypeAnnonce persist(TypeAnnonce ta) {
        em.persist(ta);
        em.flush();
        return ta;
    }
    
    public TypeAnnonce miseAjourTypeCategorie(TypeAnnonce ta)
    {
        return em.merge(ta);
    }
    
    public int supprimerLesTypeAnnonce(int[] tableauIdTypeAnnonce)
    {
        int resultat = 0;
        try{
            for (int u : tableauIdTypeAnnonce) {
            TypeAnnonce ta = em.find(TypeAnnonce.class, u);
            if(ta!=null)
            {
                em.remove(ta);
            }
          }
        }catch(IllegalArgumentException illegal)
        {
            resultat=1;
            System.out.println("Suppression TypeAnnonce IllegalException: Gestionnaire annonce " + illegal.getMessage());
        }catch(TransactionRequiredException transaction)
        {
            resultat=1;
            System.out.println("Suppression TypeCategorie Transaction : Gestionnaire annonce " + transaction.getMessage());
        }catch(EntityNotFoundException except)
        {
            
            resultat=1;
            System.out.println("Suppression TypeCategorie EntiteNotFound Gestionnaire annonce : " + except.getMessage());
        }
        return resultat;
    }
}
