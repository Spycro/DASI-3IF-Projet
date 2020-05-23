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
import com.google.gson.reflect.TypeToken;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel GUYETANT
 */
public class ListerLastConsultationClientSerialisation extends Serialisation {
    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Consultation> target = (List<Consultation>)request.getAttribute("liste");
        JsonObject container = new JsonObject();
        
        
            JsonObject m = new JsonObject();
            m.addProperty("duree", target.get(target.size()-1).getDuree());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
            m.addProperty("dateDebut", dateFormat.format(target.get(target.size()-1).getDateDebut()));
            m.addProperty("dateFin", dateFormat.format(target.get(target.size()-1).getDateFin()));
            m.addProperty("client", target.get(target.size()-1).getClient().getNom()+" "+target.get(target.size()-1).getClient().getPrenom());
            m.addProperty("medium", target.get(target.size()-1).getMedium().getDenomination());
            m.addProperty("commentaire", target.get(target.size()-1).getCommentaire());
          
            
        
        
        container.add("consultation", m);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();

    }
}
