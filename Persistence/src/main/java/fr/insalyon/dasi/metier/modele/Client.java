package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;


/**
 *
 * @author DASI Team
 */
@Entity
public class Client extends Users implements Serializable {

    
    private String nom;
    private String prenom;
    private String numeroTel;
    private String adresse;
    private Integer Age;
    @OneToOne(cascade = CascadeType.ALL)
    private ProfilAstral profilAstral;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy="client")
    private List<Consultation> consultations;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;



    public Client(String nom, String prenom, String numeroTel, String adresse, Integer Age, Date dateNaissance, String motDePasse, String mail) {
        super(motDePasse, mail);
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.Age = Age;
        this.dateNaissance = dateNaissance;
        
        //TODO : Utiliser l'API des profs pour generer automatiquement le profil astral
    }

    public Client(String nom, String prenom, String numeroTel, String adresse, Integer Age, ProfilAstral profilAstral, List<Consultation> consultations, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.Age = Age;
        this.profilAstral = profilAstral;
        this.consultations = consultations;
        this.dateNaissance = dateNaissance;
    }
//    

    public Date getDateNaissance() {
        return dateNaissance;
    }

    protected Client() {
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }
 

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ProfilAstral getProfilAstral() {
        return profilAstral;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setProfilAstral(ProfilAstral profilAstral) {
        this.profilAstral = profilAstral;
    }

    @Override
    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
    }

    @Override
    public String toString() {
        return "Client : id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", motDePasse=" + motDePasse;
    }
    

}
