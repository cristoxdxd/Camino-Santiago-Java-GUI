package ToTest;

import java.security.*;
import java.util.*;

/**
 * @author Cristopher Herrera
 */
public class TestControllerbin_Albergues {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("\tTo test Binary\n--> Cristopher Herrera");
        String FileRoute = "AlberguesBinary.data";
        int option = 0;
        final int exit = 7;
        do{
            option = StandarReading.readInt("\n\tFuture Promises School"
                    + "\n1. Show Clients List"
                    + "\n2. Show Clients (one-by-one)"
                    + "\n3. Add a Clients"
                    + "\n4. Find data"
                    + "\n5. Update a Clients (by List Number)"
                    + "\n6. Remove a Clients (by List Number)"
                    + "\n" + Integer.toString(exit) + ". Salir"
                    + "\nEnter your option: ");
            /*switch(option){
                case 1:
                    ArrayList<Clients> students2 = new ArrayList<>();
                    students2 = FilesManager_bin.showListedFile(FileRoute);
                    System.out.printf("\n%-6s%-12s%-40s%-20s%-30s%-20s","Nro.","CardCode","Fullname", "Password", "Balance", "Birthday\n");
                    for(int i = 1; i < students2.size(); i++){
                        System.out.println((students2.get(i-1)).formatRegister(i));
                    }
                    break;
                case 2:
                    FilesManager_bin.showFile(FileRoute);
                    break;
                case 3:
                    System.out.println("\n\tNew Student Registration");
                    Clients newClient = new Clients(
                            StandarReading.readString("CardCode: "), 
                            StandarReading.readString("Fullname (Lastnames & Names): ").toUpperCase(), 
                            StandarReading.readString("Password: "),
                            StandarReading.readDouble("Balance: "),
                            StandarReading.readString("Birthday: "));
                    if(FilesManager_bin.addRegister(newClient, FileRoute))
                        System.out.println("\n\tRegistration Completed.\n");
                    else
                        System.out.println("Unexpeted error!");
                    break;
                case 4:
                    String searchWord = StandarReading.readString("Enter your search: ");
                    System.out.println("\nRecords that contains: " + searchWord);
                    System.out.println(FilesManager_bin.findinFile(searchWord, FileRoute));
                    break;
                case 5:
                    ArrayList<Clients> newfile = new ArrayList<>();
                    newfile = FilesManager_bin.showListedFile(FileRoute);
                    int index1 = StandarReading.readInt("Enter List Number to update: ")-1;
                    System.out.println("\n\tRegister to update \n" + newfile.get(index1));
                    String Pw = StandarReading.readString("Update password: ");
                    //int newPw = Integer.parseInt(Pw);
                    String Bal = StandarReading.readString("Update balance: "); 
                    Double newFN = Double.parseDouble(Bal);
                    if (Pw.length()>0) (newfile.get(index1)).setPassword(Pw);
                    if (Bal.length()>0) (newfile.get(index1)).setBalance(newFN);
                    System.out.println("\tUpdated data\n" + newfile.get(index1));
                    Object[] modifiedStudent = newfile.toArray();
                    if (FilesManager_bin.addRegisters(modifiedStudent, FileRoute))
                        System.out.println("The list was updated successfully.");
                    break;
                case 6:
                    ArrayList<Clients> newfile2 = new ArrayList<>();
                    newfile2 = FilesManager_bin.showListedFile(FileRoute);
                    int index2 = StandarReading.readInt("Enter List Number to update: ");
                    System.out.println("\tStudent to remove\n" + newfile2.get(index2));
                    if(StandarReading.readString("Are you sure to remove this student? (Y/N): ").equalsIgnoreCase("Y")){
                        newfile2.remove(index2);
                        Object[] modifiedList = newfile2.toArray();
                        if (FilesManager_bin.addRegisters(modifiedList, FileRoute))
                            System.out.println("The student was removed successfully.");
                    }
                    break;
                case exit:
                    break;
                default:
                    break;
            }*/
        }while(option!=7);
    }
}