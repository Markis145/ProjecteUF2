/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author alumne
 */
public class Projecte {

    static Joc jocProjecte = null;
    //static Scanner ent = null;
    static boolean llista = false, borrar = false;
    static int menu = 0;
    static char esMulti = ' ', esLlista = ' ', SiNo = ' ';

    private static final int MAX_JOCS = 4;
    private static Joc[] array = new Joc[MAX_JOCS];

    private static Scanner ent = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());
        tractamentFinal();
    }

    public static void tractamentFinal() {
        ent.close();
    }

    public static void inicialitzarVariables() {

        for (int i = 0; i < array.length; i++) {
            array[i] = new Joc();
            array[i].setOmplit(false);
        }
        jocProjecte = new Joc();
        ent = new Scanner(System.in);
    }

    public static void demanarOpcio() {
        pintarMenu();
        menu = ent.skip("[\r\n]*").nextInt();
    }

    public static void pintarMenu() {
        System.out.println("-------MENU-------");
        System.out.println("Selecciona la opció desitjada");
        System.out.println("0. Sortir");
        System.out.println("1. Insertar videojoc");
        System.out.println("2. Borrar videojocs");
        System.out.println("3. Modificar videojoc");
        System.out.println("4. Llistar videojocs");
    }

    public static void tractarOpcio() {
        switch (menu) {
            case 0:
                System.out.println("Sortint del programa...");
                break;
            case 1:
                insertarVideoJoc();
                break;
            case 2:
                borrarVideoJoc();
                break;
            case 3:
                modificarVideoJoc();
                break;
            case 4:
                llistarVideoJoc();
                break;
            default:
                System.out.println("Opció incorrecta! GTFO");
                break;
        }

    }

    public static boolean opcioFinal() {
        return menu == 0;
    }

    public static void insertarVideoJoc() {
        Scanner ent = new Scanner(System.in);

        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++);

        if (i < array.length) {
            System.out.println("Inserta les dades sobre el videojoc");
            System.out.println("Escriu el nom del joc:");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());

            System.out.println("Escriu el genere del joc:");
            array[i].setGenere(ent.skip("[\r\n]*").nextLine());

            do {
                System.out.println("Es multijugador?? (Si/No)");
                esMulti = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (esMulti != 'S' && esMulti != 'N');
            array[i].setMultijugador(esMulti == 'S');

            System.out.println("Quantes hores dura??");
            jocProjecte.setHores(ent.skip("[\r\n]*").nextInt());

            System.out.println("Quant costa?? (0 si es gratuït)");
            jocProjecte.setPreu(ent.skip("[\r\n]*").nextDouble());

            array[i].setOmplit(true);
        } else {
            System.out.println("No caben mes jocs, borran primer");
        }

    }

    public static void borrarVideoJoc() {
        Joc j = null;
        Scanner ent = new Scanner(System.in);
        int i;
        for (i = 0; i < array.length && SiNo != 'F'; i++) {
            j = array[i];
            if (j.isOmplit()) {
                System.out.println(j);
                do {
                    System.out.println("\nVols borrar el joc(S/N) o finalitzar la cerca (F)?:");
                    SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (SiNo != 'S' && SiNo != 'N' && SiNo != 'F');
            }
            if (SiNo == 'S') {
                break;
            }
        }

        if (SiNo == 'S') {
            j.setOmplit(false);
            System.out.println("Joc borrat");
        } else {
            System.out.println("No s'ha borrat cap joc");
        }
    }

    public static void modificarVideoJoc() {
        Scanner ent = new Scanner(System.in);
        Joc j = null;
        int cont = 1, i = 0;
        j = array[i];

        for (; i < array.length && SiNo != 'F'; i++) {
            if (array[i].isOmplit()) {
                System.out.format("\nJoc %d:\n", cont++);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols modificar el joc(S/N) o finalitzar la cerca (F)?;");
                    SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (SiNo != 'S' && SiNo != 'N' && SiNo != 'F');
            }
            if (SiNo == 'S') {
                break;
            }
        }

        if (SiNo == 'S') {
            System.out.println("\nNom: " + array[i].getNom());
            do {
                System.out.println("\nVols modificar el nom? (S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Nou nom: ");
                array[i].setNom(ent.skip("[\r\n]*").nextLine());
            }

            System.out.println("\nGenere: " + array[i].getGenere());
            do {
                System.out.println("\nVOls modificar el genere?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Nou genere: ");
                array[i].setGenere(ent.skip("[\r\n]*").nextLine());
            }

            System.out.println("\nPreu: " + array[i].getPreu());
            do {
                System.out.println("\nVols modificar el preu?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Nou preu: ");
                array[i].setPreu(ent.skip("[\r\n]*").nextDouble());
            }

            if (array[i].isMultijugador()) {
                System.out.println("\nÉs multijugador");
            } else {
                System.out.println("\nNo es multijugador");
            }
            do {
                System.out.println("\nVols modificar si es multijugador?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                char esMulti;
                do {
                    System.out.println("Llavors es multijugador o no?(S/N) ");
                    esMulti = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (esMulti != 'S' && esMulti != 'N');
                if (esMulti == 's') {
                    j.setMultijugador(true);
                } else {
                    j.setMultijugador(false);
                }
            }

            System.out.println("\nDuracio: " + array[i].getHores());
            do {
                System.out.println("\nVols modificar la duració?(S/N):");
                SiNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (SiNo != 'S' && SiNo != 'N');
            if (SiNo == 'S') {
                System.out.println("Nova duració: ");
                array[i].setHores(ent.skip("[\r\n]*").nextInt());
            }

        }

    }

    public static void llistarVideoJoc() {
        Scanner ent = new Scanner(System.in);
        boolean algun = false;
        char siNo = 'S';
        int i;
        for (i = 0; i < array.length; i++) {
            Joc j = array[i];
            if (j.isOmplit()) {
                algun = true;
                System.out.println(j);
                do {
                    System.out.println("\nVols veure mes jocs(S/N)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
            }
            if (siNo == 'N') {
                break;
            }
        }
        if (!algun) {
            System.out.println("\nNo hi ha jocs per mostrar");
        }

    }
}
