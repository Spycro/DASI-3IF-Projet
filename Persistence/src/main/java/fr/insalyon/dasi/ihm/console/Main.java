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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

        //initialiserClients();         
        //testerInscriptionClient();       
        //testerRechercheClient();        
        //testerListeClients();            
        //testerAuthentificationClient();  
        //testerInscriptionMedium();
        //testerInscriptionClient();
        //testerInscriptionConsultation();
        //testerChoisirEmploye();
        //testerAccepterConsultation();
        //testerEnregistrerConsultation();
        //testerTopMedium();
        //testerMotDePasseOublie();
        //testerChangerMotDePasse();
        //testerRechercheConsultationParId()
        //testerListeConsultation();
        //testerListeConsultationParClient();
        //testerListeConsultationParEmploye();
        //testerListeConsultationParMedium();
        JpaUtil.destroy();
    }

    
    
    
    

    public static void afficherProfil(ProfilAstral profil) {
        System.out.println("-> " + profil);
    }
    
    public static void testerInscriptionProfil() {
        
        System.out.println();
        System.out.println("**** testerInscriptionProfil() ****");
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
        Long idHedwig = service.inscrireUsers(hedwig);
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
        


        
        Client user1 = new Client("Jean", "bon", "3636", "11 rue", 25, new Date(), "12345", "l@g.com");
        Long profil1ID = service.inscrireClient(user1);
        if (profil1ID != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }

    }
    
    public static void testerInscriptionEmploye() {
        
        System.out.println();
        System.out.println("**** testerInscriptionEmploye() ****");
        System.out.println();
        
        
        
        Service service = new Service();
        
        

        
        Users user1 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        Long profil1ID = service.inscrireUsers(user1);
        if (profil1ID != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
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

        mail = "l@g.com";
        motDePasse = "12345";
        client = service.authentifierClient(mail, motDePasse);
        if (client != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherClient(client);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }
    }
    
    public static void testerAuthentificationEmploye() {
        
        System.out.println();
        System.out.println("**** testerAuthentificationEmploye() ****");
        System.out.println();
        
        Service service = new Service();
        Employe employe;
        String mail;
        String motDePasse;

        mail = "ada.lovelace@insa-lyon.fr";
        motDePasse = "Ada1012";
        employe = service.authentifierEmploye(mail, motDePasse);
        if (employe != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherEmploye(employe);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }

        mail = "l@g.com";
        motDePasse = "12345";
        employe = service.authentifierEmploye(mail, motDePasse);
        if (employe != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherEmploye(employe);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }

    }

    public static void afficherClient(Client client) {
        System.out.println("-> " + client);
    }
    
    public static void afficherEmploye(Employe employe) {
        System.out.println("-> " + employe);
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

    public static void testerListeMedium() {
        
        System.out.println();
        System.out.println("**** testerListeMedium() ****");
        System.out.println();
        
        Service service = new Service();
        List<Medium> listeMediums = service.listerMedium();
        System.out.println("*** Liste des Medium");
        if (listeMediums != null) {
            for (Medium medium : listeMediums) {
                afficherMedium(medium);
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }
    
    public static void testerListeConsultation() {
        
        System.out.println();
        System.out.println("**** testerListeConsultation() ****");
        System.out.println();
        
        Service service = new Service();
        List<Consultation> listeConsultation = service.listerConsultation();
        System.out.println("*** Liste des Medium");
        if (listeConsultation != null) {
            for (Consultation consult : listeConsultation) {
                System.out.println(consult.toString());
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }
    
    public static void testerListeConsultationParClient() {
        
        System.out.println();
        System.out.println("**** testerListeConsultationParClient() ****");
        System.out.println();
        
        Service service = new Service();
        long id=1;
        List<Consultation> listeConsultation = service.listerConsultationParClient(id);
        System.out.println("*** Liste des Medium");
        if (listeConsultation != null) {
            for (Consultation consult : listeConsultation) {
                System.out.println(consult.toString());
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }
    
    public static void testerListeConsultationParEmploye() {
        
        System.out.println();
        System.out.println("**** testerListeConsultationParEmploye() ****");
        System.out.println();
        
        Service service = new Service();
        long id=1;
        List<Consultation> listeConsultation = service.listerConsultationParEmploye(id);
        System.out.println("*** Liste des Medium");
        if (listeConsultation != null) {
            for (Consultation consult : listeConsultation) {
                System.out.println(consult.toString());
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }
    
    public static void testerListeConsultationParMedium() {
        
        System.out.println();
        System.out.println("**** testerListeConsultationParMedium() ****");
        System.out.println();
        
        Service service = new Service();
        long id=1;
        List<Consultation> listeConsultation = service.listerConsultationParMedium(id);
        System.out.println("*** Liste des Medium");
        if (listeConsultation != null) {
            for (Consultation consult : listeConsultation) {
                System.out.println(consult.toString());
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }
     
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

        
        Users user1 = new Client("Jean", "bon", "3636", "11 rue", 25, new Date(), "12345", "l@g.com");
        service.inscrireUsers(user1);
        
        Users user2 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        service.inscrireUsers(user2);
        
        Consultation consult1 = new Consultation(new Date(),new Date(),12L,"c t bi1");
        
        consult1.setClient((Client)user1);
        consult1.setEmploye((Employe)user2);
        consult1.setMedium(david);
        
        Long idc1 = service.inscrireConsultation(consult1);
        
        
        if (idc1 != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        System.out.println(consult1.toString());
        
      
    }
    
    public static void testerListerEmployeParGenre(){
         
        System.out.println();
        System.out.println("**** testerListerEmployeParGenre() ****");
        System.out.println();
        
        
        
        Service service = new Service();
        
        

        
        Users user1 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        Long profil1ID = service.inscrireUsers(user1);
        Users user2 = new Employe("Jean3", "bon3", "3636",  25, "M", 0, "12345", "l@g.fr");
        Long profil2ID = service.inscrireUsers(user2);
        Users user3 = new Employe("Jeanne", "bonne", "3636",  25, "F", 0, "12345", "l@g.po");
        Long profil3ID = service.inscrireUsers(user3);
        
        List<Employe> genre;
        
    }
    
    public static void testerChoisirEmploye(){
        
        System.out.println();
        System.out.println("**** testerChoisirEmploye() ****");
        System.out.println();
        
        /*
        L'utilisateur vient de choisir son medium
        On a donc un ID de medium
        */
        Service service = new Service();
        Medium david = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        Long mediumID = service.inscrireMedium(david);
        if(mediumID == null){
            System.out.println("Probleme d'inscription du medium");
        }
        
        Employe user1 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        service.inscrireUsers(user1);
        
        Long employeChoisi = service.ChoisirEmploye(mediumID);
        if(employeChoisi !=null){
            System.out.println(service.rechercherEmployeParId(employeChoisi));
        }
        else {
            System.out.println("Echec de la recherche / Pas d'employe disponibles");
        }
        
        /*
        On reessaye, normalement on doit avoir un id d'client null
        */
        Long employeChoisi2 = service.ChoisirEmploye(mediumID);
        if(employeChoisi2 !=null){
            System.out.println(service.rechercherEmployeParId(employeChoisi2));
        }
        else {
            System.out.println("Echec de la recherche / Pas d'employe disponibles");
        }
        
    }
   
    public static void testerAccepterConsultation(){
        
        System.out.println();
        System.out.println("**** testerAccepterConsultation() ****");
        System.out.println();
        
        Service service = new Service();
        
        Medium david = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(david);

        
        Client user1 = new Client("Jean", "bon", "3630", "11 rue", 25, new Date(), "12345", "l@g.com");
        service.inscrireUsers(user1);
        
        Employe user2 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        service.inscrireUsers(user2);
        
        service.AccepterConsultation(user1, david, user2);
        
        
        
        
    }
    
    public static void testerEnregistrerConsultation() {
        System.out.println();
        System.out.println("**** testerEnregistrerConsultation() ****");
        System.out.println();
        
        
        
        Service service = new Service();  
        
        Medium david = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        Long mediumID = service.inscrireMedium(david);

        
        Client user1 = new Client("Jean", "bon", "3630", "11 rue", 25, new Date(), "12345", "l@g.com");
        service.inscrireUsers(user1);
        
        Employe user2 = new Employe("Jean", "bon", "3636",  25, "M", 0, "12345", "l@g.com");
        service.inscrireUsers(user2);
     
        //On choisit l'client puis on accepte la consultation
        service.ChoisirEmploye(mediumID);
        service.AccepterConsultation(user1, david, user2);
        
        Long consultationID = null;
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
        String datedeb = "10-10-2001 13:50:20";
        String datefin = "10-10-2001 14:50:20";
        try{
            Date dateDeb = format.parse(datedeb);
            Date dateFin = format.parse(datefin);
            consultationID = service.EnregistrerConsultation(user1, david, user2, dateDeb, dateFin, "Pas trop mal");
            consultationID = service.EnregistrerConsultation(user1, david, user2, dateDeb, dateFin, "Assez cool");


        } catch(Exception ex){
            System.out.println("Bad date");
        }
        
        
        if (consultationID != null) {
            System.out.println("> Succès Energistrement consultation");
        } else {
            System.out.println("> Échec Energistrement consultation");
        }
        
    }
    
    public static void testerTopMedium(){
        System.out.println();
        System.out.println("**** testerTopMedium() ****");
        System.out.println();
        
        
        Service service = new Service();  
        
        Medium david = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        Long mediumID = service.inscrireMedium(david);
        
        Medium a = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(a);
        
        Medium b = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(b);
        
        Medium c = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(c);
        
        Medium d = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(d);
        
        Medium e = new Spirite("David","M","Yo tout le monde c'est david lafarge pokemon","cartes pokemon");
        service.inscrireMedium(e);
        
        List<Medium> top = service.TopMedium();
        for(int i = 0; i<5; i++){
            System.out.println(top.get(i));
        }
        
    }
    
    public static void testerMotDePasseOublie(){
        System.out.println();
        System.out.println("**** testerMotDePasseOublie() ****");
        System.out.println();
        
        
        Service service = new Service();  
        
        Client user1 = new Client("Jean", "bon", "3636", "11 rue", 25, new Date(), "12345", "l@g.com");
        Long profil1ID = service.inscrireClient(user1);
        
        System.out.println("MDP avant changement : " + user1.getMotDePasse());
        service.motDePasseOublie("l@g.com");
        user1 = service.rechercherClientParMail("l@g.com");
        System.out.println("MDP apres changement : " + user1.getMotDePasse());
    }
    
    public static void testerChangerMotDePasse(){
        System.out.println();
        System.out.println("**** testerChangerMotDePasse() ****");
        System.out.println();
        
        
        Service service = new Service();  
        
        Client user1 = new Client("Jean", "bon", "3636", "11 rue", 25, new Date(), "12345", "l@g.com");
        Long profil1ID = service.inscrireClient(user1);
        
        System.out.println("MDP avant changement : " + user1.getMotDePasse());
        service.ChangerMotDePasse(user1, "54321");
        user1 = service.rechercherClientParMail("l@g.com");
        System.out.println("MDP apres changement : " + user1.getMotDePasse());
    }

    private static void afficherMedium(Medium medium) {
         System.out.println("-> " + medium);
    }
    public static void testerRechercheConsultationParId() {
        
        System.out.println();
        System.out.println("**** testerRechercheConsultationParId() ****");
        System.out.println();
        
        Service service = new Service();
        long id;
        Consultation consult;

        id = 1;
        System.out.println("** Recherche de la consultation #" + id);
        consult = service.rechercherConsultationParId(id);
        if (consult != null) {
            System.out.println(consult.toString());
        } else {
            System.out.println("=> Consultation non-trouvé");
        }

        id = 3;
        System.out.println("** Recherche de la consultation #" + id);
        consult = service.rechercherConsultationParId(id);
        if (consult != null) {
            System.out.println(consult.toString());
        } else {
            System.out.println("=> Consultation non-trouvé");
        }

        id = 17;
        System.out.println("** Recherche de la consultation #" + id);
        consult = service.rechercherConsultationParId(id);
        if (consult != null) {
            System.out.println(consult.toString());
        } else {
            System.out.println("=> Consultation #" + id + " non-trouvé");
        }
    }
    
}
