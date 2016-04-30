/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author michel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ANNONCE")
public class Annonce implements Serializable {
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Categorie categorie;

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }
    
    private boolean urgente;

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }
    @ManyToOne
    private TypeAnnonce typeAnnonce;
    
    @ManyToOne
    private Ecole ecole;
    
    private int idEcole;

    public int getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    public Annonce() {
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
    private boolean etat ;

    public boolean isAlaUne() {
        return alaUne;
    }

    public void setAlaUne(boolean alaUne) {
        this.alaUne = alaUne;
    }
    
    private boolean marquerPhoneAnnce;
    
    private boolean alaUne;

    public boolean isMarquerPhoneAnnce() {
        return marquerPhoneAnnce;
    }

    public void setMarquerPhoneAnnce(boolean marquerPhoneAnnce) {
        this.marquerPhoneAnnce = marquerPhoneAnnce;
    }

    public boolean isAnncePart() {
        return anncePart;
    }

    public void setAnncePart(boolean anncePart) {
        this.anncePart = anncePart;
    }
    
    private boolean anncePart;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    private String titre;
    
    private String description;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<PhotoAnnonce> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<PhotoAnnonce> photos) {
        this.photos = photos;
    }
    
    @OneToMany(mappedBy = "annonce", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<PhotoAnnonce> photos = new ArrayList<>();

    public TypeAnnonce getTypeAnnonce() {
        return typeAnnonce;
    }

    public void setTypeAnnonce(TypeAnnonce typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
    
    private double cout;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addPhoto(PhotoAnnonce photo)
    {
        if(photo!=null){
            photo.setAnnonce(this);
            this.photos.add(photo);
        }
    }
    
     public void removePhoto(PhotoAnnonce photo)
    {
        if(photo!=null){
            this.photos.remove(photo);
        }
    }
     
     
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.Annonce[ id=" + id 
                + " titre " + this.titre+ ""
                + " description "+this.description+ " "+
                "]";
    }
    
    
}
