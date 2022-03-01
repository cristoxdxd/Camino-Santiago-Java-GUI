package Classes;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Cristopher Herrera
 */
public class Peregrino implements Serializable{
    private String Nombre;
    private int ID;
    private String Clave;
    private String Domicilio;
    private Camino camino;
    private Localidad[] localidades;
    
    public Peregrino(){}
    
    public Peregrino(String Nombre, int ID, String Clave, String Domicilio, Camino camino, Localidad[] localidades){
        this.Nombre = Nombre;
        this.ID = ID;
        this.Clave = Clave;
        this.Domicilio = Domicilio;
        this.camino = camino;
        this.localidades = localidades;
    }
    
    public String formatRegister(int number){
        String register = number + "\t" + Nombre + "\t" +
                ID + "\t" +
                Clave + "\t" +
                Domicilio + "\t" +
                camino + "\t" +
                Arrays.toString(localidades);
        return register;
    }
    
    public boolean find(String search){
        boolean validador = false;
        if(search.equals(this.Nombre) || search.equals(this.ID) || search.equals(this.Clave) || search.equals(this.Domicilio)){
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

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClave() {
        return Clave;
    }
    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getDomicilio() {
        return Domicilio;
    }
    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public Camino getCamino() {
        return camino;
    }
    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    public Localidad[] getLocalidades() {
        return localidades;
    }
    public void setLocalidades(Localidad[] localidades) {
        this.localidades = localidades;
    }
}
