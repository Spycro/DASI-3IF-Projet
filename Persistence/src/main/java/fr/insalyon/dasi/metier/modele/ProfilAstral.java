/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Lucas
 */
@Entity
public class ProfilAstral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SigneZodiaque;
    private String SigneAstrologique;
    private String CouleurPorteBonheur;
    private String AnimalTotem;
    
    protected ProfilAstral() {
    }

    public ProfilAstral(String SigneZodiaque, String SigneAstrologique, String CouleurPorteBonheur, String AnimalTotem) {
        this.SigneZodiaque = SigneZodiaque;
        this.SigneAstrologique = SigneAstrologique;
        this.CouleurPorteBonheur = CouleurPorteBonheur;
        this.AnimalTotem = AnimalTotem;
    }

    public Long getId() {
        return id;
    }

    public String getSigneZodiaque() {
        return SigneZodiaque;
    }

    public void setSigneZodiaque(String SigneZodiaque) {
        this.SigneZodiaque = SigneZodiaque;
    }

    public String getSigneAstrologique() {
        return SigneAstrologique;
    }

    public void setSigneAstrologique(String SigneAstrologique) {
        this.SigneAstrologique = SigneAstrologique;
    }

    public String getCouleurPorteBonheur() {
        return CouleurPorteBonheur;
    }

    public void setCouleurPorteBonheur(String CouleurPorteBonheur) {
        this.CouleurPorteBonheur = CouleurPorteBonheur;
    }

    public String getAnimalTotem() {
        return AnimalTotem;
    }

    public void setAnimalTotem(String AnimalTotem) {
        this.AnimalTotem = AnimalTotem;
    }
    
    @Override
    public String toString() {
        return "Profil : id=" + id + ", signeZodiaque=" + SigneZodiaque + ", SigneAstrologique=" + SigneAstrologique + ", CouleurPorteBonheur=" + CouleurPorteBonheur + ", AnimalTotem=" + AnimalTotem;
    }
}
