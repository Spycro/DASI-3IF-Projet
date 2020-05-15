package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.dao.MediumDao;
import fr.insalyon.dasi.dao.UsersDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fr.insalyon.dasi.dao.ConsultationDao;
import fr.insalyon.dasi.dao.ProfilAstralDao;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.ProfilAstral;
import fr.insalyon.dasi.metier.modele.Users;
import fr.insalyon.dasi.util.AstroUtil;
import fr.insalyon.dasi.util.MessageUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DASI Team
 */
public class Service {

    protected MediumDao mediumDao = new MediumDao();
    protected UsersDao usersDao = new UsersDao();
    protected ProfilAstralDao profilAstralDao = new ProfilAstralDao();
    protected ConsultationDao consultationDao = new ConsultationDao();
    protected AstroUtil astroUtil = new AstroUtil();
    protected MessageUtil messageUtil = new MessageUtil();
    

    public Long inscrireUsers(Users user) {
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
    
    public long inscrireClient(Client client) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try{
            JpaUtil.ouvrirTransaction();
            List<String> profil_array = astroUtil.getProfil(client.getPrenom(), client.getDateNaissance());
            ProfilAstral prof = new ProfilAstral(profil_array.get(0),profil_array.get(1), profil_array.get(2), profil_array.get(3) );
            client.setProfilAstral(prof);
            usersDao.creer(client);
            JpaUtil.validerTransaction();
            resultat= client.getId();
        }
        catch (Exception ex) {
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
            // Recherche du user
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
            // Recherche du user
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
    
    
    public Client rechercherClientParId(Long id) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = usersDao.chercherClientParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Client rechercherClientParMail(String mail) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = usersDao.chercherClientParMail(mail);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParMail(mail)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Employe rechercherEmployeParId(Long id) {
      Employe resultat = null;
      JpaUtil.creerContextePersistance();
      try {
          resultat = usersDao.chercherEmployeParId(id);
      } catch (Exception ex) {
          Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
          resultat = null;
      } finally {
          JpaUtil.fermerContextePersistance();
      }
      return resultat;
    }
    
     public Employe rechercherEmployeParMail(String mail) {
      Employe resultat = null;
      JpaUtil.creerContextePersistance();
      try {
          resultat = usersDao.chercherEmployeParMail(mail);
      } catch (Exception ex) {
          Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
          resultat = null;
      } finally {
          JpaUtil.fermerContextePersistance();
      }
      return resultat;
    }
      
    
    
    public Users rechercherUsersParMail(String mail) {
      Users resultat = null;
      JpaUtil.creerContextePersistance();
      try {
          resultat = usersDao.chercherUsersParMail(mail);
      } catch (Exception ex) {
          Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
          resultat = null;
      } finally {
          JpaUtil.fermerContextePersistance();
      }
      return resultat;
    }
      
    public Medium rechercherMediumParId(Long id) {
        Medium resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = mediumDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Consultation rechercherConsultationParId(Long id) {
        Consultation resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = consultationDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public List<Medium> listerMedium() {
        List<Medium> resultat = null;

        JpaUtil.creerContextePersistance();
        try {
            resultat = mediumDao.listerMedium();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerMedium()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public List<Consultation> listerConsultation() {
        List<Consultation> resultat = null;

        JpaUtil.creerContextePersistance();
        try {
            resultat = consultationDao.listerConsultation();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerConsultation()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
     
    public List<Consultation> listerConsultationParClient(long idC) {
        List<Consultation> resultat = null;

        JpaUtil.creerContextePersistance();
        try {
            resultat = consultationDao.listerConsultationParClient(idC);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerConsultation()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
     
    public List<Consultation> listerConsultationParEmploye(long idE) {
        List<Consultation> resultat = null;

        JpaUtil.creerContextePersistance();
        try {
            resultat = consultationDao.listerConsultationParEmploye(idE);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerConsultation()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    } 
    
    public List<Consultation> listerConsultationParMedium(long idM) {
        List<Consultation> resultat = null;

        JpaUtil.creerContextePersistance();
        try {
            resultat = consultationDao.listerConsultationParMedium(idM);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerConsultation()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
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
    
    public Long inscrireConsultation(Consultation consultation) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultationDao.creer(consultation);
            usersDao.modifierEtatConsultation(consultation.getEmploye(), Boolean.FALSE);
            JpaUtil.validerTransaction();
            resultat = consultation.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireConsultation(consultation)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public List<String> ObtenirPrediction(String couleur, String animal, int amour, int sante, int travail){
        List<String> prediction = null;
        try{
            prediction = astroUtil.getPredictions(couleur, animal, amour, sante, travail);
        }
        catch(Exception ex){
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service  ObtenirPrediction(couleur, animal, amour, sante, travail)", ex);
            prediction = null;
        }
        return prediction;
    }
    
    
    /**
     * 
     * @param mediumID ID du Medium choisi par le user pour sa futur consultation
     * @return Id de l'employe qui effectura la consultation avec l'employe
     * Id null si aucun employe ne correspond
     */
    
    public Long ChoisirEmploye(Long mediumID){
        Long employeChoisi = null;
        JpaUtil.creerContextePersistance();

        try{
            Medium medium = mediumDao.chercherParId(mediumID);
            List<Employe> possible = usersDao.listerEmployesParGenre(medium.getGenre());
            for(Employe emp : possible){
                if(!emp.getEnConsultation()){
                    employeChoisi = emp.getId();
                    JpaUtil.ouvrirTransaction();
                    usersDao.modifierEtatConsultation(emp, Boolean.TRUE);
                    JpaUtil.validerTransaction();
                }
            }
        }
        catch(Exception ex){
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service ChoisirEmploye(Medium)", ex);
            employeChoisi = null;
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return employeChoisi;
    }
    
    /**
     * 
     * @param client numero de telephone necessaire
     * @param medium Permet d'obtenir la denomination du medium
     * @param employe numero de telephone necessaire
     * 
     */
    
    public void AccepterConsultation(Client client, Medium medium, Employe employe){
        String message = "";
        message += "Vous avez une consultation avec " + medium.getDenomination() + "\n";
        message += "Vous pouvez contacter le medium au " + employe.getNumeroTel() + "\n";
        message += "Merci de la confiance que vous accordée à Predict'IF, et bonne consultation";
        
        messageUtil.envoyerNotification(client.getNumeroTel(), message);
    }
    
    /**
     *
     * @param client
     * @param medium
     * @param employe
     * @param dateDebut
     * @param dateFin
     * @param commentaire
     * @return  ID de la consultation rajoutee dans la base de donnee 
     * 
     * 
     */
    
    public Long EnregistrerConsultation(Client client, Medium medium, Employe employe, Date dateDebut, Date dateFin, String commentaire){
        Long consultationID = null;
        try {
            Long diffInMillies = Math.abs(dateFin.getTime() - dateDebut.getTime());
            Long duree = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
            Consultation nouvelleConsultation = new Consultation(dateDebut, dateFin,  duree, commentaire);
            nouvelleConsultation.setClient(client);
            nouvelleConsultation.setEmploye(employe);
            nouvelleConsultation.setMedium(medium);
            consultationID = inscrireConsultation(nouvelleConsultation);            
            
        }
        catch(Exception ex){
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service ChoisirEmploye(Medium)", ex);
            consultationID = null;
        }
        //Enleve l'employe de la liste des employe en consultation
        return consultationID;
    }
    
    
    public List<Medium> TopMedium(){
        List<Medium> top = null;
        try{
            JpaUtil.creerContextePersistance();
            top = mediumDao.listerTopMedium();
            
        } catch (Exception ex){
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service ChoisirEmploye(Medium)", ex);
            top = null;
        } finally{
            JpaUtil.fermerContextePersistance();
        }
        
        return top;
    }
    
    public Long motDePasseOublie(String mail){
        Users user = rechercherClientParMail(mail);

        Long userID = null;
        
        try{
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            //TODO : A rendre BEAUCOUP plus securise (String random) ou page de 
            // de changement de mot de passe speciale
            usersDao.changerMotDePasse(user, "INSA");
            JpaUtil.validerTransaction();
            
            String corps = "Votre nouveau mot de passe est 'INSA'\n";
            corps += "Veuillez le changer au plus vite";
            messageUtil.envoyerMail("admin@predict-if.fr", mail, "Oubli de mot de passe", corps);
            userID = user.getId();
        } catch(Exception ex){
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service ChoisirEmploye(Medium)", ex);
            JpaUtil.annulerTransaction();
            userID = null;

        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return userID;

    }
    
    public Boolean ChangerMotDePasse(Users client, String nouveauMDP){
        Boolean reussite = false;
        
        try{
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            usersDao.changerMotDePasse(client, nouveauMDP);
            JpaUtil.validerTransaction();
            reussite = true;
        } catch(Exception ex){
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service ChoisirEmploye(Medium)", ex);
            JpaUtil.annulerTransaction();
            reussite = false;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return reussite;
    }
    
}
