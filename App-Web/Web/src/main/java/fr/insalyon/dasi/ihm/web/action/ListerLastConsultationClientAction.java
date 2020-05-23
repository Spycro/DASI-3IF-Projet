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
public class ListerLastConsultationClientAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {

        Service service = new Service();
        
        
        Long ID =Long.parseLong(request.getParameter("id"));
        System.out.println("IDCLIENT :"+ID);
        List<Consultation> liste = service.listerConsultationParClient(ID);

        request.setAttribute("liste", liste);
        
    }
    
}
