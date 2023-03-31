/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeutrinome;

/**
 *
 * @author tobia
 */
public class Plateau {

    private int longueur;
    private int largeur;
    private String[] ZoneRougeJ1;
    private String[] ZoneRougeJ2;
    private String Case[];

    public Plateau(int longueur, int largeur, String[] ZoneRougeJ1, String[] ZoneRougeJ2, String Case[]) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.ZoneRougeJ1 = ZoneRougeJ1;
        this.ZoneRougeJ2 = ZoneRougeJ2;
        this.Case = Case;
    }

    public String toString() {
        String a = "";
        String b = "";
        String c = "";

        for (int i = 0; i < ZoneRougeJ1.length; i++) {
            a = a + ZoneRougeJ1[i];
        }

        for (int i = 0; i < ZoneRougeJ2.length; i++) {
            b = b + ZoneRougeJ2[i];
        }

        for (int i = 0; i < Case.length; i++) {
            c = c + Case[i];
        }
        return "(" + this.longueur + "," + this.largeur + "," + a + "," + b + "," + c + ")";
    }

    public String[] getCase() {
        return Case;
    }

    public String[] getZoneRougeJ1() {
        return ZoneRougeJ1;
    }

    public String[] getZoneRougeJ2() {
        return ZoneRougeJ2;
    }

    public String versSauvegarde() {
        String a = "";
        String b = "";
        String c = "";
        for (int i = 0; i < ZoneRougeJ1.length; i++) {
            a = a + ZoneRougeJ1[i];
        }

        for (int i = 0; i < ZoneRougeJ2.length; i++) {
            b = b + ZoneRougeJ2[i];
        }

        for (int i = 0; i < Case.length; i++) {
            c = c + Case[i];
        }
        return longueur + System.lineSeparator() + largeur + System.lineSeparator() + a + System.lineSeparator() + b + System.lineSeparator() + c;
    }
}
