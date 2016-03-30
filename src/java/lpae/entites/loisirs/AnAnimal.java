/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites.loisirs;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lpae.entites.Annonce;

/**
 *
 * @author michel
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@DiscriminatorValue("ANIMAL")
public class AnAnimal extends Annonce implements Serializable {
    @ManyToOne
    private TypeAnimal typeAnimal;
    private static final long serialVersionUID = 1L;

    public TypeAnimal getTypeAnimal() {
        return typeAnimal;
    }

    public AnAnimal() {
    }

    public void setTypeAnimal(TypeAnimal typeAnimal) {
        this.typeAnimal = typeAnimal;
    }
    
    
}
