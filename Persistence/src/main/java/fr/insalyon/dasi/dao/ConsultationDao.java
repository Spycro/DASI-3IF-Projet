/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Consultation;
import java.util.Date;
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
        em.merge(consultation.getClient());
        em.merge(consultation.getEmploye());
        em.merge(consultation.getMedium());
    }
    
    public void validerConsultation(Consultation consultation, Date deb, Date fin, Long duree, String commentaire){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        
        consultation = em.merge(consultation);
        consultation.setDateDebut(deb);
        consultation.setDateFin(fin);
        consultation.setDuree(duree);
        consultation.setCommentaire(commentaire);
    }
    
    public Consultation chercherParId(Long consultationId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Consultation.class, consultationId); // renvoie null si l'identifiant n'existe pas
    }
    
    public List<Consultation> listerConsultation() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c", Consultation.class);
        return query.getResultList();
    }
    
    public List<Consultation> listerConsultationParClient(long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.client.id=:id", Consultation.class);
        query.setParameter("id", clientId);
        return query.getResultList();
    }
     
    public List<Consultation> listerConsultationParEmploye(long employeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employe.id=:id", Consultation.class);
        query.setParameter("id", employeId);
        return query.getResultList();
    }
      
    public List<Consultation> listerConsultationParMedium(long mediumId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.medium.id=:id", Consultation.class);
        query.setParameter("id", mediumId);
        return query.getResultList();
    }
    
    
    public Consultation obtenirConsultationNonTerminee(long employeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employe.id=:id and c.dateFin IS NULL", Consultation.class);
        query.setParameter("id", employeId);
        List<Consultation> c = query.getResultList();
        Consultation result = null;
        if(c!=null){
            result = c.get(0);
        }
        return result;
    }
    
    // modifier / supprimer  ... 
}

