/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resursi;

import db.DB;
import entiteti.Kamion;
import java.sql.*;
import java.util.*;
import javax.ws.rs.*;

/**
 *
 * @author Korisnik
 */
@Path("kamioni")
public class KamionServis {

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void dohvatiKamion(@FormParam("marka2") String marka) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        String upit = "SELECT * FROM Kamion where marka=\"?\"";
        PreparedStatement preparedStatement = connection.prepareStatement(upit);
        preparedStatement.setString(1, marka);
        preparedStatement.executeUpdate();

    }

    @GET
    public List<Kamion> dohvatiSveKamione() {
        try {
            Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Kamion");
            List<Kamion> kamioni = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("IDKam");
                String marka = rs.getString("Marka");
                int nosivost = rs.getInt("Nosivost");
                int godiste = rs.getInt("Godiste");
                int brPopravljanja = rs.getInt("BrPopravljanja");

                Kamion kamion = new Kamion(id, marka, nosivost, godiste, brPopravljanja);

                kamioni.add(kamion);
            }

            return kamioni;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @POST
    public void kreirajKamion(Kamion kamion) {
        try {
            Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
            PreparedStatement ps = connection.prepareStatement("insert into kamion values(?,?,?,?,?)");

            ps.setInt(1, kamion.getId());
            ps.setString(2, kamion.getMarka());
            ps.setInt(3, kamion.getNosivost());
            ps.setInt(4, kamion.getGodiste());
            ps.setInt(5, kamion.getBrPopravljanja());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @DELETE
    @Path("{idKam}")
    public void obrisiKamion(@PathParam("idKam") int idKam) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        PreparedStatement prepareStatement = connection.prepareStatement("delete from kamion where idkam = ?");
        prepareStatement.setInt(1, idKam);
        prepareStatement.executeUpdate();
    }

    @PUT
    @Path("{idKam}")
    public void izmeniKamion(@PathParam("idKam") int idKam, Kamion kamion) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
        String upit = "update kamion set marka = ? , nosivost = ?, godiste = ?, brPopravljanja = ? where idkam = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(upit);
        prepareStatement.setString(1, kamion.getMarka());
        prepareStatement.setInt(2, kamion.getNosivost());
        prepareStatement.setInt(3, kamion.getGodiste());
        prepareStatement.setInt(4, kamion.getBrPopravljanja());
        prepareStatement.setInt(5, idKam);

        prepareStatement.executeUpdate();
    }

    @GET
    @Path("godiste")
    public List<Kamion> dohvatiKamionePoGodistu(@QueryParam("godisteMin") int godisteMin, @QueryParam("godisteMax") int godisteMax) {
        try {
            Connection connection = DriverManager.getConnection(DB.connectionString, DB.user, DB.pass);
            Statement statement = connection.createStatement();
            String upit = "SELECT * FROM Kamion where godiste >= " + godisteMin + " AND godiste <= " + godisteMax;
            ResultSet rs = statement.executeQuery(upit);
            List<Kamion> kamioni = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("IDKam");
                String marka = rs.getString("Marka");
                int nosivost = rs.getInt("Nosivost");
                int godiste = rs.getInt("godiste");
                int brPopravljanja = rs.getInt("brPopravljanja");

                Kamion kamion = new Kamion(id, marka, nosivost, godiste, brPopravljanja);

                kamioni.add(kamion);
            }

            return kamioni;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
