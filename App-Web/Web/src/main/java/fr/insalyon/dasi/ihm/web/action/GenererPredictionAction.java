/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Samuel GUYETANT
 */
public class GenererPredictionAction extends Action{
     @Override
    public void executer(HttpServletRequest request) {
        
        Long ID =Long.parseLong(request.getParameter("id"));
        int amour = Integer.parseInt(request.getParameter("amour"));
        int sante = Integer.parseInt(request.getParameter("sante"));
        int travail = Integer.parseInt(request.getParameter("travail"));
        System.out.println("ID="+ID+" amour="+ amour +" sante="+sante+" travail="+travail);
        
        Service service = new Service();
        Client client=service.rechercherClientParId(ID);
        List<String> liste = service.ObtenirPrediction(client.getProfilAstral().getCouleurPorteBonheur(), client.getProfilAstral().getAnimalTotem(), amour, sante, travail);
        request.setAttribute("liste", liste);
        
    }
}
