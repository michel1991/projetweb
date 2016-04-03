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
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nomRe;

    public Date getDateCreatRegion() {
        return dateCreatRegion;
    }

    public void setDateCreatRegion(Date dateCreatRegion) {
        this.dateCreatRegion = dateCreatRegion;
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreatRegion;
    
    @OneToMany(mappedBy = "region", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<Departement> departements= new ArrayList<>();
    
    public int getId() {
        return id;
    }

    public Collection<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(Collection<Departement> departements) {
        this.departements = departements;
    }

    public Region() {
    }

    public Region(String nomRe) {
        this.nomRe = nomRe;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addDepartement(Departement departement)
    {
        if(departement!=null)
        {
            departement.setRegion(this);
            this.departements.add(departement);
        }
    }
    
    public void removeDepartement(Departement departement)
    {
        if(departement!=null)
        {
            this.departements.remove(departement);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    public String getNomRe() {
        return nomRe;
    }

    public void setNomRe(String nomRe) {
        this.nomRe = nomRe;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.Region[ id=" + id + " nom= " + nomRe +" date "+ dateCreatRegion+" ]";
    }
    
}
