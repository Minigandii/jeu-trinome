/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeutrinome;

import java.io.IOException;

/**
 *
 * @author tobia
 */
public class Joueur {

    private String pseudo;
    private String couleur;
    private Pion nbPion[];

    public Joueur(String pseudo, String couleur, Pion nbPion[]) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        this.nbPion = nbPion;
    }

    public String toString() {
        String a = "";
        for (int i = 0; i < nbPion.length; i++) {
            a = a + nbPion[i];
        }
        return "(" + this.pseudo + "," + this.couleur + "," + a + ")";
    }

    public Pion Recherche(String a) throws NullPointerException {
        for (int i = 0; i < nbPion.length; i++) {
            if (a.equals(nbPion[i].getPlacement())) {
                return nbPion[i];
            }
        }
        return null;
    }

    public Pion Recherche2(String a) {
        for (int i = 0; i < nbPion.length; i++) {
            if (a.equals(nbPion[i].getDesignation())) {
                return nbPion[i];
            }
        }
        return null;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Pion[] getnbPion() {
        return nbPion;
    }

    public String getCouleur() {
        return couleur;
    }

    public String versSauvegarde() {
        String a = "";
        for (int i = 0; i < nbPion.length; i++) {
            a = a + nbPion[i] + System.lineSeparator();
        }
        return pseudo + System.lineSeparator() + couleur + System.lineSeparator() + a;
    }
}
