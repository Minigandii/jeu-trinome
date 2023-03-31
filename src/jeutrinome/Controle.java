/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeutrinome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author cleme
 */
public class Controle {

    private Joueur J1;
    private Joueur J2;
    private Plateau P1;
    String ZoneRougeJ1[];
    String ZoneRougeJ2[];

    // Constructeur
    public Controle(Joueur J1, Joueur J2, Plateau P1) {
        this.J1 = J1;
        this.J2 = J2;
        this.P1 = P1;
    }

    public String toString() {
        return "(" + this.J1 + System.lineSeparator() + this.J2 + System.lineSeparator() + this.P1 + ")";
    }

    public void NouvellePartie() throws IOException {
        //permet de lancer une nouvelle partie avec le fichier texte sauvegarde qui se réinitialise
        File file = new File("sauvegarde.txt");
        file.delete();
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void Sauvegarde() throws IOException {
        //permet de sauvegarder une partie en cours à l'aide d'un fichier texte
        FileWriter writer = new FileWriter("sauvegarde.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        if (J1 != null) {
            String info = J1.versSauvegarde(); //appelle la méthode versSauvegarde de la classe Joueur
            writer.write(info + System.lineSeparator()); //écrit les informations du joueur 1
        }
        if (J2 != null) {
            String info = J2.versSauvegarde(); //appelle la méthode versSauvegarde de la classe Joueur
            writer.write(info + System.lineSeparator()); //écrit les informations du joueur 2
        }
        if (P1 != null) {
            String info = P1.versSauvegarde(); //appelle la méthode versSauvegarde de la classe Plateau
            writer.write(info + System.lineSeparator()); //écrit les informations du plateau
        }
        writer.close();
    }

    public Controle Chargement() throws FileNotFoundException, IOException {
        //permet de lire les informations du fichier texte sauvegarde et de s'en servir pour reprendre la partie sauvegardée
        FileReader reader = new FileReader("sauvegarde.txt");
        BufferedReader br = new BufferedReader(reader);

        String Pseudo1 = br.readLine();
        String couleur1 = br.readLine();
        Pion nbPion1[] = new Pion[15];
        for (int i = 0; i < 15; i++) {
            String position = String.valueOf(br.readLine());
            String couleur = String.valueOf(br.readLine());
            String designiation = String.valueOf(br.readLine());
            nbPion1[i] = new Pion(position, couleur, designiation);
        }

        String poubelle = br.readLine();
        String Pseudo2 = br.readLine();
        String couleur2 = br.readLine();
        Pion nbPion2[] = new Pion[15];
        for (int i = 0; i < 15; i++) {
            String position = String.valueOf(br.readLine());
            String couleur = String.valueOf(br.readLine());
            String designiation = String.valueOf(br.readLine());
            nbPion2[i] = new Pion(position, couleur, designiation);
        }
        String poubelle2 = br.readLine();
        String lon = br.readLine();
        int longueur = Integer.parseInt(lon);
        String lar = br.readLine();
        int largueur = Integer.parseInt(lar);
        String ZRJ1 = br.readLine();
        String premier = ZRJ1.substring(0, 2);
        String deuxieme = ZRJ1.substring(2, 4);
        String troisieme = ZRJ1.substring(4, 6);
        String ZoneRougeJ1[] = new String[3];
        ZoneRougeJ1[0] = premier;
        ZoneRougeJ1[1] = deuxieme;
        ZoneRougeJ1[2] = troisieme;
        String ZRJ2 = br.readLine();
        String premierbis = ZRJ2.substring(0, 2);
        String deuxiemebis = ZRJ2.substring(2, 4);
        String troisiemebis = ZRJ2.substring(4, 6);
        String ZoneRougeJ2[] = new String[3];
        ZoneRougeJ2[0] = premierbis;
        ZoneRougeJ2[1] = deuxiemebis;
        ZoneRougeJ2[2] = troisiemebis;
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
        Joueur J1 = new Joueur(Pseudo1, couleur1, nbPion1);
        Joueur J2 = new Joueur(Pseudo2, couleur2, nbPion2);
        Plateau T1 = new Plateau(23, 23, ZoneRougeJ1, ZoneRougeJ2, Case);
        Controle C1 = new Controle(J1, J2, T1);
        reader.close();
        return (C1);
    }

    public void debutpartie(String couleur) {
        //initialise le plateau avec tous les pions de chaque joueur

        if (couleur == "verte") {
            Pyramide P1 = new Pyramide("JA", "verte", "P1");
            Pyramide P2 = new Pyramide("KA", "verte", "P2");
            Pyramide P3 = new Pyramide("KB", "verte", "P3");
            Pyramide P4 = new Pyramide("JK", "verte", "P4");
            Pyramide P5 = new Pyramide("KJ", "verte", "P5");
            Pyramide P6 = new Pyramide("KK", "verte", "P5");
            Cube C1 = new Cube("IA", "verte", "C1");
            Cube C2 = new Cube("JB", "verte", "C2");
            Cube C3 = new Cube("KC", "verte", "C3");
            Cube C4 = new Cube("IK", "verte", "C4");
            Cube C5 = new Cube("JJ", "verte", "C5");
            Cube C6 = new Cube("KI", "verte", "C6");
            Demi_sphère D1 = new Demi_sphère("KE", "verte", "D1");
            Demi_sphère D2 = new Demi_sphère("KF", "verte", "D2");
            Demi_sphère D3 = new Demi_sphère("KG", "verte", "D3");

            Pyramide P7 = new Pyramide("AA", "rouge", "P7");
            Pyramide P8 = new Pyramide("AB", "rouge", "P8");
            Pyramide P9 = new Pyramide("BA", "rouge", "P9");
            Pyramide P10 = new Pyramide("AJ", "rouge", "P10");
            Pyramide P11 = new Pyramide("AK", "rouge", "P11");
            Pyramide P12 = new Pyramide("BK", "rouge", "P12");
            Cube C7 = new Cube("AC", "rouge", "C7");
            Cube C8 = new Cube("BB", "rouge", "C8");
            Cube C9 = new Cube("CA", "rouge", "C9");
            Cube C10 = new Cube("AI", "rouge", "C10");
            Cube C11 = new Cube("BJ", "rouge", "C11");
            Cube C12 = new Cube("CK", "rouge", "C12");
            Demi_sphère D4 = new Demi_sphère("AE", "rouge", "D4");
            Demi_sphère D5 = new Demi_sphère("AF", "rouge", "D5");
            Demi_sphère D6 = new Demi_sphère("AG", "rouge", "D6");
            J1.getnbPion()[0] = P1;
            J1.getnbPion()[1] = P2;
            J1.getnbPion()[2] = P3;
            J1.getnbPion()[3] = P4;
            J1.getnbPion()[4] = P5;
            J1.getnbPion()[5] = P6;
            J1.getnbPion()[6] = C1;
            J1.getnbPion()[7] = C2;
            J1.getnbPion()[8] = C3;
            J1.getnbPion()[9] = C4;
            J1.getnbPion()[10] = C5;
            J1.getnbPion()[11] = C6;
            J1.getnbPion()[12] = D1;
            J1.getnbPion()[13] = D2;
            J1.getnbPion()[14] = D3;

            J2.getnbPion()[0] = P7;
            J2.getnbPion()[1] = P8;
            J2.getnbPion()[2] = P9;
            J2.getnbPion()[3] = P10;
            J2.getnbPion()[4] = P11;
            J2.getnbPion()[5] = P12;
            J2.getnbPion()[6] = C7;
            J2.getnbPion()[7] = C8;
            J2.getnbPion()[8] = C9;
            J2.getnbPion()[9] = C10;
            J2.getnbPion()[10] = C11;
            J2.getnbPion()[11] = C12;
            J2.getnbPion()[12] = D4;
            J2.getnbPion()[13] = D5;
            J2.getnbPion()[14] = D6;

            String ZoneRougeJ1[];
            ZoneRougeJ1 = new String[3];
            ZoneRougeJ1[0] = "KE";
            ZoneRougeJ1[1] = "KF";
            ZoneRougeJ1[2] = "KG";
            String ZoneRougeJ2[];
            ZoneRougeJ2 = new String[3];
            ZoneRougeJ2[0] = "AE";
            ZoneRougeJ2[1] = "AF";
            ZoneRougeJ2[2] = "AG";
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
        } else {
            Pyramide P1 = new Pyramide("AA", "verte", "P1");
            Pyramide P2 = new Pyramide("AB", "verte", "P2");
            Pyramide P3 = new Pyramide("BA", "verte", "P3");
            Pyramide P4 = new Pyramide("AJ", "verte", "P4");
            Pyramide P5 = new Pyramide("AK", "verte", "P5");
            Pyramide P6 = new Pyramide("BK", "verte", "P5");
            Cube C1 = new Cube("AC", "verte", "C1");
            Cube C2 = new Cube("BB", "verte", "C2");
            Cube C3 = new Cube("CA", "verte", "C3");
            Cube C4 = new Cube("AI", "verte", "C4");
            Cube C5 = new Cube("BJ", "verte", "C5");
            Cube C6 = new Cube("CK", "verte", "C6");
            Demi_sphère D1 = new Demi_sphère("AE", "verte", "D1");
            Demi_sphère D2 = new Demi_sphère("AF", "verte", "D2");
            Demi_sphère D3 = new Demi_sphère("AG", "verte", "D3");

            Pyramide P7 = new Pyramide("JA", "rouge", "P7");
            Pyramide P8 = new Pyramide("KA", "rouge", "P8");
            Pyramide P9 = new Pyramide("KB", "rouge", "P9");
            Pyramide P10 = new Pyramide("JK", "rouge", "P10");
            Pyramide P11 = new Pyramide("KJ", "rouge", "P11");
            Pyramide P12 = new Pyramide("KK", "rouge", "P12");
            Cube C7 = new Cube("IA", "rouge", "C7");
            Cube C8 = new Cube("JB", "rouge", "C8");
            Cube C9 = new Cube("KC", "rouge", "C9");
            Cube C10 = new Cube("IK", "rouge", "C10");
            Cube C11 = new Cube("JJ", "rouge", "C11");
            Cube C12 = new Cube("KI", "rouge", "C12");
            Demi_sphère D4 = new Demi_sphère("KE", "rouge", "D4");
            Demi_sphère D5 = new Demi_sphère("KF", "rouge", "D5");
            Demi_sphère D6 = new Demi_sphère("KG", "rouge", "D6");
            J2.getnbPion()[0] = P1;
            J2.getnbPion()[1] = P2;
            J2.getnbPion()[2] = P3;
            J2.getnbPion()[3] = P4;
            J2.getnbPion()[4] = P5;
            J2.getnbPion()[5] = P6;
            J2.getnbPion()[6] = C1;
            J2.getnbPion()[7] = C2;
            J2.getnbPion()[8] = C3;
            J2.getnbPion()[9] = C4;
            J2.getnbPion()[10] = C5;
            J2.getnbPion()[11] = C6;
            J2.getnbPion()[12] = D1;
            J2.getnbPion()[13] = D2;
            J2.getnbPion()[14] = D3;

            J1.getnbPion()[0] = P7;
            J1.getnbPion()[1] = P8;
            J1.getnbPion()[2] = P9;
            J1.getnbPion()[3] = P10;
            J1.getnbPion()[4] = P11;
            J1.getnbPion()[5] = P12;
            J1.getnbPion()[6] = C7;
            J1.getnbPion()[7] = C8;
            J1.getnbPion()[8] = C9;
            J1.getnbPion()[9] = C10;
            J1.getnbPion()[10] = C11;
            J1.getnbPion()[11] = C12;
            J1.getnbPion()[12] = D4;
            J1.getnbPion()[13] = D5;
            J1.getnbPion()[14] = D6;

            String ZoneRougeJ2[];
            ZoneRougeJ2 = new String[3];
            ZoneRougeJ2[0] = "KE";
            ZoneRougeJ2[1] = "KF";
            ZoneRougeJ2[2] = "KG";
            String ZoneRougeJ1[];
            ZoneRougeJ1 = new String[3];
            ZoneRougeJ1[0] = "AE";
            ZoneRougeJ1[1] = "AF";
            ZoneRougeJ1[2] = "AG";
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
        }
    }

    public String[] Contrainte(String b[]) {
        //En argument est récuperé la liste des déplacement possible produite à l'aide de la fonction ListeDeplacement
        //Situter dans la classe Pion et ses sous classe.
        //Elle vérifie si dans la liste des déplacements possibles est positionné un pion de la même couleur.
        //Et annule cette possibilité de déplacement si c'est le cas.
        if (b.equals(null)) {
            return null;
        }
        if (b[b.length - 1].equals(J1.getCouleur())) {
            //Application pour J1
            int j = 0;
            while (j < b.length - 1) {
                for (int k = 0; k < J1.getnbPion().length; k++) {
                    if (b.length == 5) {
                        //Application pour les pyramides et les cubes
                        if (b[j].equals(J1.getnbPion()[k].getPlacement())) {
                            b[j] = null;
                            j++;
                            break;
                        } else if ((k == J1.getnbPion().length - 1 && b[j] != J1.getnbPion()[k].getPlacement())) {
                            j++;
                        }
                    } else {
                        //Application pour les Demi_Sphères
                        //Comme elles ne peuvent pas capturer, on annule les déplacements sur des pions adverses
                        if (b[j].equals(J1.getnbPion()[k].getPlacement()) || b[j].equals(J2.getnbPion()[k].getPlacement())) {
                            b[j] = null;
                            j++;
                            break;
                        } else if ((k == J1.getnbPion().length - 1 && b[j] != J1.getnbPion()[k].getPlacement())) {
                            j++;
                        }
                    }
                }
            }
        } else {
            //Application pour J2
            int j = 0;
            while (j < b.length - 1) {
                for (int k = 0; k < J2.getnbPion().length; k++) {
                    if (b.length == 5) {
                        //Application pour les pyramides et les cubes
                        if (b[j].equals(J2.getnbPion()[k].getPlacement())) {
                            b[j] = null;
                            j++;
                            break;
                        } else if ((k == J2.getnbPion().length - 1 && b[j] != J2.getnbPion()[k].getPlacement())) {
                            j++;
                        }
                    } else {
                        //Application pour les Demi_Sphères
                        //Comme elles ne peuvent pas capturer, on annule les déplacements sur des pions adverses
                        if (b[j].equals(J2.getnbPion()[k].getPlacement()) || b[j].equals(J1.getnbPion()[k].getPlacement())) {
                            b[j] = null;
                            j++;
                            break;
                        } else if ((k == J2.getnbPion().length - 1 && b[j] != J2.getnbPion()[k].getPlacement())) {
                            j++;
                        }
                    }
                }
            }
        }
        //Vérifie si dans la liste de déplacement les cases proposées sont hors du plateau 
        int i = 0;
        while (i < b.length - 1) {
            for (int j = 0; j < P1.getCase().length; j++) {
                if (b[i] != null && b[i].equals(P1.getCase()[j])) {
                    i++;
                    j = 0;
                    break;
                } else if ((j == P1.getCase().length - 1 && b[i] != P1.getCase()[j])) {
                    b[i] = null;
                    i++;
                }
            }
        }
        //Réduit le tableau pour effacer les cases nulles
        int cpt = 0;
        for (int j = 0; j < b.length - 1; j++) {
            if (b[j] != null) {
                cpt++;
            }
        }
        int cpt2 = 0;
        String a[] = new String[cpt + 1];
        for (int j = 0; j < b.length; j++) {
            if (b[j] != null) {
                a[cpt2] = b[j];
                cpt2++;
            }
        }
        return a;
    }

    //Renvoie selon la liste de déplacement d'un joueur, les pions qu'ils peut eventuellement capturer
    public Pion[] ListeCapture(String[] b) {
        int cpt = 0;
        Pion c[] = new Pion[b.length];
        //Vérifie si dans la liste de déplacement possible il n'y a pas un pion adverse
        if (b[b.length - 1].equals(J1.getCouleur())) {
            //Application pour J1
            int j = 0;
            while (j < b.length - 1) {
                for (int k = 0; k < J2.getnbPion().length; k++) {
                    if (b[j].equals(J2.getnbPion()[k].getPlacement())) {
                        cpt++;
                        c[j] = J2.getnbPion()[k];
                        j++;
                        break;
                    } else if ((k == J2.getnbPion().length - 1 && b[j] != J2.getnbPion()[k].getPlacement())) {
                        j++;
                    }
                }
            }
        } else {
            //Application pour J2
            int j = 0;
            while (j < b.length - 1) {
                for (int k = 0; k < J1.getnbPion().length; k++) {
                    if (b[j].equals(J1.getnbPion()[k].getPlacement())) {
                        cpt++;
                        c[j] = J1.getnbPion()[k];
                        j++;
                        break;
                    } else if ((k == J1.getnbPion().length - 1 && b[j] != J1.getnbPion()[k].getPlacement())) {
                        j++;
                    }
                }
            }
        }

        return c;
    }

    public boolean FindePartie() {
        //vérifie si la partie est terminée.
        File file = new File("sauvegarde.txt");
        //partie terminée lorsque 3 diiférents pions sont positionnés dans la zone rouge adverse
        int cpt = 0;
        int cpt2 = 0;
        for (int i = 0; i < P1.getZoneRougeJ1().length; i++) {
            if (J1.Recherche(P1.getZoneRougeJ1()[i]) != null) {
                cpt++;
            }
        }
        if (cpt == 3) {
            char a = J1.Recherche(P1.getZoneRougeJ1()[0]).getDesignation().charAt(0);//récupère la première lettre des pions (P,C ou D)
            char b = J1.Recherche(P1.getZoneRougeJ1()[1]).getDesignation().charAt(0);
            char c = J1.Recherche(P1.getZoneRougeJ1()[2]).getDesignation().charAt(0);
            if (a != b && b != c && a != c) {//indique 3 différentes pions
                file.delete();
                return true;
            }
        }
        for (int i = 0; i < P1.getZoneRougeJ2().length; i++) {
            if (J2.Recherche(P1.getZoneRougeJ2()[i]) != null) {
                cpt2++;
            }
        }
        if (cpt2 == 3) {
            char a = J2.Recherche(P1.getZoneRougeJ2()[0]).getDesignation().charAt(0);
            char b = J2.Recherche(P1.getZoneRougeJ2()[1]).getDesignation().charAt(0);
            char c = J2.Recherche(P1.getZoneRougeJ2()[2]).getDesignation().charAt(0);
            if (a != b && b != c && a != c) {
                file.delete();
                return true;
            }
        }
        //Partie terminée si une famille de pion a été remplacée
        int cpt3 = 0;
        int cpt4 = 0;
        int cpt5 = 0;
        int cpt6 = 0;
        int cpt7 = 0;
        int cpt8 = 0;
        for (int i = 0; i < 6; i++) {
            if (J1.getnbPion()[i].getPlacement().equals("")) {
                cpt3++;
            }
        }
        for (int i = 6; i < 12; i++) {
            if (J1.getnbPion()[i].getPlacement().equals("")) {
                cpt4++;
            }
        }
        for (int i = 12; i < 15; i++) {
            if (J1.getnbPion()[i].getPlacement().equals("")) {
                cpt5++;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (J2.getnbPion()[i].getPlacement().equals("")) {
                cpt6++;
            }
        }
        for (int i = 6; i < 12; i++) {
            if (J2.getnbPion()[i].getPlacement().equals("")) {
                cpt7++;
            }
        }
        for (int i = 12; i < 15; i++) {
            if (J2.getnbPion()[i].getPlacement().equals("")) {
                cpt8++;
            }
        }
        if (cpt3 == 6 || cpt4 == 6 || cpt5 == 3 || cpt6 == 6 || cpt7 == 6 || cpt8 == 3) {
            file.delete();
            System.out.println("PARTIE GAGNE");
            return true;
        }
        return false;
    }

    public Joueur getJ1() {
        return J1;
    }

    public Joueur getJ2() {
        return J2;
    }
    
    public Plateau getPlateau() {
        return P1;
    }
}
