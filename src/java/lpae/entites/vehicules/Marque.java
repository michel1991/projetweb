/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.vehicules;

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
public class Marque implements Serializable {
    @ManyToOne
    private TypeMarque typeMarque;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nomM;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCrMrque;

    public Collection<AnVoiture> getaVoitures() {
        return aVoitures;
    }

    public Marque() {
    }

    public Date getDateCrMrque() {
        return dateCrMrque;
    }

    public void setDateCrMrque(Date dateCrMrque) {
        this.dateCrMrque = dateCrMrque;
    }

    public TypeMarque getTypeMarque() {
        return typeMarque;
    }

    public void setTypeMarque(TypeMarque typeMarque) {
        this.typeMarque = typeMarque;
    }

    public Collection<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(Collection<Modele> modeles) {
        this.modeles = modeles;
    }

    public void setaVoitures(Collection<AnVoiture> aVoitures) {
        this.aVoitures = aVoitures;
    }
    
    @OneToMany(mappedBy = "marque")
    private Collection<AnVoiture> aVoitures = new ArrayList<>();
    
    @OneToMany(mappedBy = "marque")
    private Collection<Modele> modeles = new ArrayList<>();

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.Marque[ id=" + id + " ]";
    }
    
}
