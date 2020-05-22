/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
public class ObtenirProfilClientConnecteAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        HttpSession session = request.getSession();
        Long idc=(Long)session.getAttribute("idClient");
        
        Client client = service.rechercherClientParId(idc);
        
        request.setAttribute("client", client);
    }
    
}
