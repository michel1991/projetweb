/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
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
    
    //private String latitude;
    
    private String sigle;

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    /*public List<Annonce> getListeAnnonces() {
        return listeAnnonces;
    }

    public void setListeAnnonces(List<Annonce> listeAnnonces) {
        this.listeAnnonces = listeAnnonces;
    }*/
    
    private String commune;
    
    private String tutelle;
    
    private String academie;
    
    private String universite;
    
    @OneToMany(mappedBy = "ecole", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Annonce> listeAnnonces = new ArrayList<>();

    public String getTypeEtab() {
        return typeEtab;
    }

    public void setTypeEtab(String typeEtab) {
        this.typeEtab = typeEtab;
    }
    
    private String typeEtab;

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getTutelle() {
        return tutelle;
    }

    public void setTutelle(String tutelle) {
        this.tutelle = tutelle;
    }

    public String getAcademie() {
        return academie;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setAcademie(String academie) {
        this.academie = academie;
    }

    
    
    private double longitude;
    
    private double latitude;
    

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
    
    //private String longitude;
    
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

    /*public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }*/

    /*public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }*/

    public void addAnnonce(Annonce annonce)
    {
        if(annonce!=null){
            annonce.setEcole(this);
            this.listeAnnonces.add(annonce);
        }
    }
    
     public void removeAnnonce(Annonce annonce)
    {
        if(annonce!=null){
            this.listeAnnonces.remove(annonce);
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
