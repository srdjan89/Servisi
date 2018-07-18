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
public class Kamion {
    private int id;
    private String marka;
    private int nosivost;
    private int godiste;
    private int brPopravljanja;

    public Kamion() {
    }

    public Kamion(int id, String marka, int nosivost, int godiste, int brPopravljanja) {
        this.id = id;
        this.marka = marka;
        this.nosivost = nosivost;
        this.godiste = godiste;
        this.brPopravljanja = brPopravljanja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getNosivost() {
        return nosivost;
    }

    public void setNosivost(int nosivost) {
        this.nosivost = nosivost;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public int getBrPopravljanja() {
        return brPopravljanja;
    }

    public void setBrPopravljanja(int brPopravljanja) {
        this.brPopravljanja = brPopravljanja;
    }
    
    
}
