/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resursi;

import db.DB;
import entiteti.Firma;
import entiteti.Kamion;
import java.sql.*;
import java.util.*;
import javax.ws.rs.*;

/**
 *
 * @author Срђан
 */
@Path("firme")
public class FirmeServis {

    @GET
    public List<Firma> dohvatiFirme() throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM firma");
        List<Firma> firme = new ArrayList<>();
        while (rs.next()) {
            int idFir = rs.getInt("IDFir");
            String naziv = rs.getString("Naziv");
            String adresa = rs.getString("Adresa");
            String tel1 = rs.getString("Tel1");
            String tel2 = rs.getString("Tel2");
            Firma firma = new Firma(idFir, naziv, adresa, tel1, tel2);
            firme.add(firma);

        }
        return firme;
    }

    @POST
    public void kreirajFirmu(Firma firma) throws SQLException {

        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO firma (IDFir, Naziv, Adresa, Tel1, Tel2) VALUES (?, ?, ?, ?, ?);");

        ps.setInt(1, firma.getIdFir());
        ps.setString(2, firma.getNaziv());
        ps.setString(3, firma.getAdresa());
        ps.setString(4, firma.getTel1());
        ps.setString(5, firma.getTel2());

        ps.executeUpdate();

    }

}
