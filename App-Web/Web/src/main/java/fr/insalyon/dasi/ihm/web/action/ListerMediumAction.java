package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class ListerMediumAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {

        Service service = new Service();
        List<Medium> liste = service.listerMedium();

        request.setAttribute("liste", liste);
        
    }
    
}
