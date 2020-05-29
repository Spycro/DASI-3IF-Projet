/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import fr.insalyon.dasi.util.MessageUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
public class EnregistrerDemanderConsultationAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        Long mediumId = Long.parseLong(request.getParameter("medium-id"));
        
        HttpSession session = request.getSession();
        Long idc=(Long)session.getAttribute("idClient");
        
        Long empId = service.ChoisirEmploye(mediumId);
        System.out.println("client : " + idc + " medium : " + mediumId + " employe : "+empId );
        Client client = service.rechercherClientParId(idc);
        Medium medium = service.rechercherMediumParId(mediumId);
        Employe employe = service.rechercherEmployeParId(empId);
        MessageUtil.envoyerNotification(employe.getNumeroTel(), "Bonjour, "+ employe.getPrenom() +" "+ employe.getNom()  + ". Vous avez une consultation en attente avec un client. Vous pourrez voir ses informations dans votre espace employe. Veuillez repondre a la demande rapidement");
        
        Long cid = service.EnregistrerDemandeConsultation(client, medium, employe);
        request.setAttribute("consultation-id", cid);
    }
    
}
