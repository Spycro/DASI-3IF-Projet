package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class ListerConsultationClientAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {

        Service service = new Service();
        HttpSession session = request.getSession();
        
        Long idc=(Long)session.getAttribute("idClient");
       
        List<Consultation> liste = service.listerConsultationParClient(idc);

        request.setAttribute("liste", liste);
        
    }
    
}
