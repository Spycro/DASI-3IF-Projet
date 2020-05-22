/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Consultation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class ObtenirConsultationSerialisation extends Serialisation{

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Consultation consult = (Consultation)request.getAttribute("consultation");
        
        JsonObject container = new JsonObject();
        
        if(consult != null) {
            JsonObject consultJson = new JsonObject();
            consultJson.addProperty("client-id", consult.getClient().getId());
            consultJson.addProperty("client-name", consult.getClient().getPrenom());
            consultJson.addProperty("client-surname", consult.getClient().getNom());
            consultJson.addProperty("employe-id", consult.getEmploye().getId());
            consultJson.addProperty("medium-id", consult.getMedium().getId());
            consultJson.addProperty("medium-denomination", consult.getMedium().getDenomination());
            container.add("consultation", consultJson);
            container.addProperty("success", Boolean.TRUE);
            
        }
        else {
            container.addProperty("success", Boolean.FALSE);
        }


        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();    
    }
    
}
