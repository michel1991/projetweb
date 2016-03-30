/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.immobilier;

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
public class ClasseEnergie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ClasseEnergie() {
    }

    public Collection<AnImmobilier> getImmobiliers() {
        return immobiliers;
    }

    public void setImmobiliers(Collection<AnImmobilier> immobiliers) {
        this.immobiliers = immobiliers;
    }
    
    private String libelle;
    
    @OneToMany(mappedBy = "classeEnergie")
    private Collection<AnImmobilier> immobiliers = new ArrayList<>();

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
        if (!(object instanceof ClasseEnergie)) {
            return false;
        }
        ClasseEnergie other = (ClasseEnergie) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.immobilier.ClasseEnergie[ id=" + id + " ]";
    }
    
}
