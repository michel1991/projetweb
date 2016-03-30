/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.immobilier;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lpae.entites.Annonce;

/**
 *
 * @author michel
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@DiscriminatorValue("IMMOBILIER_LOCATION_COLOCATION")
public class AnImmobilier extends Annonce implements Serializable {
    @ManyToOne
    private Ges ges;
    @ManyToOne
    private ClasseEnergie classeEnergie;
    @ManyToOne
    private TypeBien typeBien;
    private int piece;

    public AnImmobilier() {
    }
    
    private boolean meuble; // pour les locations
    
    private String type; // on va gerer tous les immobuliers;
    
    public Ges getGes() {
        return ges;
    }

    public void setGes(Ges ges) {
        this.ges = ges;
    }

    public boolean isMeuble() {
        return meuble;
    }

    public void setMeuble(boolean meuble) {
        this.meuble = meuble;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ClasseEnergie getClasseEnergie() {
        return classeEnergie;
    }

    public void setClasseEnergie(ClasseEnergie classeEnergie) {
        this.classeEnergie = classeEnergie;
    }

    public TypeBien getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(TypeBien typeBien) {
        this.typeBien = typeBien;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }
    
    private float surface;
    
}
