/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;



/**
 *
 * @author Samuel GUYETANT
 */
@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Medium implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String denomination;
    protected String genre;
    protected String presentation;
    protected int nbConsultation;
    protected short type;
    @OneToMany(mappedBy="medium")
    protected List<Consultation> consultations;

    public Medium(){
        
    }
    public Medium(String denomination, String genre, String presentation) {
        this.denomination = denomination;
        this.genre = genre;
        this.presentation = presentation;
        this.nbConsultation = 0;
    }

    public Medium(Long id, String denomination, String genre, String presentation, int nbConsultation, short type, List<Consultation> consultations) {
        this.id = id;
        this.denomination = denomination;
        this.genre = genre;
        this.presentation = presentation;
        this.nbConsultation = nbConsultation;
        this.type = type;
        this.consultations = consultations;
    }
    

    public Long getId() {
        return id;
    }

    public String getDenomination() {
        return denomination;
    }

    public String getGenre() {
        return genre;
    }

    public String getPresentation() {
        return presentation;
    }

    public int getNbConsultation() {
        return nbConsultation;
    }

    public short getType() {
        return type;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setNbConsultation(int nbConsultation) {
        this.nbConsultation = nbConsultation;
    }
    

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
    
    
   
    
     @Override
    public String toString() {
        return "Medium : id=" + id + ", denomination=" + denomination + ", genre=" + genre + ", presentation=" + presentation + ", nbConsulation=" + nbConsultation;
    }
    
}
