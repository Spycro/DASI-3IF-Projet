/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
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
        HttpSession session = request.getSession();
        
        Long employeId =(Long)session.getAttribute("idEmploye");
        Service service = new Service();
        
        Consultation c = service.obtenirConsultationEmploye(employeId);
        
        if(c==null){
            request.setAttribute("done", Boolean.FALSE);
        }else {
            service.AccepterConsultation(c.getClient(), c.getMedium(), c.getEmploye());
            request.setAttribute("done", Boolean.TRUE);
        }
        
    }
    
}
