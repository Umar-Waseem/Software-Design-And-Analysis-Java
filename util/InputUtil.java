package util;

import java.util.Scanner;

public class InputUtil {

    static Scanner input;

    public static void init(){
        input = new Scanner(System.in);
    }

    


    public static String getStringInput() {
        String inputValue = input.nextLine();
        // input.close();
        return inputValue;
    }

    public static int getIntInput() {
        int inputValue = input.nextInt();
        // input.close();
        return inputValue;
    }

    public static double getDoubleInput() {
        double inputValue = input.nextDouble();
        // input.close();
        return inputValue;
    }
}
