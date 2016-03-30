/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.vehicules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author michel
 */
@Entity
public class TypeMarque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nomTyMq;

    public String getNomTyMq() {
        return nomTyMq;
    }

    public void setNomTyMq(String nomTyMq) {
        this.nomTyMq = nomTyMq;
    }

    public Collection<Marque> getMarques() {
        return marques;
    }

    public void setMarques(Collection<Marque> marques) {
        this.marques = marques;
    }
    
    @OneToMany(mappedBy = "typeMarque")
    private Collection<Marque> marques = new ArrayList<>();

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
        if (!(object instanceof TypeMarque)) {
            return false;
        }
        TypeMarque other = (TypeMarque) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.TypeMarque[ id=" + id + " ]";
    }
    
}
