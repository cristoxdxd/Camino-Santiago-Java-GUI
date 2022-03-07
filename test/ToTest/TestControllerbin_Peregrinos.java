package ToTest;

import Classes.*;
import java.security.*;
import java.util.*;

/**
 * @author Cristopher Herrera
 */
public class TestControllerbin_Peregrinos {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\tTo test Binary\n--> Cristopher Herrera");
        String FileRoute = "PeregrinosBinary.data";
        String FileRouteLocalidad = "LocalidadesBinary.data";
        String FileRouteCamino = "CaminosBinary.data";
        
        /*ArrayList<Localidad> localidadesInit = FilesManager_bin.showListedLocalidadFile(FileRouteLocalidad);
        int indexLocalidad1 = FilesManager_bin.getIndexLocalidad("St. Jean Pied de Port", FileRouteLocalidad);
        int indexLocalidad2 = FilesManager_bin.getIndexLocalidad("Roncesvalles", FileRouteLocalidad);
        String unCamino1 = "Camino Frances";
        Camino newcamino1 = new Camino();
        ArrayList<Camino> caminos1 = FilesManager_bin.showListedCaminoFile(FileRouteCamino);
        int f = FilesManager_bin.getIndexCamino(unCamino1, FileRouteCamino);
        newcamino1 = caminos1.get(f);
        Localidad[] initLocalidades1 = {localidadesInit.get(indexLocalidad1), localidadesInit.get(indexLocalidad2)};
        Peregrino[] etapas = {new Peregrino("Julián Barrio", 53365687, "1234", "Madrid", newcamino1,initLocalidades1)};
        FilesManager_bin.addRegisters(etapas, FileRoute);*/
        
        int option = 0;
        final int exit = 7;
        do{
            option = StandarReading.readInt("\n\tPeregrinos"
                    + "\n1. Mostrar lista de Peregrinos"
                    + "\n2. Mostrar (objetos) Peregrinos"
                    + "\n3. Agregar Peregrinos"
                    + "\n4. Buscar en Peregrinos"
                    + "\n5. Actualizar un Peregrino (por número de lista)"
                    + "\n6. Eliminar un Peregrino (por número de lista)"
                    + "\n" + Integer.toString(exit) + ". Salir"
                    + "\nOpción: ");
            switch(option){
                case 1:
                    ArrayList<Peregrino> students2 = new ArrayList<>();
                    students2 = FilesManager_bin.showListedPeregrinoFile(FileRoute);
                    System.out.printf("\n%-6s%-40s%-13s%-8s%-30s%-30s%-20s","Nro.","Nombre","ID", "Clave", "Domicilio", "Camino", "Localidades\n");
                    try{
                        for(int i = 1; i < students2.size()+1; i++){
                            System.out.println((students2.get(i-1)).formatRegister(i));
                        }
                    }catch(NullPointerException e){
                        System.out.println("Error. " + e.getMessage());
                    }  
                    break;
                case 2:
                    FilesManager_bin.showFile(FileRoute);
                    break;
                case 3:
                    Localidad[] newlocalidades = new Localidad[33];
                    ArrayList<Localidad> localidades = FilesManager_bin.showListedLocalidadFile(FileRouteLocalidad);
                    Camino newcamino = new Camino();
                    ArrayList<Camino> caminos = FilesManager_bin.showListedCaminoFile(FileRouteCamino);
                    System.out.println("\n\tRegistro Nuevo Peregrino");
                    String unCamino = StandarReading.readString("Ingrese el Camino: ");
                    if(FilesManager_bin.findCaminoinFile(unCamino, FileRouteCamino)){
                        int y = FilesManager_bin.getIndexCamino(unCamino, FileRouteCamino);
                        newcamino = caminos.get(y);
                    }else{
                        System.out.println("No es un camino.");
                    }
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
                    Peregrino newPeregrino = new Peregrino(
                            StandarReading.readString("Nombre: "), 
                            StandarReading.readInt("ID: "),
                            StandarReading.readString("Clave: "),
                            StandarReading.readString("Domicilio: "),
                            newcamino,
                            newlocalidades);
                    if(FilesManager_bin.addRegister(newPeregrino, FileRoute))
                        System.out.println("\n\tRegistro Completado.\n");
                    else
                        System.out.println("Error inesperado!");
                    break;
                case 4:
                    String searchWord = StandarReading.readString("Ingrese su búsqueda: ");
                    System.out.println("\nRegistros que contienen: " + searchWord);
                    System.out.println(FilesManager_bin.findPeregrinoinFile(searchWord, FileRoute));
                    break;
                case 5:
                    ArrayList<Peregrino> newfile = new ArrayList<>();
                    newfile = FilesManager_bin.showListedPeregrinoFile(FileRoute);
                    int index1 = StandarReading.readInt("Ingrese el número de lista a actualizar: ")-1;
                    System.out.println("\n\tPeregrino a actualizar \n" + newfile.get(index1));
                    String Nombre = StandarReading.readString("Actualizar Nombre: ");
                    int ID = StandarReading.readInt("Actualizar ID: ");
                    String Clave = StandarReading.readString("Actualizar Clave: ");
                    if (Nombre.length()>0) (newfile.get(index1)).setNombre(Nombre);
                    if (ID>0) (newfile.get(index1)).setID(ID);
                    if (Clave.length()>0) (newfile.get(index1)).setClave(Clave);
                    System.out.println("\tDatos actualizados\n" + newfile.get(index1));
                    Object[] modifiedStudent = newfile.toArray();
                    if (FilesManager_bin.addRegisters(modifiedStudent, FileRoute))
                        System.out.println("Peregrino actualizado.");
                    break;
                case 6:
                    ArrayList<Peregrino> newfile2 = new ArrayList<>();
                    newfile2 = FilesManager_bin.showListedPeregrinoFile(FileRoute);
                    int index2 = StandarReading.readInt("Ingrese el número de lista a remover: ")-1;
                    System.out.println("\tPeregrino a remover\n" + newfile2.get(index2));
                    if(StandarReading.readString("Seguro que quieres eliminar esta etapa? (S/N): ").equalsIgnoreCase("S")){
                        newfile2.remove(index2);
                        Object[] modifiedList = newfile2.toArray();
                        if (FilesManager_bin.addRegisters(modifiedList, FileRoute))
                            System.out.println("Peregrino removido.");
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