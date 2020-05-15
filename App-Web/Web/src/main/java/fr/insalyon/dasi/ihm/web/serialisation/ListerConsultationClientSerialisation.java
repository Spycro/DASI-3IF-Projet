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
public class ListerConsultationClientSerialisation extends Serialisation {
    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Consultation> target = (List<Consultation>)request.getAttribute("liste");
        JsonObject container = new JsonObject();
        JsonArray listeConsult = new JsonArray();
        for(Consultation consult : target){
            JsonObject m = new JsonObject();
            m.addProperty("duré", consult.getDuree());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
            m.addProperty("dateDebut", dateFormat.format(consult.getDateDebut()));
            m.addProperty("dateFin", dateFormat.format(consult.getDateFin()));
            m.addProperty("client", consult.getClient().getNom()+" "+consult.getClient().getPrenom());
            m.addProperty("medium", consult.getMedium().getDenomination());
          
            listeConsult.add(m);
        }
        
        container.add("consultation", listeConsult);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();

    }
}
