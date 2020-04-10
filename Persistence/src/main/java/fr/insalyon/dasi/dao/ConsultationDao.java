/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Medium;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Samuel GUYETANT
 */
public class ConsultationDao {
    
    
    public void creer(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(consultation);
    }
    
    public Consultation chercherParId(Long consultationId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Consultation.class, consultationId); // renvoie null si l'identifiant n'existe pas
    }
    
    
    public List<Consultation> listerConsultation() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c ORDER BY c.nom ASC, c.prenom ASC", Consultation.class);
        return query.getResultList();
    }
     public List<Consultation> listerConsultationParClient(long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.client.id="+clientId+" ORDER BY c.nom ASC, c.prenom ASC", Consultation.class);
        return query.getResultList();
    }
      public List<Consultation> listerConsultationParEmploye(long employeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employe.id="+employeId+" ORDER BY c.nom ASC, c.prenom ASC", Consultation.class);
        return query.getResultList();
    }
       public List<Consultation> listerConsultationParMedium(long mediumId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.medium.id="+mediumId+"  ORDER BY c.nom ASC, c.prenom ASC", Consultation.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}

