/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Lucas
 */

@Entity
public class Employe extends Users implements Serializable{
    
    private String nom;
    private String prenom;
    private String numeroTel;
    private Integer Age;
    private String genre;
    private Integer nbConsultations;

    public Employe() {
    }

    public Employe(String nom, String prenom, String numeroTel, Integer Age, String genre, Integer nbConsultations, String motDePasse, String mail) {
        super(motDePasse, mail);
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.Age = Age;
        this.genre = genre;
        this.nbConsultations = nbConsultations;
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

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNbConsultations() {
        return nbConsultations;
    }

    public void setNbConsultations(Integer nbConsultations) {
        this.nbConsultations = nbConsultations;
    }
}
