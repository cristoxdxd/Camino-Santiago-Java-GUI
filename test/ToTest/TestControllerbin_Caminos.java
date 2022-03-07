package ToTest;

import Classes.*;
import java.security.*;
import java.util.*;

/**
 * @author Cristopher Herrera
 */
public class TestControllerbin_Caminos {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\tTo test Binary Caminos\n--> Cristopher Herrera");
        String FileRoute = "CaminosBinary.data";
        String FileRouteEtapa = "EtapasBinary.data";
        /*ArrayList<Etapa> etapasInit = FilesManager_bin.showListedEtapaFile(FileRouteEtapa);
        int indexEtapa1 = FilesManager_bin.getIndexEtapa("Etapa 1 (Camino Frances)", FileRouteEtapa);
        int indexEtapa2 = FilesManager_bin.getIndexEtapa("Etapa 2 (Camino Frances)", FileRouteEtapa);
        Etapa[] initEtapa1 = {etapasInit.get(indexEtapa1), etapasInit.get(indexEtapa2)};
        Camino[] camino = {new Camino("Camino Frances", 24.2, 6, initEtapa1)};
        FilesManager_bin.addRegisters(camino, FileRoute);*/
                
        int option = 0;
        final int exit = 7;
        do{
            option = StandarReading.readInt("\n\tCaminos"
                    + "\n1. Mostrar lista de Caminos"
                    + "\n2. Mostrar (objetos) Caminos"
                    + "\n3. Agregar Caminos"
                    + "\n4. Buscar en Caminos"
                    + "\n5. Actualizar un Camino (por número de lista)"
                    + "\n6. Eliminar un Camino (por número de lista)"
                    + "\n" + Integer.toString(exit) + ". Salir"
                    + "\nOpción: ");
            switch(option){
                case 1:
                    ArrayList<Camino> newArrayCaminos = new ArrayList<>();
                    newArrayCaminos = FilesManager_bin.showListedCaminoFile(FileRoute);
                    System.out.printf("\n%-6s%-40s%-15s%-10s%-30s","Nro.","Nombre","Km", "Tiempo", "Etapas\n");
                    for(int i = 1; i < newArrayCaminos.size()+1; i++){
                        System.out.println((newArrayCaminos.get(i-1)).formatRegister(i));
                    }
                    break;
                case 2:
                    FilesManager_bin.showFile(FileRoute);
                    break;
                case 3:
                    Etapa[] newEtapas = new Etapa[6];
                    ArrayList<Etapa> etapas = FilesManager_bin.showListedEtapaFile(FileRouteEtapa);
                    System.out.println("\n\tRegistro Nuevo Camino");
                    String unaEtapa;
                    int i = 0;
                    do{
                        unaEtapa = StandarReading.readString("\nIngrese las etapas\n(Press 'X' to exit)\n");
                        if (FilesManager_bin.findEtapainFile(unaEtapa, FileRouteEtapa)){
                            int j = FilesManager_bin.getIndexEtapa(unaEtapa, FileRouteEtapa);
                            newEtapas[i] = etapas.get(j);
                        }else{
                            System.out.println("No es una localidad.");
                        }
                        i++;
                    }while(!unaEtapa.equalsIgnoreCase("X"));
                    Camino newClient = new Camino(
                            StandarReading.readString("Nombre: "), 
                            StandarReading.readDouble("Km: "), 
                            StandarReading.readInt("Tiempo: "),
                            newEtapas);
                    if(FilesManager_bin.addRegister(newClient, FileRoute))
                        System.out.println("\n\tRegistro Completado.\n");
                    else
                        System.out.println("Error inesperado!");
                    break;
                case 4:
                    String searchWord = StandarReading.readString("Ingrese su búsqueda: ");
                    System.out.println("\nRegistros que contienen: " + searchWord);
                    System.out.println(FilesManager_bin.findCaminoinFile(searchWord, FileRoute));
                    break;
                case 5:
                    Etapa[] newEtapas1 = new Etapa[33];
                    ArrayList<Etapa> etapas1 = FilesManager_bin.showListedEtapaFile(FileRouteEtapa);
                    ArrayList<Camino> newfile = new ArrayList<>();
                    newfile = FilesManager_bin.showListedCaminoFile(FileRoute);
                    int index1 = StandarReading.readInt("Ingrese el número de lista a actualizar: ")-1;
                    System.out.println("\n\tCamino a actualizar \n" + newfile.get(index1));
                    int x = 0;
                    do{
                        unaEtapa = StandarReading.readString("\nIngrese las etapas\n(Press 'X' to exit)\n");
                        if (FilesManager_bin.findEtapainFile(unaEtapa, FileRouteEtapa)){
                            int j = FilesManager_bin.getIndexEtapa(unaEtapa, FileRouteEtapa);
                            newEtapas1[x] = etapas1.get(j);
                        }else{
                            System.out.println("No es una localidad.");
                        }
                        x++;
                    }while(!unaEtapa.equalsIgnoreCase("X"));
                    String Nombre = StandarReading.readString("Actualizar Nombre: ");
                    double Km = StandarReading.readDouble("Actualizar Km: ");
                    int tiempo = StandarReading.readInt("Actualizar tiempo: ");
                    if (Nombre.length()>0) (newfile.get(index1)).setNombre(Nombre);
                    if (Km>0) (newfile.get(index1)).setKm(Km);
                    if (tiempo>0) (newfile.get(index1)).setTiempo(tiempo);
                    (newfile.get(index1)).setEtapas(newEtapas1);
                    //System.out.println(Arrays.toString(newEtapas1));
                    System.out.println("\tDatos actualizados\n" + newfile.get(index1));
                    Object[] modifiedStudent = newfile.toArray();
                    if (FilesManager_bin.addRegisters(modifiedStudent, FileRoute))
                        System.out.println("El camino fue actualizado.");
                    break;
                case 6:
                    ArrayList<Camino> newfile2 = new ArrayList<>();
                    newfile2 = FilesManager_bin.showListedCaminoFile(FileRoute);
                    int index2 = StandarReading.readInt("Ingrese el número de lista a remover: ")-1;
                    System.out.println("\tCamino a remover\n" + newfile2.get(index2));
                    if(StandarReading.readString("Seguro que quieres eliminar esta etapa? (S/N): ").equalsIgnoreCase("S")){
                        newfile2.remove(index2);
                        Object[] modifiedList = newfile2.toArray();
                        if (FilesManager_bin.addRegisters(modifiedList, FileRoute))
                            System.out.println("El camino fue removido.");
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