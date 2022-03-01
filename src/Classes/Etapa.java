package Classes;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Cristopher Herrera
 */
public class Etapa implements Serializable{
    private String Nombre;
    private double Km;
    private int tiempo;
    private Localidad[] localidades;
    
    public Etapa(){}
    
    public Etapa(String Nombre, double Km, int tiempo, Localidad[] localidades){
        this.Nombre = Nombre;
        this.Km = Km;
        this.tiempo = tiempo;
        this.localidades = localidades;
    }
    
    public String formatRegister(int number){
        String register;
        String[] someLocalidades = new String[localidades.length];
        for (int i = 0; i < localidades.length; i++){
            someLocalidades[i] = localidades[i].getNombre();
        }
        register = number + "\t" + Nombre + "\t" +
            Km + "\t" +
            tiempo + "\t" +
            Arrays.toString(someLocalidades);
        return register;
    }
    
    public boolean find(String search){
        boolean validador = false;
        if(search.equals(this.Nombre) || search.equals(this.Km) || search.equals(this.tiempo)){
            validador = true;
        }
        return validador;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + Nombre + "\n" +
               "Distancia: " + Km + "\n" +
               "Tiempo: " + tiempo + "\n" +
               "Localidades: " + Arrays.toString(localidades) + "\n"; 
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

    public Localidad[] getLocalidades() {
        return localidades;
    }

    public void setLocalidades(Localidad[] localidades) {
        this.localidades = localidades;
    }
    
    
}
