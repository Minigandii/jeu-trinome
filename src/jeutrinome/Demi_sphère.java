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
public class Demi_sphère extends Pion {

    //private String nom;
    private String listedeplacement[];

    public Demi_sphère(String placement, String couleur, String designation) {
        super(placement, couleur, designation);
    }

    public String[] ListeDeplacement() {
        //indique tous les déplacements possibles d'une demi-sphère
        char placementlettre;
        char placementlettre2;
        placementlettre = this.getPlacement().charAt(0);
        placementlettre2 = this.getPlacement().charAt(1);
        String nvplacement;
        listedeplacement = new String[9];
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                placementlettre2 += 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[0] = nvplacement;
                placementlettre2 -= 2;
            }
            if (i == 1) {
                placementlettre2 -= 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[1] = nvplacement;
                placementlettre2 += 2;
            }
            if (i == 2) {
                placementlettre += 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[2] = nvplacement;
                placementlettre -= 2;
            }
            if (i == 3) {
                placementlettre -= 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[3] = nvplacement;
                placementlettre += 2;
            }
            if (i == 4) {
                placementlettre2 += 2;
                placementlettre += 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[4] = nvplacement;
                placementlettre2 -= 2;
                placementlettre -= 2;
            }
            if (i == 5) {
                placementlettre2 -= 2;
                placementlettre += 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[5] = nvplacement;
                placementlettre2 += 2;
                placementlettre -= 2;
            }
            if (i == 6) {
                placementlettre2 += 2;
                placementlettre -= 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[6] = nvplacement;
                placementlettre += 2;
                placementlettre2 -= 2;
            }
            if (i == 7) {
                placementlettre2 -= 2;
                placementlettre -= 2;
                String nvplacementlettre = Character.toString(placementlettre);
                String nvplacementlettre2 = Character.toString(placementlettre2);
                nvplacement = (nvplacementlettre + nvplacementlettre2);
                listedeplacement[7] = nvplacement;
                placementlettre2 += 2;
                placementlettre += 2;
            }
        }

        if (this.getCouleur().equals("rouge")) {
            listedeplacement[8] = "rouge";
        }
        if (this.getCouleur().equals("verte")) {
            listedeplacement[8] = "verte";
        }

        return listedeplacement;
    }
}
