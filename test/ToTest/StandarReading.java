package ToTest;

import java.util.Scanner;

public class StandarReading {
    public static String readString(String message){
        String words;
        System.out.print(message);
        Scanner input = new Scanner(System.in);
        words = input.nextLine();
        return words;
    }
    
    public static boolean readBoolean(String message){
        String words;
        boolean returnBoolean = false;
        System.out.print(message);
        Scanner input = new Scanner(System.in);
        words = input.nextLine();
        returnBoolean = Boolean.parseBoolean(words);
        return returnBoolean;
    }
    
    public static int readInt(String message){
        System.out.print(message);
        int number;
        Scanner stdIn = new Scanner(System.in);
        String input = stdIn.nextLine();
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error. " + e.getMessage());
            number = -1000000;
        }
        return number;
    }
    
    public static float readFloat(String message){
        System.out.print(message);
        float number;
        Scanner stdIn = new Scanner(System.in);
        String input = stdIn.nextLine();
        try {
            number = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            System.out.println("Error. " + e.getMessage());
            number = (float)-0.0000001;
        }
        return number;
    }
    
    public static double readDouble(String message){
        System.out.print(message);
        double number;
        Scanner stdIn = new Scanner(System.in);
        String input = stdIn.nextLine();
        try {
            number = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Error. " + e.getMessage());
            number = (double)-0.0000001;
        }
        return number;
    }
}
