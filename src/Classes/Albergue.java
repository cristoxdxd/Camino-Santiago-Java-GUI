package Classes;

import java.io.Serializable;

/**
 *
 * @author Cristopher Herrera
 */
public class Albergue implements Serializable{
    private String Nombre;
    private int Capacidad;
    private double Precio;
    private String Localidad;

    public Albergue(){}
    
    public Albergue(String Nombre, int Capacidad, double Precio, String Localidad){
        this.Nombre = Nombre;
        this.Capacidad = Capacidad;
        this.Precio = Precio;
        this.Localidad = Localidad;
    }
    
    public String formatRegister(int number){
        String register = null;
        register = number + "\t" + Nombre + "\t" +
            Capacidad + "\t" +
            Precio + "\t" +
            Localidad;
        return register;
    }
    
    public boolean find(String search){
        boolean validador = false;
        if(search.equals(this.Nombre) || search.equals(this.Capacidad) || search.equals(this.Precio) || search.equals(this.Localidad)){
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

    public int getCapacidad() {
        return Capacidad;
    }
    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getLocalidad() {
        return Localidad;
    }
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }    
}
