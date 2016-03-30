/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.vehicules;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import lpae.entites.Annonce;

/**
 *
 * @author michel
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@DiscriminatorValue("MOTO")
public class AnMoto extends Annonce implements Serializable {
    private static final long serialVersionUID = 1L;

    public int getKilometrage() {
        return kilometrage;
    }

    public AnMoto() {
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public float getCylindre() {
        return cylindre;
    }

    public void setCylindre(float cylindre) {
        this.cylindre = cylindre;
    }

    public Date getAnneModeleMoto() {
        return anneModeleMoto;
    }

    public void setAnneModeleMoto(Date anneModeleMoto) {
        this.anneModeleMoto = anneModeleMoto;
    }
    
    private int kilometrage;
    
    private float cylindre;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anneModeleMoto;
}
