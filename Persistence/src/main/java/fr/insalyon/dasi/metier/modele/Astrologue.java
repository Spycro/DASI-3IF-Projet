/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Samuel GUYETANT
 */
@Entity
public class Astrologue extends Medium implements Serializable {
    
    
    protected String formation;
    protected int promotion;
    
    public Astrologue(){
        
    }
    
    public Astrologue(String denomination, String genre, String presentation) {
        super(denomination, genre, presentation);
        this.type=2;
    }
    
     public String getFormation() {
        return formation;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
    @Override
    public String toString() {
        return "Astrologue : id=" + id + ", denomination=" + denomination + ", genre=" + genre + ", presentation=" + presentation + ", nbConsulation=" + nbConsultation+", formation="+ formation +", promotion="+promotion;
    }
}
