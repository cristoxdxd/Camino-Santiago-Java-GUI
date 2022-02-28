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
}
