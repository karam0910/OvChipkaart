package Javaovchipkaart;

import java.sql.Date;

public class Reiziger {

    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;

    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Date geboortedatum){this.geboortedatum = geboortedatum;}

    public int getId(){return this.id;}

    public void setId(int id){this.id = id;}

    public String getNaam() {
        if (tussenvoegsel == null)
            tussenvoegsel= "";
        return voorletters + " " + tussenvoegsel + " " + achternaam;
    }

    public String toString(){return("#" + id + ":" + " " + this.getNaam()+
            " " + "(" + geboortedatum + ")");

    } }