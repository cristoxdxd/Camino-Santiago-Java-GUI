package Classes;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Cristopher Herrera
 */
public class FilesManager_bin {
    private static char defaultSeparator = '\t';
    
    public static boolean addRegister(Object object, String FileRoute){
        boolean validator = false;
        try{
            AppendableObjectOutputStream fileOut = new AppendableObjectOutputStream(
                    new FileOutputStream(FileRoute, true));
            fileOut.writeObject(object);
            fileOut.flush();
            fileOut.close();
            validator = true;
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }
        return validator;
    }
    
    public static boolean addRegisters(Object[] objects, String FileRoute){
        boolean validator = false;
        FileOutputStream fos;
        ObjectOutputStream fileOut;
        try{
            fos = new FileOutputStream(FileRoute, false);
            fileOut = new ObjectOutputStream(fos);
            for(Object objeto : objects){
                fileOut.writeObject(objeto);
            }
            fileOut.close();
            validator = true;
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }
        return validator;
    }
    
    public static void showFile(String FileRoute){
        FileInputStream fis;
        ObjectInputStream fileIn = null;
        try{
            fis = new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Object object;
            do{
                object = fileIn.readObject();
                if (object!=null){
                    System.out.println(object);
                }
            }while(object!=null);
            fileIn.close();
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Class Not Found " + ex.getMessage());
        }
    }
    
