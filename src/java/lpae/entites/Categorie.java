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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author michel
 */
@Entity
public class Categorie implements Serializable {
    @ManyToOne
    private TypeCategorie typeCategorie;

    public boolean isIsSubAnnonce() {
        return isSubAnnonce;
    }

    public void setIsSubAnnonce(boolean isSubAnnonce) {
        this.isSubAnnonce = isSubAnnonce;
    }

    public Categorie() {
    }
    
    private boolean isSubAnnonce;// decrit si on doit aller chercher dans les sous classes

    public TypeCategorie getTypeCategorie() {
        return typeCategorie;
    }

    public void setTypeCategorie(TypeCategorie typeCategorie) {
        this.typeCategorie = typeCategorie;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collection<Annonce> getAnnonces() {
        return annonces;
    }
    
    
    @OneToMany(mappedBy = "categorie")
    private final Collection<Annonce> annonces = new ArrayList<>();

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    private String libelle;
    
    private String idTable;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.Categorie[ id=" + id + " libelle " + libelle +" ]";
    }
    
}
