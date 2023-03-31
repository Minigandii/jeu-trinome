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
public class Pion {

    private String placement;
    private String couleur;
    private String designation;

    public Pion(String placement, String couleur, String designation) {
        this.placement = placement;
        this.couleur = couleur;
        this.designation = designation;
    }

    public String toString() {
        return this.placement + System.lineSeparator() + this.couleur + System.lineSeparator() + this.designation;
    }

    public String[] ListeDeplacement() {
        return null;
    }

    public void Deplacement(String a) {
        this.placement = a;
    }

    public void Capture(Pion P) {
        this.placement = P.placement;
        P.placement = "";
    }

    public String getPlacement() {
        return placement;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getDesignation() {
        return designation;
    }
}
