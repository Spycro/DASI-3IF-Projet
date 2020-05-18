/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.service.Service;
import fr.insalyon.dasi.util.MessageUtil;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lucas
 */
public class ForgotClientAction extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        String mail = request.getParameter("mail");
        
        Client client = service.rechercherClientParMail(mail);
        if(client != null) {
            MessageUtil.envoyerMail("predicitf@insa.fr", client.getMail(), "Mot de passe", client.getMotDePasse());
        }
        request.setAttribute("client", client);
        
    }
    
}
