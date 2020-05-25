/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Employe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class TopEmployeSerialisation extends Serialisation{

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Employe> target = (List<Employe>)request.getAttribute("liste-employe");
        JsonObject container = new JsonObject();
        JsonArray listeEmploye = new JsonArray();
        if(target!=null){
            
        
            for(Employe emp : target){
                JsonObject m = new JsonObject();
                m.addProperty("id", emp.getId());
                m.addProperty("nom", emp.getNom());
                m.addProperty("genre", emp.getGenre());
                m.addProperty("prenom", emp.getPrenom());
                m.addProperty("nb-consultation", emp.getNbConsultations());

                listeEmploye.add(m);
            }
            container.addProperty("success", Boolean.TRUE);
        }
        else{
            container.addProperty("success", Boolean.FALSE);
        }
        container.add("employes", listeEmploye);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }
    
}
