/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
public class ObtenirProfilClientAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        Long idClient = Long.parseLong(request.getParameter("idclient"));
        Client client = service.rechercherClientParId(idClient);
        
        request.setAttribute("client",client);
        
    }
       

    
}
