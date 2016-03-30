/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author michel
 */
@Entity
public class PhotoAnnonce implements Serializable {

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
    @ManyToOne
    private Annonce annonce;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getNomLocalisation() {
        return nomLocalisation;
    }

    public PhotoAnnonce() {
    }

    public void setNomLocalisation(String nomLocalisation) {
        this.nomLocalisation = nomLocalisation;
    }

    public String getExtensionP() {
        return extensionP;
    }

    public void setExtensionP(String extensionP) {
        this.extensionP = extensionP;
    }
    
    private String nomLocalisation;
    
    private String extensionP;

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
        if (!(object instanceof PhotoAnnonce)) {
            return false;
        }
        PhotoAnnonce other = (PhotoAnnonce) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.PhotoAnnonce[ id=" + id + " ]";
    }
    
}
