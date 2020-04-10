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
import javax.persistence.Inheritance;
/**
 *
 * @author Samuel GUYETANT
 */
@Entity
public class Spirite extends Medium implements Serializable {
    
    protected String support;

   
    public Spirite(){
        
    }
    
    public Spirite( String denomination, String genre, String presentation,String support) {
        super(denomination, genre, presentation);
        this.support = support;
//        this.type = 0;
    }

    public String getSupport() {
        return support;
    }
    
    public void setSupport(String support) {
        this.support = support;
    }
     @Override
    public String toString() {
        return "Spirite : id=" + id + ", denomination=" + denomination + ", genre=" + genre + ", presentation=" + presentation + ", nbConsulation=" + nbConsultation+", support="+ support;
    }
    
}
