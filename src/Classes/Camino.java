package Classes;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Cristopher Herrera
 */
public class Camino implements Serializable{
    private String Nombre;
    private double Km;
    private int tiempo;
    private Etapa[] etapas;
    
    public Camino(){}
    
    public Camino(String Nombre, double Km, int tiempo, Etapa[] etapas){
        this.Nombre = Nombre;
        this.Km = Km;
        this.tiempo = tiempo;
        this.etapas = etapas;
    }
    
    public String formatRegister(int number){
        String register = null;
        register = number + "\t" + Nombre + "\t" +
            Km + "\t" +
            tiempo + "\t" +
            Arrays.toString(etapas);
        return register;
    }
    
    public boolean find(String search){
        boolean validador = false;
        if(search.equals(this.Nombre) || search.equals(this.Km) || search.equals(this.tiempo)){
            validador = true;
        }
        return validador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getKm() {
        return Km;
    }

    public void setKm(double Km) {
        this.Km = Km;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Etapa[] getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapa[] etapas) {
        this.etapas = etapas;
    }
}
