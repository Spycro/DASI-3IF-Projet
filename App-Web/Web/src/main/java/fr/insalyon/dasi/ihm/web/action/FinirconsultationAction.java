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

/**
 *
 * @author Lucas
 */
public class FinirconsultationAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        String dateDeb = request.getParameter("debut");
        String dateFin = request.getParameter("fin");
        String commentaire = request.getParameter("commentaire");
        String clientId = request.getParameter("client");
        String employeId = request.getParameter("employe");
        String mediumId = request.getParameter("medium");
        
        
        Service service = new Service();
        Client client = service.rechercherClientParId(Long.parseLong(clientId));
        Employe employe = service.rechercherEmployeParId(Long.parseLong(employeId));
        Medium medium = service.rechercherMediumParId(Long.parseLong(mediumId));
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDateDeb = dateFormat.parse(dateDeb);
            Date parsedDateFin = dateFormat.parse(dateFin);
            Consultation consultation = new Consultation();
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption 
        }
    }
    
}
