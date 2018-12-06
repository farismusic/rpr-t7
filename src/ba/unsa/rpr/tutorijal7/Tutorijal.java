package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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
        }
        ulaz.close();
        return gradovi;
    }


    public static void ucitajXml(){
        UN xml = new UN();
        Drzava drzava = new Drzava();
        ArrayList<Drzava> drzave = new ArrayList<Drzava>();

        Document xmldoc = null;
        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("C:\\Users\\Dell\\IdeaProjects\\rpr-t7\\src\\ba\\unsa\\rpr\\tutorijal7\\drzave.xml"));

            Element korijen = xmldoc.getDocumentElement();
            NodeList djeca = korijen.getChildNodes();
            if(djeca.getLength() == 1){
                System.out.println("Ispisi: " +  korijen.getTextContent());
            }

            System.out.println("Ispisi: ");

        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }

        //return xml;
    }

    public static void main(String[] args) {
        /*ArrayList<Grad> gradovi = ucitajGradove();
        for(Grad g : gradovi){
            System.out.println("Grad: " + g.getNaziv());
            System.out.println("Temperature: ");
            for(double temp : g.getTemperature()){
                if(temp == 0) continue;
                System.out.print(temp + " | ");
            }
            System.out.println();
        }*/

        ucitajXml();
    }
}
