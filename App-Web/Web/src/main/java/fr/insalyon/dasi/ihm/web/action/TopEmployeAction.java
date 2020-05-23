/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lucas
 */
public class TopEmployeAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        Service service = new Service();
        List<Employe> list = service.listerEmployeParConsultation();
        
        request.setAttribute("liste-employe", list);
        
    }
    
}
