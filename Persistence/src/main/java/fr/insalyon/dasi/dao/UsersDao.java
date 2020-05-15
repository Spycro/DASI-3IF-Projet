/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.dao;
import fr.insalyon.dasi.metier.modele.Users;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Employe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class UsersDao {

    public void creer(Users user) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(user);
    }
    
    public void changerMotDePasse(Users user, String MDP){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        user = em.merge(user);
        user.setMotDePasse(MDP);
        
    }
    
    //Dao en relation avec les clients
    
    public Client chercherClientParId(Long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Client.class, clientId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Client chercherClientParMail(String clientMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.mail = :mail", Client.class);
        query.setParameter("mail", clientMail); // correspond au paramètre ":mail" dans la requête
        List<Client> clients = query.getResultList();
        Client result = null;
        if (!clients.isEmpty()) {
            result = clients.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<Client> listerClients() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c ORDER BY c.nom ASC, c.prenom ASC", Client.class);
        return query.getResultList();
    }
    
    
    //Dao en relation avec les employes
    
    public Employe chercherEmployeParMail(String employeMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employe> query = em.createQuery("SELECT c FROM Employe c WHERE c.mail = :mail", Employe.class);
        query.setParameter("mail", employeMail); // correspond au paramètre ":mail" dans la requête
        List<Employe> employes = query.getResultList();
        Employe result = null;
        if (!employes.isEmpty()) {
            result = employes.get(0); // premier de la liste
        }
        return result;
    }
    
    public Users chercherUsersParMail(String employeMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Users> query = em.createQuery("SELECT c FROM Users c WHERE c.mail = :mail", Users.class);
        query.setParameter("mail", employeMail); // correspond au paramètre ":mail" dans la requête
        List<Users> users = query.getResultList();
        Users result = null;
        if (!users.isEmpty()) {
            result = users.get(0); // premier de la liste
        }
        return result;
    }
    
              
    public Employe chercherEmployeParId(Long employeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Employe.class, employeId); // renvoie null si l'identifiant n'existe pas
    }
    
    public List<Employe> listerEmployes() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employe> query = em.createQuery("SELECT c FROM Employe c ORDER BY c.nom ASC, c.prenom ASC", Employe.class);
        return query.getResultList();
    }
    
    /**
     * 
     * @param genre soit "M" soit "F" 
     * @return Une liste des employe d'un genre ordonnee par leur nombre
     * de consultations
     */
    public List<Employe> listerEmployesParGenre(String genre) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employe> query = em.createQuery("SELECT c FROM Employe c WHERE c.genre = :genre ORDER BY c.nbConsultations ASC", Employe.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }
    
    public void modifierEtatConsultation(Employe employe, Boolean etat){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        employe = em.merge(employe);
        employe.setEnConsultation(etat);
    }
    
    
}
