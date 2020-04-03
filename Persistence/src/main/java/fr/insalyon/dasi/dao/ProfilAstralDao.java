/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package fr.insalyon.dasi.dao;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.ProfilAstral;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucas
 */
public class ProfilAstralDao {
    public void creer(ProfilAstral profilastral) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(profilastral);
    }
    
    public ProfilAstral chercherParId(Long profilAstralID) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(ProfilAstral.class, profilAstralID); // renvoie null si l'identifiant n'existe pas
    }
    
    
    
}
