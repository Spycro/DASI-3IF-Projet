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
public class Cartomancien extends Medium implements Serializable {

    public Cartomancien(){
        
    }
    public Cartomancien(String denomination, String genre, String presentation) {
        super(denomination, genre, presentation);
//        this.type=1;
    }
    
    @Override
    public String toString() {
        return "Cartomancien : id=" + id + ", denomination=" + denomination + ", genre=" + genre + ", presentation=" + presentation + ", nbConsulation=" + nbConsultation;
    }
}
