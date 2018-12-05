package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;

public class Grad implements Serializable {
    private String naziv = "";
    private int brojStanovnika;
    private double[] temperature = new double[1000];

    public Grad(){

    }

    public Grad(String naziv, Double[] temps){
        this.naziv = naziv;
        for(int i = 0; i < temps.length; i++){
            temperature[i] = temps[i];
        }
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }
}
