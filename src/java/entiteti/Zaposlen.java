/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korisnik
 */

@XmlRootElement
public class Zaposlen {
    private int id;
    private String ime;
    private int staz;

    public Zaposlen(){
        
    }
    public Zaposlen(int id, String ime, int staz) {
        this.id = id;
        this.ime = ime;
        this.staz = staz;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

}
