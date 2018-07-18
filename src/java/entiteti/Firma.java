/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Срђан
 */
@XmlRootElement
public class Firma {

    private int idFir;
    private String naziv;
    private String adresa;
    private String tel1;
    private String tel2;

    public Firma() {
    }

    public Firma(int idFir, String naziv, String adresa, String tel1, String tel2) {
        this.idFir = idFir;
        this.naziv = naziv;
        this.adresa = adresa;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public int getIdFir() {
        return idFir;
    }

    public void setIdFir(int idFir) {
        this.idFir = idFir;
    }

}
