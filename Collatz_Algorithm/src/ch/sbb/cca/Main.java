package ch.sbb.cca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        CollatzFunction collatzFunction = new CollatzFunction();
        collatzFunction.findLongestSequence();

    }

    private static void collatz_Function(int input) {
        int number = input;
        while(number != 1){
            if(number % 2 == 0){
                number /= 2;
            } else {
                number = (number * 3) + 1;
            }
            System.out.println(number);
        }
    }

    private static void inputCollatz(){
        while(true){
            int userInput = getInput();

            if(userInput > 0){
                collatz_Function(userInput);
                System.out.println(String.format("Collatz Berechnung für %s", userInput));
            } else {
                continue;
            }
        }
    }

    private static int getInput(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Eingabe:");
        try {
            return Integer.parseInt(input.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
