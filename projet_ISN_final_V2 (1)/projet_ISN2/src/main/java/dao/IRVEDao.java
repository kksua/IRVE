package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.IRVE;

public class IRVEDao {
    // Définition des informations de connexion à la base de données
    private static final String url = "jdbc:mysql://localhost:3306/irve";
    private static final String user = "root";
    private static final String password = "root";

    // Chargement du pilote JDBC lors du chargement de la classe
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour rechercher les stations de recharge par code postal
    public List<IRVE> chercherParCodePostal(String codePostal) {
        // Initialisation de la liste des stations de recharge
        List<IRVE> irvesList = new ArrayList<>();
        // Requête SQL pour récupérer les stations de recharge correspondant au code postal donné
        String sql = "SELECT * FROM table_complete WHERE adresse_station LIKE ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Remplissage du paramètre de la requête avec le code postal recherché
            stmt.setString(1, "%" + codePostal + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                // Parcours des résultats de la requête
                while (rs.next()) {
                    // Récupération des informations de chaque station de recharge
                    String nomEnseigne = rs.getString("nom_enseigne");
                    String adresse = rs.getString("adresse_station");
                    String coordonneesString = rs.getString("coordonneesXY");
                    float puissanceNominal = rs.getFloat("puissance_nominale");
                    boolean priseTypeEf = rs.getBoolean("prise_type_ef");
                    boolean priseType2 = rs.getBoolean("prise_type_2");
                    boolean priseTypeComboCCs = rs.getBoolean("prise_type_combo_ccs");
                    boolean priseTypeChademo = rs.getBoolean("prise_type_chademo");
                    boolean priseTypeAutre = rs.getBoolean("prise_type_autre");

                    // Traitement des coordonnées géographiques
                    coordonneesString = coordonneesString.replaceAll("[\\[\\]]", "");
                    String[] coordonneesArray = coordonneesString.split(",");
                    double lat = Double.parseDouble(coordonneesArray[1].trim());
                    double lng = Double.parseDouble(coordonneesArray[0].trim());

                    // Création d'un objet IRVE avec les informations récupérées
                    IRVE irve = new IRVE(lat, lng, nomEnseigne, adresse, coordonneesString, puissanceNominal, priseTypeEf, priseType2, priseTypeComboCCs, priseTypeChademo, priseTypeAutre);
                    // Ajout de la station à la liste
                    irvesList.add(irve);
                }
            }
        } catch (SQLException e) {
            // Gestion des exceptions SQL
            e.printStackTrace();
        }
        // Retour de la liste des stations de recharge
        return irvesList;
    }
}
