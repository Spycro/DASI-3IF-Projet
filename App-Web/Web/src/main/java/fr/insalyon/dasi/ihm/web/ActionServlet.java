package fr.insalyon.dasi.ihm.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.ihm.web.action.Action;
import fr.insalyon.dasi.ihm.web.action.AuthentifierClientAction;
import fr.insalyon.dasi.ihm.web.action.AuthentifierEmployeAction;
import fr.insalyon.dasi.ihm.web.action.ForgotClientAction;
import fr.insalyon.dasi.ihm.web.action.ForgotEmployeAction;
import fr.insalyon.dasi.ihm.web.action.InscrireAction;
import fr.insalyon.dasi.ihm.web.action.ListerConsultationAction;
import fr.insalyon.dasi.ihm.web.action.ListerConsultationClientAction;
import fr.insalyon.dasi.ihm.web.action.ListerConsultationEmployeAction;
import fr.insalyon.dasi.ihm.web.action.ListerMediumAction;
import fr.insalyon.dasi.ihm.web.action.ObtenirProfilClientAction;
import fr.insalyon.dasi.ihm.web.serialisation.AuthentifierEmployeSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ForgotClientSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ForgotEmployeSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.InscrireSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ListerConsultationClientSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ListerConsultationEmployeSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ListerConsultationSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ListerMediumSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ProfilClientSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.Serialisation;
import fr.insalyon.dasi.metier.modele.Medium;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DASI Team
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        JpaUtil.destroy();
        super.destroy();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");

        String todo = request.getParameter("todo");

        Action action = null;
        Serialisation serialisation = null;

        if (todo != null) {
            switch (todo) {
                case "connecter": {
                    action = new AuthentifierClientAction();
                    serialisation = new ProfilClientSerialisation();
                    break;
                }
                case "listermedium" : {
                    action = new ListerMediumAction();
                    serialisation = new ListerMediumSerialisation();
                    break;
                }
                
                case "choisir-medium" : {
                    break;
                }
                
                case "listerconsultation" : {
                    action= new ListerConsultationAction();
                    serialisation =new ListerConsultationSerialisation();
                    break;
                }
                case "listerconsultation-client" : {
                    action= new ListerConsultationClientAction();
                    serialisation =new ListerConsultationClientSerialisation();
                    break;
                }
                 case "listerconsultation-employe" : {
                    action= new ListerConsultationEmployeAction();
                    serialisation =new ListerConsultationEmployeSerialisation();
                    break;
                }
                
                case "inscription" : {
                    action = new InscrireAction();
                    serialisation = new InscrireSerialisation();
                    break;
                }
                
                case "mot-de-passe-oublie-client" : {
                    action = new ForgotClientAction();
                    serialisation = new ForgotClientSerialisation();
                    break;
                }
                
                case "mot-de-passe-oublie-employe" : {
                    action = new ForgotEmployeAction();
                    serialisation = new ForgotEmployeSerialisation();
                    break;
                }
                case "connecter-employe" : {
                    action = new AuthentifierEmployeAction();
                    serialisation = new AuthentifierEmployeSerialisation();
                    break;
                }
                
                case "finir-consultation" : {
                    break;
                }
                
                case "generer-prediction" : {
                    break;
                }
                
                case "obtenir-top-medium" : {
                    
                }
                
                case "obtenir-profil-client" : {
                    action = new ObtenirProfilClientAction();
                    serialisation = new ProfilClientSerialisation();
                    break;
                }
                
            }
        }
        if (action != null) {
            action.executer(request);
            serialisation.serialiser(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erreur dans les paramè  tres de la requête");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
