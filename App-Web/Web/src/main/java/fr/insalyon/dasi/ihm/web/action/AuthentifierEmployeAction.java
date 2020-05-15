/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
public class AuthentifierEmployeAction extends Action{

    @Override
    public void executer(HttpServletRequest request) {
        String login = request.getParameter("mail");
        String pass = request.getParameter("password");
        
        Service service = new Service();
        Employe employe = service.authentifierEmploye(login, pass);

        request.setAttribute("employe", employe);
        
        // Gestion de la Session: ici, enregistrer l'ID du Client authentifié
        HttpSession session = request.getSession();
        if (employe != null) {
            session.setAttribute("idEmploye", employe.getId());
        }
        else {
            session.removeAttribute("idEmploye");
        }
        
    }
    
}
