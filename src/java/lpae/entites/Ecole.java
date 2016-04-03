/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author michel
 */
@Entity
public class Ecole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nom;
    
    private String latitude;

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    @ManyToOne
    private Departement departement;

    public Ecole() {
    }
    
    private String longitude;
    
    private String cp;
    
    private String adresse;

    public Collection<EcoleUtilisateur> getEcoleUtilisateurs() {
        return ecoleUtilisateurs;
    }

    public void setEcoleUtilisateurs(Collection<EcoleUtilisateur> ecoleUtilisateurs) {
        this.ecoleUtilisateurs = ecoleUtilisateurs;
    }
    
    
    @OneToMany(mappedBy = "ecole")
    private Collection<EcoleUtilisateur> ecoleUtilisateurs=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
        if (!(object instanceof Ecole)) {
            return false;
        }
        Ecole other = (Ecole) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getAdresse() {
        return adresse;
    }

    public Ecole(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "lpae.entites.Ecole[ id=" + id + " nom " + nom+" ]";
    }
    
}
