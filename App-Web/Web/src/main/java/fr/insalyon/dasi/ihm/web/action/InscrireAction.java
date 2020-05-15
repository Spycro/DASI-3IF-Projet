/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.service.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucas
 */
public class InscrireAction extends Action {
    @Override
    public void executer(HttpServletRequest request) {
        //?todo=inscription&mail=a@b.c&password=abc&date=11%2F11%2F2001&adresse=ruedu&numero=1111
        Service service = new Service();
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String date = request.getParameter("date");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String numero = request.getParameter("numero");
        
        
        Date date1;  
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            Client client = new Client(nom, prenom, numero, adresse, 10, date1, password, mail);
            Long id = service.inscrireClient(client);
            request.setAttribute("id", id);
        } catch (ParseException ex) {
            Logger.getLogger(InscrireAction.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("id", null);
        } catch (NullPointerException ex) {
            Logger.getLogger(InscrireAction.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("id", null);
        } 
        
    }
    
}
