/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeutrinome;

import java.util.Arrays;

/**
 *
 * @author tobia
 */
public class Cube extends Pion {

    //private String nom;
    private String listedeplacement[];
    //private String nouveauplacement;
    //private char placementlettre;
    //private char placementchiffre;

    public Cube(String placement, String couleur, String designation) {
        super(placement, couleur, designation);
    }

    public String[] ListeDeplacement() {
        //indique tous les déplacements possibles d'un cube
        char placementlettre = this.getPlacement().charAt(0);
        char placementlettre2 = this.getPlacement().charAt(1);
        String nvplacement;
        listedeplacement = new String[5];
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                placementlettre2 += 1;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[0] = nvplacement;
                placementlettre2 -= 1;
            }
            if (i == 1) {
                placementlettre2 -= 1;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[1] = nvplacement;
                placementlettre2 += 1;
            }
            if (i == 2) {
                placementlettre += 1;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[2] = nvplacement;
                placementlettre -= 1;
            }
            if (i == 3) {
                placementlettre -= 1;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[3] = nvplacement;
                placementlettre += 1;
            }
        }

        if (this.getCouleur().equals("rouge")) {
            listedeplacement[4] = "rouge";
        }
        if (this.getCouleur().equals("verte")) {
            listedeplacement[4] = "verte";
        }

        return listedeplacement;
    }
}
