package com.FuzzyLogic;
import java.util.Scanner;

public class Main {

    public static double getCrispInput(String placeholder) {
        Scanner input_stream = new Scanner(System.in);
        double user_input;

        while(true) {
            try {
                System.out.print(placeholder + ": ");
                user_input = input_stream.nextDouble();
                return user_input;
            }
            catch(Exception InputMismatchException) {
                System.out.println("[!] Only real numbers are allowed!\n");
                input_stream.next();
            }
        }
    }

    public static void printOutput(String variable_name, double value, String crisp_output) {
        System.out.println("\nPredicted Value (" + variable_name + ") = " + value);
        System.out.println(variable_name + " will be " + crisp_output);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("=== Support System For Project Team Formation ===");
        System.out.println("===             Using Fuzzy Logic             ===");
        System.out.println("=================================================\n");

        double project_fund = getCrispInput("Project Fund");
        double experience_level = getCrispInput("Experience Level");

        /*
        double output_value = 37.5;
        String output_variable_name = "Risk";
        String crisp_output = "Normal";

        printOutput(output_variable_name, output_value, crisp_output);
         */

    }
}
