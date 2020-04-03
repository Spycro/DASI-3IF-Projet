package fr.insalyon.dasi.ihm.console;

import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.ProfilAstral;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.modele.Users;
import fr.insalyon.dasi.metier.service.Service;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DASI Team
 */
public class Main {

    public static void main(String[] args) {

        // TODO : Pensez à créer une unité de persistance "DASI-PU" et à vérifier son nom dans la classe JpaUtil
        // Contrôlez l'affichage du log de JpaUtil grâce à la méthode log de la classe JpaUtil
        JpaUtil.init();

        //initialiserClients();            // Question 3
        //testerInscriptionClient();       // Question 4 & 5
        //testerRechercheClient();         // Question 6
        //testerListeClients();            // Question 7
        //testerAuthentificationClient();  // Question 8
        //saisirInscriptionClient();       // Question 9
        //saisirRechercheClient();
        //testerInscriptionMedium();
        //testerInscriptionClient();
        testerInscriptionConsultation();
        
        JpaUtil.destroy();
    }

    
    
    
    
    public static void afficherProfil(ProfilAstral profil) {
        System.out.println("-> " + profil);
    }
    
    public static void testerInscriptionProfil() {
        
        System.out.println();
        System.out.println("**** testerInscriptionClient() ****");
        System.out.println();
        
        Service service = new Service();
        ProfilAstral profil1 = new ProfilAstral("Cancer", "Chat", "jaune", "voiture");
        Long profil1ID = service.inscrireProfilAstral(profil1);
        if (profil1ID != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherProfil(profil1);

        ProfilAstral profil2 = new ProfilAstral("Cancer", "chien", "jaune", "chat");
        Long idProfil2 = service.inscrireProfilAstral(profil2);
        if (idProfil2 != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherProfil(profil2);

        /*Client hedwig = new Client("Lamarr", "Hedwig Eva Maria", "hlamarr@insa-lyon.fr", "WiFi");
        Long idHedwig = service.inscrireClient(hedwig);
        if (idHedwig != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(hedwig);*/
    }
    
    public static void testerInscriptionClient() {
        
        System.out.println();
        System.out.println("**** testerInscriptionClient() ****");
        System.out.println();
        
        
        
        Service service = new Service();
        
        ProfilAstral profil2 = new ProfilAstral("Cancer", "chien", "jaune", "chat");
        Long idProfil2 = service.inscrireProfilAstral(profil2);
        if (idProfil2 != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherProfil(profil2);

        
        Users user1 = new Client("Jean", "bon", "3636", "11 rue", 25, profil2, Date.valueOf("2015-12-25"), "12345", "l@g.com");
        Long profil1ID = service.inscrireClient(user1);
        if (profil1ID != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }

      
        /*Client hedwig = new Client("Lamarr", "Hedwig Eva Maria", "hlamarr@insa-lyon.fr", "WiFi");
        Long idHedwig = service.inscrireClient(hedwig);
        if (idHedwig != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(hedwig);*/
    }
    
    public static void testerInscriptionEmploye() {
        
        System.out.println();
        System.out.println("**** testerInscriptionClient() ****");
        System.out.println();
        
        
        
        Service service = new Service();
        
        

        
        Users user1 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        Long profil1ID = service.inscrireClient(user1);
        if (profil1ID != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }

      
        /*Client hedwig = new Client("Lamarr", "Hedwig Eva Maria", "hlamarr@insa-lyon.fr", "WiFi");
        Long idHedwig = service.inscrireClient(hedwig);
        if (idHedwig != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(hedwig);*/
    }
    
    
    /*
    public static void afficherClient(Client client) {
        System.out.println("-> " + client);
    }

    public static void initialiserClients() {
        
        System.out.println();
        System.out.println("**** initialiserClients() ****");
        System.out.println();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DASI-PU");
        EntityManager em = emf.createEntityManager();

        User ada = new Client("Lovelace", "Ada", "ada.lovelace@insa-lyon.fr", "Ada1012", );
        
        
        System.out.println();
        System.out.println("** Clients avant persistance: ");
        afficherClient(ada);
        afficherClient(blaise);
        afficherClient(fred);
        System.out.println();

        try {
            em.getTransaction().begin();
            em.persist(ada);
            em.persist(blaise);
            em.persist(fred);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em.close();
        }

        System.out.println();
        System.out.println("** Clients après persistance: ");
        afficherClient(ada);
        afficherClient(blaise);
        afficherClient(fred);
        System.out.println();
    }

    public static void testerInscriptionClient() {
        
        System.out.println();
        System.out.println("**** testerInscriptionClient() ****");
        System.out.println();
        
        Service service = new Service();
        Client claude = new Client("Chappe", "Claude", "claude.chappe@insa-lyon.fr", "HaCKeR");
        Long idClaude = service.inscrireClient(claude);
        if (idClaude != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(claude);

        Client hedy = new Client("Lamarr", "Hedy", "hlamarr@insa-lyon.fr", "WiFi");
        Long idHedy = service.inscrireClient(hedy);
        if (idHedy != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(hedy);

        Client hedwig = new Client("Lamarr", "Hedwig Eva Maria", "hlamarr@insa-lyon.fr", "WiFi");
        Long idHedwig = service.inscrireClient(hedwig);
        if (idHedwig != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(hedwig);
    }

    public static void testerRechercheClient() {
        
        System.out.println();
        System.out.println("**** testerRechercheClient() ****");
        System.out.println();
        
        Service service = new Service();
        long id;
        Client client;

        id = 1;
        System.out.println("** Recherche du Client #" + id);
        client = service.rechercherClientParId(id);
        if (client != null) {
            afficherClient(client);
        } else {
            System.out.println("=> Client non-trouvé");
        }

        id = 3;
        System.out.println("** Recherche du Client #" + id);
        client = service.rechercherClientParId(id);
        if (client != null) {
            afficherClient(client);
        } else {
            System.out.println("=> Client non-trouvé");
        }

        id = 17;
        System.out.println("** Recherche du Client #" + id);
        client = service.rechercherClientParId(id);
        if (client != null) {
            afficherClient(client);
        } else {
            System.out.println("=> Client #" + id + " non-trouvé");
        }
    }

    public static void testerListeClients() {
        
        System.out.println();
        System.out.println("**** testerListeClients() ****");
        System.out.println();
        
        Service service = new Service();
        List<Client> listeClients = service.listerClients();
        System.out.println("*** Liste des Clients");
        if (listeClients != null) {
            for (Client client : listeClients) {
                afficherClient(client);
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }

    public static void testerAuthentificationClient() {
        
        System.out.println();
        System.out.println("**** testerAuthentificationClient() ****");
        System.out.println();
        
        Service service = new Service();
        Client client;
        String mail;
        String motDePasse;

        mail = "ada.lovelace@insa-lyon.fr";
        motDePasse = "Ada1012";
        client = service.authentifierClient(mail, motDePasse);
        if (client != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherClient(client);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }

        mail = "ada.lovelace@insa-lyon.fr";
        motDePasse = "Ada2020";
        client = service.authentifierClient(mail, motDePasse);
        if (client != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherClient(client);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }

        mail = "etudiant.fictif@insa-lyon.fr";
        motDePasse = "********";
        client = service.authentifierClient(mail, motDePasse);
        if (client != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherClient(client);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }
    }

    public static void saisirInscriptionClient() {
        Service service = new Service();

        System.out.println();
        System.out.println("Appuyer sur Entrée pour passer la pause...");
        Saisie.pause();

        System.out.println();
        System.out.println("**************************");
        System.out.println("** NOUVELLE INSCRIPTION **");
        System.out.println("**************************");
        System.out.println();

        String nom = Saisie.lireChaine("Nom ? ");
        String prenom = Saisie.lireChaine("Prénom ? ");
        String mail = Saisie.lireChaine("Mail ? ");
        String motDePasse = Saisie.lireChaine("Mot de passe ? ");

        Client client = new Client(nom, prenom, mail, motDePasse);
        Long idClient = service.inscrireClient(client);

        if (idClient != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherClient(client);

    }

    public static void saisirRechercheClient() {
        Service service = new Service();

        System.out.println();
        System.out.println("*********************");
        System.out.println("** MENU INTERACTIF **");
        System.out.println("*********************");
        System.out.println();

        Saisie.pause();

        System.out.println();
        System.out.println("**************************");
        System.out.println("** RECHERCHE de CLIENTS **");
        System.out.println("**************************");
        System.out.println();
        System.out.println();
        System.out.println("** Recherche par Identifiant:");
        System.out.println();

        Integer idClient = Saisie.lireInteger("Identifiant ? [0 pour quitter] ");
        while (idClient != 0) {
            Client client = service.rechercherClientParId(idClient.longValue());
            if (client != null) {
                afficherClient(client);
            } else {
                System.out.println("=> Client #" + idClient + " non-trouvé");
            }
            System.out.println();
            idClient = Saisie.lireInteger("Identifiant ? [0 pour quitter] ");
        }

        System.out.println();
        System.out.println("********************************");
        System.out.println("** AUTHENTIFICATION de CLIENT **");
        System.out.println("********************************");
        System.out.println();
        System.out.println();
        System.out.println("** Authentifier Client:");
        System.out.println();

        String clientMail = Saisie.lireChaine("Mail ? [0 pour quitter] ");

        while (!clientMail.equals("0")) {
            String clientMotDePasse = Saisie.lireChaine("Mot de passe ? ");
            Client client = service.authentifierClient(clientMail, clientMotDePasse);
            if (client != null) {
                afficherClient(client);
            } else {
                System.out.println("=> Client non-authentifié");
            }
            clientMail = Saisie.lireChaine("Mail ? [0 pour quitter] ");
        }

        System.out.println();
        System.out.println("*****************");
        System.out.println("** AU REVOIR ! **");
        System.out.println("*****************");
        System.out.println();

    }
    */
    public static void testerInscriptionMedium() {
        
        System.out.println();
        System.out.println("**** testerInscriptionMedium() ****");
        System.out.println();
        
        Service service = new Service();
        Medium irma = new Cartomancien("Irma","F","Yo moi c'est IRMA");
        Long idIrma = service.inscrireMedium(irma);
        if (idIrma != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        System.out.println(irma.toString());
        
        Medium david = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        Long idDavid = service.inscrireMedium(david);
        if (idDavid != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        System.out.println(david.toString());
      
    }
    public static void testerInscriptionConsultation(){
        System.out.println();
        System.out.println("**** testerInscriptionConsultation() ****");
        System.out.println();
        
        Service service = new Service();
        Medium david = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(david);
        ProfilAstral profil2 = new ProfilAstral("Cancer", "chien", "jaune", "chat");
        service.inscrireProfilAstral(profil2);
        Users user1 = new Client("Jean", "bon", "3636", "11 rue", 25, profil2, Date.valueOf("2015-12-25"), "12345", "l@g.com");
        service.inscrireClient(user1);
        Users user2 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        service.inscrireClient(user2);
        Consultation consult1 = new Consultation(Date.valueOf("2015-12-25"),12,Date.valueOf("2015-12-25"),Date.valueOf("2015-12-25"),"c t bi1",(Client)user1,(Employe)user2,david);
        Long idc1 = service.inscrireConsultation(consult1);
        if (idc1 != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        System.out.println(consult1.toString());
        
        /*Consultation consult2 = new Consultation(Date.valueOf("2015-12-25"),12,Date.valueOf("2015-12-25"),Date.valueOf("2015-12-25"),"franchement pas fou");
        Long idc2 = service.inscrireConsultation(consult2);
        if (idc2 != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        System.out.println(consult2.toString());*/
      
    }
}
