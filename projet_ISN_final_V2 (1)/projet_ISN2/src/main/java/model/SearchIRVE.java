package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import dao.IRVEDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/SearchIRVE")
public class SearchIRVE extends HttpServlet {
    // Déclaration de l'objet IRVEDao pour l'accès aux données des stations de recharge
    private IRVEDao irveDao = new IRVEDao();

    // Méthode HTTP GET pour traiter les requêtes de recherche de stations de recharge
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        // Récupération du paramètre "codePostal" de la requête
        String codePostal = request.getParameter("codePostal");
        // Appel à la méthode chercherParCodePostal de IRVEDao pour obtenir la liste des stations de recharge
        List<IRVE> irvesList = irveDao.chercherParCodePostal(codePostal);

        // Conversion de la liste des stations de recharge en format JSON à l'aide de la bibliothèque Gson
        Gson gson = new Gson();
        String json = gson.toJson(irvesList);

        // Spécification du type de contenu de la réponse comme JSON
        response.setContentType("application/json");
        // Obtention du flux d'écriture pour la réponse
        PrintWriter out = response.getWriter();
        // Écriture de la réponse JSON dans le flux
        out.println(json);
    }
}
