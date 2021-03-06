package ToTest;

import Classes.*;
import java.security.*;
import java.util.*;

/**
 * @author Cristopher Herrera
 */
public class TestControllerbin_Localidades {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\tTo test Binary Localidad\n--> Cristopher Herrera");
        String FileRoute = "LocalidadesBinary.data";
        int option = 0;
        final int exit = 7;
        do{
            option = StandarReading.readInt("\n\tLocalidades"
                    + "\n1. Mostrar lista de Localidades"
                    + "\n2. Mostrar (objetos) Localidades"
                    + "\n3. Agregar Localidades"
                    + "\n4. Buscar en Localidades"
                    + "\n5. Actualizar una Localidad (por número de lista)"
                    + "\n6. Eliminar una Localidad (por número de lista)"
                    + "\n" + Integer.toString(exit) + ". Salir"
                    + "\nOpción: ");
            switch(option){
                case 1:
                    ArrayList<Localidad> newArrayLocalidades = new ArrayList<>();
                    newArrayLocalidades = FilesManager_bin.showListedLocalidadFile(FileRoute);
                    System.out.printf("\n%-6s%-30s%-25s%-10s%-10s%-15s%-10s","Nro.","Nombre","Comunidad Autonoma", "Código Postal", "Salida", "Intermedio", "Llegada\n");
                    for(int i = 1; i < newArrayLocalidades.size()+1; i++){
                        System.out.println((newArrayLocalidades.get(i-1)).formatRegister(i));
                    }
                    break;
                case 2:
                    FilesManager_bin.showFile(FileRoute);
                    break;
                case 3:
                    System.out.println("\n\tRegistro Nueva Localidad");
                    Localidad newLocalidad = new Localidad(
                            StandarReading.readString("Nombre: "), 
                            StandarReading.readString("Comunidad Autónoma: "), 
                            StandarReading.readString("Codigo Postal: "),
                            StandarReading.readBoolean("Salida: "),
                            StandarReading.readBoolean("Intermedio: "),
                            StandarReading.readBoolean("Llegada: "));
                    if(FilesManager_bin.addRegister(newLocalidad, FileRoute))
                        System.out.println("\n\tRegistro de nueva Localidad completado.\n");
                    else
                        System.out.println("Error inesperado");
                    break;
                case 4:
                    String searchWord = StandarReading.readString("Ingrese su busqueda: ");
                    System.out.println("\nRegistros que contienen: " + searchWord);
                    System.out.println(FilesManager_bin.findLocalidadinFile(searchWord, FileRoute));
                    break;
                case 5:
                    ArrayList<Localidad> newfile = new ArrayList<>();
                    newfile = FilesManager_bin.showListedLocalidadFile(FileRoute);
                    int index1 = StandarReading.readInt("Ingrese el número de lista a actualizar: ")-1;
                    System.out.println("\n\tLocalidad a actualizar \n" + newfile.get(index1));
                    String newNombre = StandarReading.readString("Actualizar Nombre: ");
                    String newCA = StandarReading.readString("Actualizar Comunidad Autónoma: "); 
                    String newCP = StandarReading.readString("Actualizar Código Postal: ");
                    boolean newSalida = StandarReading.readBoolean("Actualizar Salida: ");
                    boolean newIntermedio = StandarReading.readBoolean("Actualizar Intermedio: ");
                    boolean newLlegada = StandarReading.readBoolean("Actualizar Llegada: ");
                    if (newNombre.length()>0) (newfile.get(index1)).setNombre(newNombre);
                    if (newCA.length()>0) (newfile.get(index1)).setComunidadAutonoma(newCA);
                    if (newCP.length()>0) (newfile.get(index1)).setCodigoPostal(newCP);
                    (newfile.get(index1)).setSalida(newSalida);
                    (newfile.get(index1)).setIntermedio(newIntermedio);
                    (newfile.get(index1)).setLlegada(newLlegada);
                    System.out.println("\tDatos actualizados\n" + newfile.get(index1));
                    Object[] modifiedLocalidad = newfile.toArray();
                    if (FilesManager_bin.addRegisters(modifiedLocalidad, FileRoute))
                        System.out.println("La localidad fue actualizada.");
                    break;
                case 6:
                    ArrayList<Localidad> newfile2 = new ArrayList<>();
                    newfile2 = FilesManager_bin.showListedLocalidadFile(FileRoute);
                    int index2 = StandarReading.readInt("Ingrese el número de lista a remover: ")-1;
                    System.out.println("\tLocalidad a remover\n" + newfile2.get(index2));
                    if(StandarReading.readString("Seguro que quieres eliminar esta localidad? (S/N): ").equalsIgnoreCase("S")){
                        newfile2.remove(index2);
                        Object[] modifiedList = newfile2.toArray();
                        if (FilesManager_bin.addRegisters(modifiedList, FileRoute))
                            System.out.println("La localidad fue removida.");
                    }
                    break;
                case exit:
                    break;
                default:
                    break;
            }
        }while(option!=7);
    }
}