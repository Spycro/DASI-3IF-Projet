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
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class ListerMediumSerialisation extends Serialisation{

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Medium> target = (List<Medium>)request.getAttribute("liste");
        JsonObject container = new JsonObject();
        JsonArray listeMedium = new JsonArray();
        for(Medium med : target){
            JsonObject m = new JsonObject();
            m.addProperty("id", med.getId());
            m.addProperty("denomination", med.getDenomination());
            m.addProperty("genre", med.getGenre());
            m.addProperty("presentation", med.getPresentation());
            m.addProperty("nbConsulation", med.getNbConsultation());
            if(med instanceof Astrologue){
                Astrologue a = (Astrologue)med;
                m.addProperty("type", "astrologue");
                m.addProperty("formation", a.getFormation());
                m.addProperty("promotion", a.getPromotion());
            }
            if(med instanceof Cartomancien ){
                m.addProperty("type", "cartomancien");
            }
            
            if(med instanceof Spirite){
                m.addProperty("type", "spirite");
                Spirite s = (Spirite)med;
                m.addProperty("support", s.getSupport());
            }
            listeMedium.add(m);
        }
        
        container.add("mediums", listeMedium);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();

    }
    
}
