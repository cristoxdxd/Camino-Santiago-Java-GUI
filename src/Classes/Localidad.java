package Classes;

import java.io.Serializable;

/**
 *
 * @author Cristopher Herrera
 */
public class Localidad implements Serializable{
    private String Nombre;
    private String ComunidadAutonoma;
    private String CodigoPostal;
    private boolean Salida;
    private boolean Intermedio;
    private boolean Llegada;
    
    public Localidad(){}
    
    public Localidad(String Nombre, String ComunidadAutonoma, String CodigoPostal, boolean Salida, boolean Intermedio, boolean Llegada){
        this.Nombre = Nombre;
        this.ComunidadAutonoma = ComunidadAutonoma;
        this.CodigoPostal = CodigoPostal;
        this.Salida = Salida;
        this.Llegada = Llegada;
        this.Intermedio = Intermedio;
    }
    
    public String formatRegister(int number){
        String register = null;
        if(this.Salida){
            register = number + "\t" + Nombre + "\t" +
                ComunidadAutonoma + "\t" +
                CodigoPostal + "\t" +
                "Salida";
            if(this.Intermedio){
                register = register + " Intermedio";
            }
        }
        if(this.Llegada){
            register = number + "\t" + Nombre + "\t" +
                ComunidadAutonoma + "\t" +
                CodigoPostal + "\t" +
                "Llegada";
            if(this.Intermedio){
                register = register + " Intermedio";
            }
        }
        if(this.Intermedio){
            register = number + "\t" + Nombre + "\t" +
                ComunidadAutonoma + "\t" +
                CodigoPostal + "\t" +
                "-";
        }
        return register;
    }
    
    public boolean find(String search){
        boolean validador = false;
        if(search.equals(this.Nombre)){
            validador = true;
        }
        return validador;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + "\n" + 
               "Comunidad Autónoma: " + ComunidadAutonoma + "\n" +
               "Código Postal: " + CodigoPostal + "\n" +
               "Salida: " + Salida + "\n" +
               "Intermedio: " + Intermedio + "\n" +
               "Llegada: " + Llegada + "\n";
    }
    
    

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getComunidadAutonoma() {
        return ComunidadAutonoma;
    }
    public void setComunidadAutonoma(String ComunidadAutonoma) {
        this.ComunidadAutonoma = ComunidadAutonoma;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }
    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public boolean isSalida() {
        return Salida;
    }
    public void setSalida(boolean Salida) {
        this.Salida = Salida;
    }

    public boolean isIntermedio() {
        return Intermedio;
    }
    public void setIntermedio(boolean Intermedio) {
        this.Intermedio = Intermedio;
    }

    public boolean isLlegada() {
        return Llegada;
    }
    public void setLlegada(boolean Llegada) {
        this.Llegada = Llegada;
    }
}
