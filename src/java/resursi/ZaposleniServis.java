/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resursi;

import db.DB;
import entiteti.Kamion;
import entiteti.Zaposlen;
import java.sql.*;
import java.util.*;
import javax.ws.rs.*;

/**
 *
 * @author Korisnik
 */
@Path("zaposleni")
public class ZaposleniServis {

    @PUT
    @Path("{idZap}")
    public void izmeniZaposlenog(@PathParam("idZap") int idZap) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        String upit = "update zaposlen set staz=staz+1  where idZap = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(upit);
        prepareStatement.setInt(1, idZap);
        prepareStatement.executeUpdate();
    }

    @PUT
    public void izmeniZaposlenog() throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        String upit = "update zaposlen set staz=staz+1";
        PreparedStatement prepareStatement = connection.prepareStatement(upit);
        prepareStatement.executeUpdate();
    }

    @GET
    public List<Zaposlen> dohvatiZaposlene(@QueryParam("ime") String ime,
            @QueryParam("vozac") boolean vozac, @QueryParam("mehanicar") boolean mehanicar) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        String upit;
        if (mehanicar && vozac) {
            upit = "select * from zaposlen where imePrezime like ?";
        } else if (mehanicar) {
            upit = "select * from zaposlen z, mehanicar m where z.idZap=m.idZap AND "
                    + "imePrezime like ?";
        } else if (vozac) {
            upit = "select * from zaposlen z, vozac v where z.idZap=v.idZap AND "
                    + "imePrezime like ?";
        } else {
            return new ArrayList<Zaposlen>();
        }
        PreparedStatement preparedStatement = connection.prepareStatement(upit);
        preparedStatement.setString(1, "%" + ime + "%");
        ResultSet rs = preparedStatement.executeQuery();
        List<Zaposlen> zaposleni = new ArrayList<>();
        while (rs.next()) {
            zaposleni.add(new Zaposlen(rs.getInt("IDZap"), rs.getString("ImePrezime"), rs.getInt("Staz")));
        }
        return zaposleni;
    }

    @POST
    @Path("promeni")
    @Consumes("application/x-www-form-urlencoded")
    public String izmeniZaposlenog(@FormParam("ime") String ime,
            @FormParam("id") int id, @FormParam("staz") int staz) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        String upit = "UPDATE Zaposlen set imePrezime=?,  staz=? where idZap=?";
        PreparedStatement preparedStatement = connection.prepareStatement(upit);
        preparedStatement.setInt(2, staz);
        preparedStatement.setInt(3, id);
        preparedStatement.setString(1, ime);
        int b = preparedStatement.executeUpdate();
        if (b > 0) {
            return "Uspesno izmenjen!";
        } else {
            return "Greska!";
        }
    }

}
