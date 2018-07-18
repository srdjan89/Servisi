/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resursi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Korisnik
 */
@Path(value = "test")
public class Test {
    
    @GET
    @Produces(value = MediaType.TEXT_PLAIN)
    public String testPoruka(){
        return "Test";
    }
}
