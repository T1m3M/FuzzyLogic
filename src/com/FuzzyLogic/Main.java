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

    public static void printOutput(double value, String crisp_output) {
        System.out.println("\nPredicted Value (Risk) = " + value);
        System.out.println("Risk will be " + crisp_output);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("=== Support System For Project Team Formation ===");
        System.out.println("===             Using Fuzzy Logic             ===");
        System.out.println("=================================================\n");

        double project_fund = getCrispInput("Project Fund");
        double experience_level = getCrispInput("Experience Level");

        FuzzySolver fuzzy_model = new FuzzySolver(project_fund, experience_level);

        fuzzy_model.solve();

        double output_value = fuzzy_model.getOutputValue();
        String crisp_output = fuzzy_model.getCrispOutput();

        printOutput(output_value, crisp_output);

    }
}
