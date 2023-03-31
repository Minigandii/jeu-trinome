/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeutrinome;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author tobia
 */
public class JeuTrinome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        String ZoneRougeJ1[];
        ZoneRougeJ1 = new String[3];
        ZoneRougeJ1[0] = "E11";
        ZoneRougeJ1[1] = "F11";
        ZoneRougeJ1[2] = "G11";
        String ZoneRougeJ2[];
        ZoneRougeJ2 = new String[3];
        ZoneRougeJ2[0] = "E1";
        ZoneRougeJ2[1] = "F1";
        ZoneRougeJ2[2] = "G1";
        String Case[];
        String Case2;
        Case = new String[121];
        int cpt = 0;
        for (int i = 65; i < 76; i++) {
            for (int j = 65; j < 76; j++) {
                char a = (char) i;
                String c = Character.toString(a);
                char b = (char) j;
                String d = Character.toString(b);
                Case2 = (c + d);
                Case[cpt] = Case2;
                cpt++;
            }
        }
        Plateau T1 = new Plateau(23, 23, ZoneRougeJ1, ZoneRougeJ2, Case);
        //System.out.println(T1);

        String pseudo1 = "JoueurRouge";
        String pseudo2 = "JoueurVert";
        String couleur1 = "rouge";
        String couleur2 = "verte";
        Pion PionJ1[] = new Pion[15];
        Pion PionJ2[] = new Pion[15];
        Joueur J1 = new Joueur(pseudo1, couleur1, PionJ1);
        Joueur J2 = new Joueur(pseudo2, couleur2, PionJ2);
        Controle C1 = new Controle(J1, J2, T1);
        C1.NouvellePartie();
        C1.debutpartie("rouge");
        //System.out.println(C1);

//        System.out.println(J1.Recherche("A2"));
//        System.out.println(J2.Recherche("A5"));
//        System.out.println(J1.Recherche2("P2"));
//        System.out.println(J2.Recherche2("C7"));
        //System.out.println(Arrays.toString(J1.Recherche("B2").ListeDeplacement()));
        //System.out.println(Arrays.toString(J1.Recherche("G1").ListeDeplacement()));
        //System.out.println(Arrays.toString(J2.Recherche("E11").ListeDeplacement()));
//        System.out.println(Arrays.toString(C1.Contrainte(J1.Recherche("B2").ListeDeplacement())));
//        System.out.println(Arrays.toString(C1.Contrainte(J1.Recherche("G1").ListeDeplacement())));
//        Pion P1 = new Pion ("B3","vert","Test1");
//        Pion P1 = new Pion ("B3","vert","Test1");
//        Pion P1 = new Pion ("B3","vert","Test1");
//        J2.getnbPion()[0]=P1;
//        System.out.println(Arrays.toString(C1.ListeCapture(C1.Contrainte(J1.Recherche("B2").ListeDeplacement()))));
//        System.out.println(Arrays.toString(C1.ListeCapture(C1.Contrainte(J1.Recherche("G1").ListeDeplacement()))));
//        Pion P1 = new Pion (null,"vert","D1");
//        Pion P2 = new Pion (null,"vert","D2");
//        Pion P3 = new Pion (null,"vert","D3");
//        J2.getnbPion()[12]=P1;
//        J2.getnbPion()[13]=P2;
//        J2.getnbPion()[14]=P3;
//        
//        C1.FindePartie();
        Pion P1 = new Pion("JA", "vert", "D1");
        Pion P2 = new Pion("BF", "rouge", "C1");
        J1.getnbPion()[0] = P2;
        J2.getnbPion()[0] = P1;
        System.out.println(J1);
        System.out.println(J2);
        J1.Recherche("BF").Capture(J2.getnbPion()[0]);
        System.out.println("Test capture");
        System.out.println(J1);
        System.out.println(Arrays.toString(C1.Contrainte(C1.getJ1().Recherche("JB").ListeDeplacement())));

        C1.Sauvegarde();
        C1.Chargement();
    }
}
