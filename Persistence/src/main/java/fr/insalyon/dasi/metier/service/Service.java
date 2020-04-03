package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.dao.MediumDao;
import fr.insalyon.dasi.dao.UsersDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.dao.ProfilAstralDao;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.ProfilAstral;
import fr.insalyon.dasi.metier.modele.Users;

/**
 *
 * @author DASI Team
 */
public class Service {

    protected MediumDao mediumDao = new MediumDao();
    protected UsersDao usersDao = new UsersDao();
    protected ProfilAstralDao profilAstralDao = new ProfilAstralDao();

    public Long inscrireClient(Users user) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            usersDao.creer(user);
            JpaUtil.validerTransaction();
            resultat = user.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Client authentifierClient(String mail, String motDePasse) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Client client = usersDao.chercherClientParMail(mail);
            if (client != null) {
                // Vérification du mot de passe
                if (client.getMotDePasse().equals(motDePasse)) {
                    resultat = client;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return resultat;
    }

    
    public Employe authentifierEmploye(String mail, String motDePasse) {
        Employe resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Employe employe = usersDao.chercherEmployeParMail(mail);
            if (employe != null) {
                // Vérification du mot de passe
                if (employe.getMotDePasse().equals(motDePasse)) {
                    resultat = employe;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return resultat;
    }
    /*
    
    public Client rechercherClientParId(Long id) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = usersDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }



    public List<Client> listerClients() {
        List<Client> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = usersDao.listerClients();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    */
    
    public Long inscrireProfilAstral(ProfilAstral profilAstral) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            profilAstralDao.creer(profilAstral);
            JpaUtil.validerTransaction();
            resultat = profilAstral.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireProfilAstral(profilastral)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public Long inscrireMedium(Medium medium) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            mediumDao.creer(medium);
            JpaUtil.validerTransaction();
            resultat = medium.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireMedium(medium)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    
    
}
