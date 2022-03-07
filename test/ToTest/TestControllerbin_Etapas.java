package ToTest;

import Classes.*;
import java.security.*;
import java.util.*;

/**
 * @author Cristopher Herrera
 */
public class TestControllerbin_Etapas {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\tTo test Binary Etapa\n--> Cristopher Herrera");
        String FileRoute = "EtapasBinary.data";
        String FileRouteLocalidad = "LocalidadesBinary.data";
        /*ArrayList<Localidad> localidadesInit = FilesManager_bin.showListedLocalidadFile(FileRouteLocalidad);
        int indexLocalidad1 = FilesManager_bin.getIndexLocalidad("St. Jean Pied de Port", FileRouteLocalidad);
        int indexLocalidad2 = FilesManager_bin.getIndexLocalidad("Roncesvalles", FileRouteLocalidad);
        Localidad[] initLocalidades1 = {localidadesInit.get(indexLocalidad1), localidadesInit.get(indexLocalidad2)};
        int indexLocalidad3 = FilesManager_bin.getIndexLocalidad("Zubiri", FileRouteLocalidad);
        Localidad[] initLocalidades2 = {localidadesInit.get(indexLocalidad2), localidadesInit.get(indexLocalidad3)};
        Etapa[] etapas = {new Etapa("Etapa 1 (Camino Frances)", 24.2, 6, initLocalidades1),
                          new Etapa("Etapa 2 (Camino Frances)", 21.5, 5, initLocalidades2)};
        FilesManager_bin.addRegisters(etapas, FileRoute);*/
        int option = 0;
        final int exit = 7;
        do{
            option = StandarReading.readInt("\n\tEtapas"
                    + "\n1. Mostrar lista de Etapas"
                    + "\n2. Mostrar (objetos) Etapas"
                    + "\n3. Agregar Etapas"
                    + "\n4. Buscar en Etapas"
                    + "\n5. Actualizar una Etapa (por número de lista)"
                    + "\n6. Eliminar una Etapa (por número de lista)"
                    + "\n" + Integer.toString(exit) + ". Salir"
                    + "\nOpción: ");
            switch(option){
                case 1:
                    ArrayList<Etapa> newArrayEtapas = new ArrayList<>();
                    newArrayEtapas = FilesManager_bin.showListedEtapaFile(FileRoute);
                    System.out.println("\n\tEtapas");
                    System.out.printf("\n%-6s%-40s%-15s%-10s%-30s","Nro.","Nombre","Km", "Tiempo (h)", "Localidades\n");
                    for(int i = 1; i < newArrayEtapas.size()+1; i++){
                        System.out.println((newArrayEtapas.get(i-1)).formatRegister(i));
                    }
                    
                    ArrayList<Localidad> newArrayLocalidades = new ArrayList<>();
                    newArrayLocalidades = FilesManager_bin.showListedLocalidadFile(FileRouteLocalidad);
                    System.out.println("\n\tLocalidades");
                    System.out.printf("\n%-6s%-25s%-25s%-10s%-10s%-15s%-10s","Nro.","Nombre","Comunidad Autonoma", "Código Postal", "Salida", "Intermedio", "Llegada\n");
                    for(int j = 1; j < newArrayLocalidades.size()+1; j++){
                        System.out.println((newArrayLocalidades.get(j-1)).formatRegister(j));
                    }
                    break;
                case 2:
                    FilesManager_bin.showFile(FileRoute);
                    break;
                case 3:
                    Localidad[] newlocalidades = new Localidad[2];
                    ArrayList<Localidad> localidades = FilesManager_bin.showListedLocalidadFile(FileRouteLocalidad);
                    System.out.println("\n\tRegistro Nueva Etapa");
                    String unaLocalidad;
                    int i = 0;
                    do{
                        unaLocalidad = StandarReading.readString("\nIngrese las localidades\n(Press 'X' to exit)\n");
                        if (FilesManager_bin.findLocalidadinFile(unaLocalidad, FileRouteLocalidad)){
                            int j = FilesManager_bin.getIndexLocalidad(unaLocalidad, FileRouteLocalidad);
                            newlocalidades[i] = localidades.get(j);
                        }else{
                            System.out.println("No es una localidad.");
                        }
                        i++;
                    }while(!unaLocalidad.equalsIgnoreCase("X"));
                    Etapa newClient = new Etapa(
                            StandarReading.readString("Nombre: "), 
                            StandarReading.readDouble("Km: "), 
                            StandarReading.readInt("Tiempo: "),
                            newlocalidades);
                    if(FilesManager_bin.addRegister(newClient, FileRoute))
                        System.out.println("\n\tRegistro Completado.\n");
                    else
                        System.out.println("Error inesperado!");
                    break;
                case 4:
                    String searchWord = StandarReading.readString("Ingrese su busqueda: ");
                    System.out.println("\nRegistros que contiene: " + searchWord);
                    System.out.println(FilesManager_bin.findEtapainFile(searchWord, FileRoute));
                    break;
                case 5:
                    ArrayList<Etapa> newfile = new ArrayList<>();
                    newfile = FilesManager_bin.showListedEtapaFile(FileRoute);
                    int index1 = StandarReading.readInt("Ingrese el número de lista a actualizar: ")-1;
                    System.out.println("\n\tEtapa a actualizar \n" + newfile.get(index1));
                    String Nombre = StandarReading.readString("Actualizar nombre: ");
                    double Km = StandarReading.readDouble("Actualizar Km: ");
                    int tiempo = StandarReading.readInt("Actualizar tiempo: ");
                    if (Nombre.length()>0) (newfile.get(index1)).setNombre(Nombre);
                    if (Km>0) (newfile.get(index1)).setKm(Km);
                    if (tiempo>0) (newfile.get(index1)).setTiempo(tiempo);
                    System.out.println("\tDatos actualizados\n" + newfile.get(index1));
                    Object[] modifiedStudent = newfile.toArray();
                    if (FilesManager_bin.addRegisters(modifiedStudent, FileRoute))
                        System.out.println("La estapa fue actualizada.");
                    break;
                case 6:
                    ArrayList<Etapa> newfile2 = new ArrayList<>();
                    newfile2 = FilesManager_bin.showListedEtapaFile(FileRoute);
                    int index2 = StandarReading.readInt("Ingrese el número de lista a remover: ")-1;
                    System.out.println("\tEtapa a remover\n" + newfile2.get(index2));
                    if(StandarReading.readString("Seguro que quieres eliminar esta etapa? (S/N): ").equalsIgnoreCase("S")){
                        newfile2.remove(index2);
                        Object[] modifiedList = newfile2.toArray();
                        if (FilesManager_bin.addRegisters(modifiedList, FileRoute))
                            System.out.println("La estapa fue removida.");
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