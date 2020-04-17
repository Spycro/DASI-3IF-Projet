package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Medium;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class MediumDao {
    
    public void creer(Medium medium) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(medium);
    }
    
    public Medium chercherParId(Long mediumId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Medium.class, mediumId); // renvoie null si l'identifiant n'existe pas
    }
    
    /*public Medium chercherParMail(String clientMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.mail = :mail", Client.class);
        query.setParameter("mail", clientMail); // correspond au paramètre ":mail" dans la requête
        List<Client> clients = query.getResultList();
        Client result = null;
        if (!clients.isEmpty()) {
            result = clients.get(0); // premier de la liste
        }
        return result;
    }*/
    
    public List<Medium> listerMedium() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT m FROM Medium m ORDER BY m.denomination ASC", Medium.class);
        return query.getResultList();
    }

    public List<Medium> listerTopMedium() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT m FROM Medium m ORDER BY m.nbConsultation DESC", Medium.class);
        return query.getResultList();
    }
    // modifier / supprimer  ... 
}
