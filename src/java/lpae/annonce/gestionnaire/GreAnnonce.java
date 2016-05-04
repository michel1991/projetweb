/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.annonce.gestionnaire;

import java.util.ArrayList;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lpae.entites.Annonce;
import lpae.entites.Categorie;
import lpae.entites.Ecole;
import lpae.entites.PhotoAnnonce;
import lpae.entites.TypeAnnonce;
import lpae.entites.Utilisateur;
import lpae.mdle.utilitaire.HelpClass;

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
    
    /**
     * 
     * @param a
     * @return 
     */
    public Annonce persist(Annonce annonce) {
        em.persist(annonce);
        em.flush();
        return annonce;
    }
    
    /**
     * mise à jour d'un type d'anonce
     * @param ta
     * @return 
     */
    public TypeAnnonce miseAjourTypeCategorie(TypeAnnonce ta)
    {
        return em.merge(ta);
    }
    
    /**
     * methode permettant de mettre à jour une annonce
     * @param annonce
     * @return 
     */
    public Annonce miseAjourAnnonce(Annonce annonce)
    {
        return em.merge(annonce);
    }
    
    /**
     * Methode permettant de supprimer des types d'annonces par leur id
     * supprimer un type d'annonce
     * @param tableauIdTypeAnnonce
     * @return 
     */
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
    
    /**
     * 
     * @param libelle
     * @return 
     */
    public TypeAnnonce rechercheTypeAnnonceParLibelle(String libelle)
    {
        Query query =em.createQuery("SELECT ta FROM TypeAnnonce ta WHERE ta.libelle=:libelle");
        query.setParameter("libelle", libelle);
        List<TypeAnnonce> typeAnnonces = query.getResultList();
        if(typeAnnonces!=null && typeAnnonces.size()>0)
        {
            return typeAnnonces.get(0);
        }else{
            return null;
        }
    }
    
   /**
    * 
    * @param typeAnnonce
    * @param etat
    * @return 
    */
    public Collection<Annonce> obtenirToutesLesAnnonces(TypeAnnonce typeAnnonce, boolean etat) {
        Query q = em.createQuery("select a from Annonce a WHERE a.typeAnnonce=:typeAnnonce AND a.etat=:etat ORDER BY a.dateCreation, a.titre");
        //ORDER BY u.lastname ASC
        q.setParameter("typeAnnonce", typeAnnonce);
        q.setParameter("etat", etat);
        
        //.setParameter("alaune", false);
        
        return q.getResultList();
    }
    
    
    /**
     * méthode pour récuperer toutes les annonces de l'utilisateur et il pourra les supprimer ou les modifier
     * @param utilisateur utilisateur à qui les annonces appartiennet
     * @return 
     */
    public Collection<Annonce> obtenirToutesLesAnnoncesDeUtilisateur(Utilisateur utilisateur) {
        Query q = em.createQuery("select a from Annonce a WHERE a.utilisateur=:utilisateur ORDER BY a.dateCreation, a.titre");
        //ORDER BY u.lastname ASC
        q.setParameter("utilisateur", utilisateur);
        return q.getResultList();
    }
    
    /**
     * 
     * @param start curseur indiquant le début de la recherche
     * @param utilisateur
     * @return 
     */
    public  List<Annonce> obtenirToutesLesAnnoncesDeUtilisateurParPage(int start, Utilisateur utilisateur) 
    {
        Query q = em.createQuery("SELECT a FROM Annonce a WHERE a.utilisateur=:utilisateur ORDER BY a.dateCreation, a.titre");//ORDER BY u.lastname ASC
        q.setFirstResult(start*HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        q.setParameter("utilisateur", utilisateur);
        q.setMaxResults(HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        return q.getResultList();
    }
    
    
   
    /**
     * 
     * @param etat
     * @param alaUne
     * @return 
     */
    public Collection<Annonce> obtenirToutesLesAnnoncesALaUne(boolean etat, boolean alaUne) {
        Query q = em.createQuery("select a from Annonce a WHERE a.etat=:etat AND a.alaUne=:alaUne ORDER BY a.dateCreation, a.titre");
        q.setParameter("etat", etat);
        q.setParameter("alaUne", alaUne);
        return q.getResultList();
    }
    
   
    
   
    /**
     * 
     * @param start pointeur du curseur vers une page de début
     * @return 
     */
    public  Collection<Annonce> obtenirTouteAnnoncePage(int start, TypeAnnonce typeAnnonce, boolean etat) 
    {
        Query q = em.createQuery("select a from Annonce a WHERE a.typeAnnonce=:typeAnnonce AND a.etat=:etat ORDER BY a.dateCreation, a.titre");//ORDER BY u.lastname ASC
        q.setFirstResult(start*HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        q.setParameter("typeAnnonce", typeAnnonce);
        q.setParameter("etat", etat);
        q.setMaxResults(HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        return q.getResultList();
    }
    
    /**
     * 
     * @return 
     */
    public Collection<Annonce> obtenirToutesLesAnnoncesEtudiant(TypeAnnonce typeAnnonce, boolean etat) {
        Query q = em.createQuery("select a from Annonce a JOIN a.utilisateur u WHERE a.typeAnnonce=:typeAnnonce AND a.etat=:etat ORDER BY a.dateCreation, a.titre");//ORDER BY u.lastname ASC
        q.setParameter("typeAnnonce", typeAnnonce);
        q.setParameter("etat", etat);
        return q.getResultList();
    }
    
    /**
     * obtenir toutes les annonces etudiants par page
     * @param startPage
     * @return 
     */
    public Collection<Annonce> obtenirLesAnnoncesEtudiantParPage(int startPage, TypeAnnonce typeAnnonce, boolean etat)
    {
        Query q = em.createQuery("select a from Annonce a JOIN a.utilisateur u WHERE a.typeAnnonce=:typeAnnonce AND etat=:etat ORDER BY a.dateCreation, a.titre");
        q.setFirstResult(startPage*HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
         q.setParameter("typeAnnonce", typeAnnonce);
          q.setParameter("etat", etat);
        q.setMaxResults(HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        return q.getResultList();
    }
    
   
   /**
    * 
    * @param annonceAEnvoyer annonces à passer à la servlet
    * @return 
    */ 
    public List<PhotoAnnonce> obtenirTableauDeToutesLesPhotos(Collection<Annonce> annonceAEnvoyer)
    {
        List<PhotoAnnonce> listesAnnonces = new ArrayList<>();
        //Map<String, PhotoAnnonce> maps = new HashMap<>();
        
        if(annonceAEnvoyer!=null)
        {
             for (Annonce annonce : annonceAEnvoyer) 
            {
                List<PhotoAnnonce> photos = this.getPhotoAnnonces(annonce.getId());
                boolean trouve = false;
                for (PhotoAnnonce photo : photos) {
                    if(photo!=null && photo.getNomLocalisation()!=null)
                    {
                        listesAnnonces.add(photo);
                        trouve=true;
                        //System.out.println("trouver " + photo.getNomLocalisation());
                        break;
                    }
                }
                if(trouve==false)
                {
                    PhotoAnnonce photo = new PhotoAnnonce();
                    photo.setNomLocalisation("no_picture.png");
                    listesAnnonces.add(photo);
                }
            }
        }
       
        return listesAnnonces;
        
    }
    
   
    /**
     * retourne la collection de photo pour toutes les annonces
     * @param annonceAEnvoyer
     * @return 
     */
    public List<List<PhotoAnnonce>> obtenirTableauDeToutesLesPhotosEnListe(Collection<Annonce> annonceAEnvoyer)
    {
        List<List<PhotoAnnonce>> listesAnnonces = new ArrayList<>();
        if(annonceAEnvoyer!=null)
        {
             for (Annonce annonce : annonceAEnvoyer) 
            {
                List<PhotoAnnonce> photos = this.getPhotoAnnonces(annonce.getId());
                listesAnnonces.add(photos);
            }
        }
       
        return listesAnnonces;
    }
    
    /**
     * recherche annonce par son identifiant
     * @param idAnnonce
     * @return 
     */
    public List<PhotoAnnonce> getPhotoAnnonces(int idAnnonce)
    {
        List<PhotoAnnonce> photosAnnonce = new ArrayList<>();
        Query query =em.createQuery("SELECT pa FROM PhotoAnnonce pa WHERE pa.annonce=:annonce");
        Annonce annonce = this.rechercherAnnonceParId(idAnnonce);
        if(annonce!=null)
        {
            query.setParameter("annonce", annonce);
            photosAnnonce=query.getResultList();
        }
        return photosAnnonce;
    }
    
    /**
     * Methode retournant une annonce par son identifiant
     * @param idAnnonce
     * @return 
     */
    public Annonce rechercherAnnonceParId(int idAnnonce)
    {
        Annonce annonce =null;
        try{
             annonce = em.find( Annonce.class, idAnnonce);
        }catch(IllegalArgumentException illegal)
        {
            annonce = null;
            System.out.println("illegal exception recherche Annonce par id : gestionnaire Annonce " +illegal.getMessage());
        }
        return annonce;
    }
    
    
    
    /**
     * obtenir toutes les annonces d'une école
     * @param ecole
     * @param etat
     * @return 
     */
    public List<Annonce> obtenirAnnoncesEcole(Ecole ecole, boolean etat)
    {
        Query query =em.createQuery("SELECT a FROM Annonce a WHERE a.ecole=:ecole AND a.etat=:etat ORDER BY a.dateCreation, a.titre");
        //query.setParameter("ecole", ecole.getId());
        query.setParameter("ecole", ecole);
        query.setParameter("etat", etat);
        return query.getResultList();
    }
    
    /**
     * 
     * @param start curseur vers le debut
     * @param ecole les annonces concernants l'ecole
     * @param etat etat de l'annonce non regler en cours d'utilisation faudrait penser à ajouter une contrainte sur le temps egalement
     * @return 
     */
    public  Collection<Annonce> obtenirAnnonceParPageEcole(int start, Ecole ecole, boolean etat) 
    {
        Query q = em.createQuery("SELECT a FROM Annonce a WHERE  a.ecole=:ecole AND a.etat=:etat ORDER BY a.dateCreation, a.titre");//ORDER BY u.lastname ASC
        q.setFirstResult(start*HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        System.out.println("requete **********" + q.toString());
        q.setParameter("etat", etat);
       // q.setParameter("ecole", ecole.getId());
        q.setParameter("ecole", ecole);
        
        q.setMaxResults(HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
        return q.getResultList();
    }
    
    /**
     * 
     * @param titre
     * @param titreUniquement
     * @param etat
     * @param categorie
     * @param ecole
     * @return 
     */
    public List<Annonce> rechercheAnnoncesParRecherche(String titre, boolean titreUniquement ,boolean etat, Categorie categorie, Ecole ecole, String autres, boolean urgente)
    {
        
        
        Query query = this.requeteRechercheAnnonce(titre, titreUniquement, etat, categorie, ecole, autres, urgente);
        //System.out.println("requete criteria greAnnonce" + query.toString());
        //System.out.println("requete criteria greAnnonce" + query.toString() + " other " + cq.toString());
        return query.getResultList();
    }
    
    /**
     * on pourrais faire d'une pierre deux coups mais j'ai la flemme
     * @param start pointeur vers le debut de la recherche
     * @param titre
     * @param titreUniquement
     * @param etat
     * @param categorie
     * @param ecole
     * @return 
     */
    public  Collection<Annonce> obtenirAnnonceParPageRecherche(int start, String titre, boolean titreUniquement ,boolean etat, Categorie categorie, Ecole ecole, String autres, boolean urgente) 
    {
        Query query = this.requeteRechercheAnnonce(titre, titreUniquement, etat, categorie, ecole, autres, urgente);
        query.setFirstResult(start*HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
       query.setMaxResults(HelpClass.MAX_DATA_TO_RETRIEVE_ANNONCE);
      return query.getResultList();
    }
    
    /**
     * methode permettant de faire des recherches sur les annonces utilisant l'api criteria
     * @param titre
     * @param titreUniquement
     * @param etat
     * @param categorie
     * @param ecole
     * @param autres
     * @param urgente
     * @return 
     */
   public Query requeteRechercheAnnonce(String titre, boolean titreUniquement ,boolean etat, Categorie categorie, Ecole ecole, String autres, boolean urgente)
    {
        List<Predicate> listPredicate = new ArrayList<>();
         CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery cq = cb.createQuery();
         Root from = cq.from(Annonce.class);
         listPredicate.add(cb.equal(from.get("etat"), etat));
         cq.orderBy(cb.asc(from.get("dateCreation")), cb.asc(from.get("titre")));
         
         if(titre!=null && titre.length()>0)
         {
            //Expression<String> expressionLike = from.get("titre");
             Expression<String> expressionLike = cb.upper(from.get("titre"));
            String forLike = titre.toUpperCase()+"%";
             System.out.println("for like " + forLike);
            Predicate predicateTitre = cb.like(expressionLike, forLike);
            //listPredicate.add(predicateTitre); 
            listPredicate.add(predicateTitre);
         }
         if(categorie!=null)
         {
            Expression<Categorie> expressionCategorie = from.get("categorie");
            listPredicate.add(cb.equal(expressionCategorie, categorie));
         }
         
         if(ecole!=null)
         {
            Expression<Ecole> expressionIdEcole = from.get("ecole");
            listPredicate.add(cb.equal(expressionIdEcole, ecole));
         }
         
         if(autres!=null && autres.length()>0) // code postal
        {
           Expression<String> expressionCodePostal = from.get("utilisateur").get("cp");
           listPredicate.add(cb.equal(expressionCodePostal, autres));
        }
         
         
         if(urgente)
        {
            System.out.println("urgente " + urgente);
           /*Expression<Integer> expressionIdEcole = from.get("idEcole");
           listPredicate.add(cb.equal(expressionIdEcole, ecole.getId()));*/
           Expression expressionUrgente = from.get("urgente");
           listPredicate.add(cb.equal(expressionUrgente, urgente));
        }else{
             if(titreUniquement)
             {
                 //Expression<String> expressionLike = from.get("description");
                 Expression<String> expressionLike = cb.upper(from.get("description"));
                String forLike = titre.toUpperCase()+"%";
                 System.out.println("for like " + forLike);
                Predicate predicateDescription = cb.like(expressionLike, forLike);
                
                listPredicate.add(cb.or(predicateDescription));  
             }
         }
         
       if(listPredicate.size()==1)
       {
           cq.where(listPredicate.get(0));
       }else if(listPredicate.size()>1)
       {
           
           cq.where(cb.and(listPredicate.toArray(new Predicate[listPredicate.size()])));
       }
       
       Query query = em.createQuery(cq.select(from));
       return query;
    }
   
   
   /**
    * methode permettant de recherche une photo d'une annonce par categorie
    * @param nomPropre
    * @return 
    */
   public PhotoAnnonce recherchePhotoAnnonce(String nomPropre)
    {
        Query query =em.createQuery("SELECT pa FROM PhotoAnnonce pa WHERE pa.nomLocalisation=:nomLocalisation");
        PhotoAnnonce photoAnnonce = null;
        try{
             photoAnnonce = (PhotoAnnonce) query.getSingleResult();
        }catch(NoResultException | NonUniqueResultException | IllegalStateException noreException)
        {
             photoAnnonce=null;
        }
        return photoAnnonce;
    }
   
   /**
    * 
    * @param photoAnnonce photoAnnonce a supprimer
    */
   public void supprimerPhotoAnnonce(PhotoAnnonce photoAnnonce)
   {
       PhotoAnnonce photoAnnonceG= em.merge(photoAnnonce);
       this.em.remove(photoAnnonceG);
       this.em.flush();
   }
    
   
}
