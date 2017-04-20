/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

/**
 *
 * @author Casa
 */
public class Joc {
    public String nom = null;
    public String genere = null;
    public double preu = 0.0;
    public boolean multijugador = false;
    public int hores = 0;
    public boolean omplit = false;

    public Joc() { 
        
    }    

    @Override
    public String toString() {
        return "Dades del joc" + "nom: " + nom + ", genere: " + genere + ", preu: " + preu + "€, multijugador: " + multijugador + ", hores: " + hores;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        if(preu<0) System.out.println("El preu no pot ser negatiu");
        else this.preu = preu;
    }

    public boolean isMultijugador() {
        return multijugador;
    }

    public void setMultijugador(boolean multijugador) {
        this.multijugador = multijugador;
    }

    public boolean isOmplit() {
        return omplit;
    }
    
    public void setOmplit(boolean omplit) {
        this.omplit = omplit;
    }
    
    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        if(hores<0) System.out.println("Les hores han de ser positives");
        else this.hores = hores;
    }

    
}