    public static ArrayList<Albergue> showListedAlbergueFile(String FileRoute){
        ArrayList<Albergue> clients = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream fileIn;
        try{
            fis = new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Albergue object;
            do{
                object = (Albergue)fileIn.readObject();
                if (object!=null){
                    clients.add((Albergue)object);
                }
            }while(object!=null);
            System.out.println();
            fileIn.close();
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Class Not Found " + ex.getMessage());
        }
        return clients;
    }
    public static ArrayList<Camino> showListedCaminoFile(String FileRoute){
        ArrayList<Camino> clients = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream fileIn;
        try{
            fis = new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Camino object;
            do{
                object = (Camino)fileIn.readObject();
                if (object!=null){
                    clients.add((Camino)object);
                }
            }while(object!=null);
            System.out.println();
            fileIn.close();
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Class Not Found " + ex.getMessage());
        }
        return clients;
    }
    public static ArrayList<Etapa> showListedEtapaFile(String FileRoute){
        ArrayList<Etapa> clients = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream fileIn;
        try{
            fis = new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Etapa object;
            do{
                object = (Etapa)fileIn.readObject();
                if (object!=null){
                    clients.add((Etapa)object);
                }
            }while(object!=null);
            System.out.println();
            fileIn.close();
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Class Not Found " + ex.getMessage());
        }
        return clients;
    }
    public static ArrayList<Localidad> showListedLocalidadFile(String FileRoute){
        ArrayList<Localidad> localidad = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream fileIn;
        try{
            fis = new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Localidad object;
            do{
                object = (Localidad)fileIn.readObject();
                localidad.add((Localidad)object);
                /*if (object!=null){
                    
                }*/
            }while(object!=null);
            System.out.println();
            fileIn.close();
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Class Not Found " + ex.getMessage());
        }
        return localidad;
    }
    public static ArrayList<Peregrino> showListedPeregrinoFile(String FileRoute){
        ArrayList<Peregrino> clients = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream fileIn;
        try{
            fis = new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Peregrino object;
            do{
                object = (Peregrino)fileIn.readObject();
                if (object!=null){
                    clients.add((Peregrino)object);
                }
            }while(object!=null);
            System.out.println();
            fileIn.close();
        }catch (IOException ex){
            System.out.println("Error." + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Class Not Found " + ex.getMessage());
        }
        return clients;
    }
    
    public static boolean findLocalidadinFile(String search, String FileRoute){
        boolean validator = false;
        FileInputStream fis;
        ObjectInputStream fileIn;
        int counter = 0;
        try{
            fis= new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Localidad object;
            do{
                object = (Localidad)fileIn.readObject();
                if (object != null){
                    validator = object.find(search);
                    if(validator){
                        System.out.println(object.formatRegister(counter+1));
                        counter++;
                        return validator;
                    }
                }
            }while(object != null);
            System.out.println("Coincidencias encontradas: " + counter);
        }catch(EOFException e){
            System.out.println("EOFException: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage() + e.toString());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFound: " + e.getMessage());
        }
        return validator;
    }
    
    public static boolean findEtapainFile(String search, String FileRoute){
        boolean validator = false;
        FileInputStream fis;
        ObjectInputStream fileIn;
        int counter = 0;
        try{
            fis= new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Etapa object;
            do{
                object = (Etapa)fileIn.readObject();
                if (object != null){
                    validator = object.find(search);
                    if(validator){
                        System.out.println(object.formatRegister(counter+1));
                        counter++;
                        return validator;
                    }
                }
            }while(object != null);
            System.out.println("Coincidencias encontradas: " + counter);
        }catch(EOFException e){
            System.out.println("EOFException: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage() + e.toString());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFound: " + e.getMessage());
        }
        return validator;
    }
    
    public static boolean findCaminoinFile(String search, String FileRoute){
        boolean validator = false;
        FileInputStream fis;
        ObjectInputStream fileIn;
        int counter = 0;
        try{
            fis= new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Camino object;
            do{
                object = (Camino)fileIn.readObject();
                if (object != null){
                    validator = object.find(search);
                    if(validator){
                        System.out.println(object.formatRegister(counter+1));
                        counter++;
                        return validator;
                    }
                }
            }while(object != null);
            System.out.println("Coincidencias encontradas: " + counter);
        }catch(EOFException e){
            System.out.println("EOFException: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage() + e.toString());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFound: " + e.getMessage());
        }
        return validator;
    }
    
    public static boolean findAlbergueinFile(String search, String FileRoute){
        boolean validator = false;
        FileInputStream fis;
        ObjectInputStream fileIn;
        int counter = 0;
        try{
            fis= new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Albergue object;
            do{
                object = (Albergue)fileIn.readObject();
                if (object != null){
                    validator = object.find(search);
                    if(validator){
                        System.out.println(object.formatRegister(counter+1));
                        counter++;
                        return validator;
                    }
                }
            }while(object != null);
            System.out.println("Coincidencias encontradas: " + counter);
        }catch(EOFException e){
            System.out.println("EOFException: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage() + e.toString());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFound: " + e.getMessage());
        }
        return validator;
    }
    
    public static boolean findPeregrinoinFile(String search, String FileRoute){
        boolean validator = false;
        FileInputStream fis;
        ObjectInputStream fileIn;
        int counter = 0;
        try{
            fis= new FileInputStream(FileRoute);
            fileIn = new ObjectInputStream(fis);
            Peregrino object;
            do{
                object = (Peregrino)fileIn.readObject();
                if (object != null){
                    validator = object.find(search);
                    if(validator){
                        System.out.println(object.formatRegister(counter+1));
                        counter++;
                        return validator;
                    }
                }
            }while(object != null);
            System.out.println("Coincidencias encontradas: " + counter);
        }catch(EOFException e){
            System.out.println("EOFException: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException: " + e.getMessage() + e.toString());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFound: " + e.getMessage());
        }
        return validator;
    }
    
    public static int getIndex(String search, String FileRoute){
        ArrayList<Peregrino> peregrino = new ArrayList<>();
        peregrino = showListedPeregrinoFile(FileRoute);
        int index = 0;
        System.out.println(search);
        System.out.println(FileRoute);
        for(int i = 0; i < peregrino.size(); i++){
            if((peregrino.get(i)).getNombre().equals(search)){
                return i;
            }
        }
        return index;
    }
    
    public static String[] splitFields(String search){
        return search.split(Character.toString(defaultSeparator));
    }
    
    public static class AppendableObjectOutputStream extends ObjectOutputStream{
        public AppendableObjectOutputStream(OutputStream out) throws IOException{
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }        
    }
}
