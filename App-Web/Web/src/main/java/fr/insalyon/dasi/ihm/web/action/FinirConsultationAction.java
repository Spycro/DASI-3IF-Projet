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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
public class FinirConsultationAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        String dateDeb = request.getParameter("debut");
        String dateFin = request.getParameter("fin");
        String commentaire = request.getParameter("commentaire");
        HttpSession session = request.getSession();
        Long idEmp=(Long)session.getAttribute("idEmploye");
        Consultation consult = service.obtenirConsultationEmploye(idEmp);
        System.out.println(consult);
        
        
        
        
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date parsedDateDeb = dateFormat.parse(dateDeb);
            Date parsedDateFin = dateFormat.parse(dateFin);
            
            Long cid = service.ValiderConsultation(parsedDateDeb, parsedDateFin, commentaire, consult.getId());
            request.setAttribute("consultation-id", cid);
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption 
            request.setAttribute("consultation-id", null);
            System.out.println("BAd date");
        }
    }
    
}
