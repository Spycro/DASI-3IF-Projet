package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


/**
 *
 * @author DASI Team
 */
@Entity
public class Client extends User implements Serializable {

    
    private String nom;
    private String prenom;
    private String numeroTel;
    private String adresse;
    private Integer Age;
    @OneToOne
    private ProfilAstral profilAstral;

    public Client(String nom, String prenom, String numeroTel, String adresse, Integer Age, ProfilAstral profilAstral, Date dateNaissance, String motDePasse, String mail) {
        super(motDePasse, mail);
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.Age = Age;
        this.profilAstral = profilAstral;
        this.dateNaissance = dateNaissance;
    }

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

    public Date getDateNaissance() {
        return dateNaissance;
    }
    private Date dateNaissance;

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



    @Override
    public String toString() {
        return "Client : id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", motDePasse=" + motDePasse;
    }
    

}
