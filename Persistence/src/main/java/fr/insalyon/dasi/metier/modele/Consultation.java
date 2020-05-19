

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Samuel GUYETANT
 */
@Entity
public class Consultation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Long duree;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    private String commentaire;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Employe employe;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Medium medium;
    
    public Consultation(){
        
    }

//    public Consultation(Date date, int duree, Date dateDebut, Date dateFin, String commentaire,Client cl,Employe em,Medium me) {
//        this.dateConsultation = date;
//        this.duree = duree;
//        this.dateDebut = dateDebut;
//        this.dateFin = dateFin;
//        this.commentaire = commentaire;
//        this.client=cl;
//        this.employe=em;
//        this.medium=me;
//    }



    public Consultation(Date dateDebut, Date dateFin, Long duree, String commentaire) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commentaire = commentaire;
        this.duree = duree;
    }
    
    public Consultation(Date dateDebut,Long duree, String commentaire) {
        this.dateDebut = dateDebut;
        this.dateFin = null;
        this.commentaire = commentaire;
        this.duree = duree;
    }

    public Long getId() {
        return id;
    }


    public Long getDuree() {
        return duree;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Client getClient() {
        return client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Medium getMedium() {
        return medium;
    }
    

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setClient(Client client) {
        this.client = client;
        client.addConsultation(this);
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
        employe.addConsultation(this);
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
        medium.addConsultation(this);
    }
    
     @Override
    public String toString() {
        return "Consultation : id=" + id +  ", duree=" + duree + ", date de debut=" + dateDebut + ", date de fin=" + dateFin+"\nCommentaire :"+commentaire +"\n"+client.toString()+"\n"+employe.toString()+"\n"+medium.toString();
    }
}
