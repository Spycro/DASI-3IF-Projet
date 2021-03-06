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
import javax.persistence.InheritanceType;

/**
 *
 * @author Lucas
 */
@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Users implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String motDePasse;
    @Column(unique = true)
    protected String mail;

    public Users() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Users(String motDePasse, String mail) {
        this.motDePasse = motDePasse;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    abstract public void addConsultation(Consultation consultation);
}
