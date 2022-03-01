package ToTest;

import Classes.*;
import java.security.*;
import java.util.*;

/**
 * @author Cristopher Herrera
 */
public class TestControllerbin_Albergues {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\tTo test Binary Albergue\n--> Cristopher Herrera");
        String FileRoute = "AlberguesBinary.data";
        int option = 0;
        final int exit = 7;
        do{
            option = StandarReading.readInt("\n\tAlbergues"
                    + "\n1. Mostrar lista de Albergues"
                    + "\n2. Mostrar (objetos) Albergues"
                    + "\n3. Agregar Albergues"
                    + "\n4. Buscar en Albergues"
                    + "\n5. Actualizar un Albergue (por número de lista)"
                    + "\n6. Eliminar un Albergue (por número de lista)"
                    + "\n" + Integer.toString(exit) + ". Salir"
                    + "\nOpción: ");
            switch(option){
                case 1:
                    ArrayList<Albergue> newArrayAlbergues = new ArrayList<>();
                    newArrayAlbergues = FilesManager_bin.showListedAlbergueFile(FileRoute);
                    System.out.printf("\n%-6s%-40s%-10s%-10s%-30s","Nro.","Nombre","Capacidad", "Precio", "Localidad\n");
                    for(int i = 1; i < newArrayAlbergues.size(); i++){
                        System.out.println((newArrayAlbergues.get(i-1)).formatRegister(i));
                    }
                    break;
                case 2:
                    FilesManager_bin.showFile(FileRoute);
                    break;
                case 3:
                    System.out.println("\n\tRegistration Nuevo Albergue");
                    Albergue newClient = new Albergue(
                            StandarReading.readString("Nombre: "), 
                            StandarReading.readInt("Capacidad: "), 
                            StandarReading.readDouble("Precio: "),
                            StandarReading.readString("Localidad: "));
                    if(FilesManager_bin.addRegister(newClient, FileRoute))
                        System.out.println("\n\tRegistro Completado.\n");
                    else
                        System.out.println("Error inesperado!");
                    break;
                case 4:
                    String searchWord = StandarReading.readString("Ingrese su búsqueda: ");
                    System.out.println("\nRegistros que contienen: " + searchWord);
                    System.out.println(FilesManager_bin.findAlbergueinFile(searchWord, FileRoute));
                    break;
                case 5:
                    ArrayList<Albergue> newfile = new ArrayList<>();
                    newfile = FilesManager_bin.showListedAlbergueFile(FileRoute);
                    int index1 = StandarReading.readInt("Ingrese el número de lista a actualizar: ")-1;
                    System.out.println("\n\tAlbergue a actualizar \n" + newfile.get(index1));
                    String Nombre = StandarReading.readString("Actualizar Nombre: ");
                    int Capacidad = StandarReading.readInt("Actualizar capacidad: "); 
                    double Precio = StandarReading.readDouble("Actualizar precio: ");
                    String Localidad = StandarReading.readString("Actualizar Localidad: ");
                    if (Nombre.length()>0) (newfile.get(index1)).setNombre(Nombre);
                    if (Capacidad>0) (newfile.get(index1)).setCapacidad(Capacidad);
                    if (Precio>0) (newfile.get(index1)).setPrecio(Precio);
                    if (Localidad.length()>0) (newfile.get(index1)).setLocalidad(Localidad);
                    System.out.println("\tDatos actualizados\n" + newfile.get(index1));
                    Object[] modifiedStudent = newfile.toArray();
                    if (FilesManager_bin.addRegisters(modifiedStudent, FileRoute))
                        System.out.println("El albergue fue actualizado.");
                    break;
                case 6:
                    ArrayList<Albergue> newfile2 = new ArrayList<>();
                    newfile2 = FilesManager_bin.showListedAlbergueFile(FileRoute);
                    int index2 = StandarReading.readInt("Ingrese el número de lista a remover: ");
                    System.out.println("\tAlbergue a remover\n" + newfile2.get(index2));
                    if(StandarReading.readString("Seguro que quieres eliminar esta etapa? (S/N): ").equalsIgnoreCase("S")){
                        newfile2.remove(index2);
                        Object[] modifiedList = newfile2.toArray();
                        if (FilesManager_bin.addRegisters(modifiedList, FileRoute))
                            System.out.println("El albergue fue removido.");
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