/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.vehicules;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author michel
 */
@Entity
public class Modele implements Serializable {
    @ManyToOne
    private Marque marque;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCrMdle;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anneModele;
    
    private String nomMdle;

    public Modele() {
    }

    public Date getDateCrMdle() {
        return dateCrMdle;
    }

    public void setDateCrMdle(Date dateCrMdle) {
        this.dateCrMdle = dateCrMdle;
    }

    public Date getAnneModele() {
        return anneModele;
    }

    public void setAnneModele(Date anneModele) {
        this.anneModele = anneModele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getNomMdle() {
        return nomMdle;
    }

    public void setNomMdle(String nomMdle) {
        this.nomMdle = nomMdle;
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
        if (!(object instanceof Modele)) {
            return false;
        }
        Modele other = (Modele) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.Modele[ id=" + id + " ]";
    }
    
}
