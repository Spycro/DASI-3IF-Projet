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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
public class AccepterConsultationAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        String clientId = request.getParameter("client");
        String mediumId = request.getParameter("medium");
        HttpSession session = request.getSession();
        
        Long employeId =(Long)session.getAttribute("idEmploye");
        System.out.println(clientId + " " + mediumId + " " + employeId);
        Service service = new Service();
        
        Client client = service.rechercherClientParId(Long.parseLong(clientId));
        Employe employe = service.rechercherEmployeParId(employeId);
        Medium medium = service.rechercherMediumParId(Long.parseLong(mediumId));
        if(client ==null || medium == null || employe == null){
            request.setAttribute("done", Boolean.FALSE);
        }else {
            service.AccepterConsultation(client, medium, employe);
            request.setAttribute("done", Boolean.TRUE);
        }
        
    }
    
}
