/*
 * Project: Waschanlage
 * Klasse: 1aAPC / 2024
 * Author:  Lea Wieser
 * Last Change:
 *    by:   wieserl
 *    date: 01.02.2024
 * Copyright (c): LBS Eibiswald, 2024
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Auto{
    private String kennzeichen;
    public Auto(String kennzeichen){
        this.kennzeichen = kennzeichen;
    }
    public String getKennzeichen(){
        return kennzeichen;
    }
}

class Warteschlange{
    private List<Auto> autos;
    public Warteschlange(){
        autos = new ArrayList<>();
    }
    public void autoHinzufuegen(Auto auto){
        if (autos.size() < 10){
            autos.add(auto);
            System.out.println("Auto mit Kennzeichen "+auto.getKennzeichen()+" wurde hinzugefügt");
        } else {
            System.out.println("Die Warteschlange ist voll!");
        }
    }
    public void autoWaschen(){
        if (!autos.isEmpty()){
            Auto erstesAuto = autos.remove(0);
            System.out.println("Auto mit Kennzeichen "+erstesAuto.getKennzeichen()+" fährt in die Waschanlage ein");
            autosAufruecken();
        } else {
            System.out.println("Die Warteschlange ist leer");
        }
    }
    public void autosAufruecken(){
        for (int i = 0; i < autos.size(); i++){
            System.out.println("Auto mit Kennzeichen "+autos.get(i).getKennzeichen()+" rückt einen Platz weiter");
        }
    }
    public void statusWarteschlange(){
        if (!autos.isEmpty()){
            System.out.println("Warteschlange: ");
            for (Auto auto : autos){
                System.out.println(auto.getKennzeichen());
            }
        }else {
            System.out.println("Die Warteschlange ist leer");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Warteschlange warteschlange = new Warteschlange();

        int auswahl;
        do{
            System.out.println("\nWaschlage Steuerung: ");
            System.out.println("1. Auto fährt in die Warteschlange");
            System.out.println("2. Warteschlange anzeigen");
            System.out.println("3. Auto waschen");
            System.out.println("4. Programm beenden");
            System.out.println("Wählen sie die gewollte Option: ");
            auswahl = scanner.nextInt();

            switch (auswahl){
                case 1:
                    System.out.print("Gib das Kennzeichen ein: ");
                    String kennzeichen = scanner.next();
                    Auto neuesAuto = new Auto(kennzeichen);
                    warteschlange.autoHinzufuegen(neuesAuto);

                    break;
                case 2:
                    warteschlange.statusWarteschlange();
                    break;
                case 3:
                    warteschlange.autoWaschen();
                case 4:
                    System.out.println("Programm wird beendet");
                    break;
                default:
                    System.out.println("Ungültige Auswahl, gebe eine Zahl zwischen 1-3 an");
            }
        }while (auswahl !=4);
    }
}