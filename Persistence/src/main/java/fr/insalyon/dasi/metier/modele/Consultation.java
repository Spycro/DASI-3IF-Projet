/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author Samuel GUYETANT
 */
@Entity
public class Consultation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Date dateConsultation;
    private int duree;
    private Date dateDebut;
    private Date dateFin;
    private String commentaire;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Medium medium;
    
    public Consultation(){
        
    }

    public Consultation(Date date, int duree, Date dateDebut, Date dateFin, String commentaire,Client cl,Employe em,Medium me) {
        this.dateConsultation = date;
        this.duree = duree;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commentaire = commentaire;
        this.client=cl;
        this.employe=em;
        this.medium=me;
    }

    public Long getId() {
        return id;
    }

    
    public Date getDateConsultation() {
        return dateConsultation;
    }

    public int getDuree() {
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
    
    
    public void setDate(Date date) {
        this.dateConsultation = date;
    }

    public void setDuree(int duree) {
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
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }
     @Override
    public String toString() {
        return "Consultation : id=" + id + ", date de consultation=" + dateConsultation + ", duree=" + duree + ", date de debut=" + dateDebut + ", date de fin=" + dateFin+"\nCommentaire :"+commentaire +"\n"+client.toString()+"\n"+employe.toString()+"\n"+medium.toString();
    }
}
