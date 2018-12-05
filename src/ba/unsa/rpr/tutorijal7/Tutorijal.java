package ba.unsa.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tutorijal {

    public static ArrayList<Grad> ucitajGradove(){
        Scanner ulaz = null;
        ArrayList<Grad> gradovi = new ArrayList<Grad>();
        try{
            ulaz = new Scanner(new FileReader("C:\\Users\\Dell\\IdeaProjects\\rpr-t7\\src\\ba\\unsa\\rpr\\tutorijal7\\mjerenja.txt"));
            String imeGrada = "";

            ulaz.useDelimiter("\n");

            while(ulaz.hasNext()){
                ArrayList<Double> temps = new ArrayList<Double>();
                String gradPodaci = ulaz.next();
                String[] podaci = gradPodaci.split(",");
                imeGrada = podaci[0];
                for(int i = 1; i < podaci.length; i++){
                    temps.add(Double.parseDouble(podaci[i]));
                }
                gradovi.add(new Grad(imeGrada, temps.toArray(new Double[0])));
            }

        }catch(FileNotFoundException e){
            System.out.println("Datoteka ne postoji ili se ne moze otvoriti" + e);
        }finally {
            ulaz.close();
        }
        return gradovi;
    }

    public static void main(String[] args) {
        ArrayList<Grad> gradovi = ucitajGradove();
        for(Grad g : gradovi){
            System.out.println("Grad: " + g.getNaziv());
            System.out.println("Temperature: ");
            for(double temp : g.getTemperature()){
                if(temp == 0) continue;
                System.out.print(temp + " | ");
            }
            System.out.println();
        }
    }
}
