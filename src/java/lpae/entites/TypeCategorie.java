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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author michel
 */
@Entity
public class TypeCategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nomTyp;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    @OneToMany(mappedBy = "typeCategorie", cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<Categorie> categories = new ArrayList<>();

    public String getNomTyp() {
        return nomTyp;
    }

    public TypeCategorie() {
    }

    public void setNomTyp(String nomTyp) {
        this.nomTyp = nomTyp;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Categorie> categories) {
        this.categories = categories;
    }
    
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

    public void addCategorie(Categorie categorie)
    {
        if(categorie!=null)
        {
           categorie.setTypeCategorie(this);
           this.categories.add(categorie);
        }
    }
    
    public void removeCategorie(Categorie categorie)
    {
        if(categorie!=null)
        {
           //categorie.setTypeCategorie(this);
           this.categories.remove(categorie);
        }
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeCategorie)) {
            return false;
        }
        TypeCategorie other = (TypeCategorie) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "lpae.entites.TypeCategorie[ id=" + id + " nom " + this.getNomTyp()+ " ]";
    }
    
}
