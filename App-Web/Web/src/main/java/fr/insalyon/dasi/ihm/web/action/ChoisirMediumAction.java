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

/**
 *
 * @author Lucas
 */
public class ChoisirMediumAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        
        String mediumId = request.getParameter("medium_id");
        String clientId = request.getParameter("client_id");
        Client client = service.rechercherClientParId(Long.parseLong(clientId));
        Medium medium = service.rechercherMediumParId(Long.parseLong(mediumId));
        
        Long employe_choisi = service.ChoisirEmploye(Long.parseLong(mediumId));
        if(employe_choisi!=null){
            Employe employe = service.rechercherEmployeParId(employe_choisi);
            MessageUtil.envoyerNotification(employe.getNumeroTel(), "Vous avez une consultation en attente avec un client. Vous pourrez voir ses informations dans votre espace employe. Veuillez repondre a la demande rapidement");
            request.setAttribute("succes", Boolean.TRUE);
        }
        
    }
    
}
