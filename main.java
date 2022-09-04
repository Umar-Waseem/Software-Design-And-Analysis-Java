import java.util.Scanner;

/*
    *Author: Muhammad Umar Waseem
    ~Roll No: i20-0762
    ~Section: CS-E
    ?Description: Console-Based Account Management System
 */

class mainClass{

    static void clrScreen() {
        System.out.print("\033[H\033[2J");
    }

    static void printBlue(String value){
        System.out.println("\033[94m" + value + "\033[0m" );
    }

    static String getStringInput(){
        Scanner input = new Scanner(System.in);
        String inputValue = input.nextLine();
        input.close();
        return inputValue;
    }

    static int getIntInput(){
        Scanner input = new Scanner(System.in);
        int inputValue = input.nextInt();
        input.close();
        return inputValue;
    }

    static double getDoubleInput(){
        Scanner input = new Scanner(System.in);
        double inputValue = input.nextDouble();
        input.close();
        return inputValue;
    }
    public static void main(String[] args){
        clrScreen(); 
        System.out.println("Please enter your name: ");
        String name = getStringInput();
        printBlue("Hey there " + name.toUpperCase() + " Welcome to the Account Management System");

        savings sAcc = new savings( 111000.0);
        sAcc.printStatement();
        sAcc.calculateZakat();
    }

}