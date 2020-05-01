package exceptions;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ExceptionsHandling {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        System.out.println("---TASK 1---");
        System.out.println(readInt("Input number: "));

        System.out.println("---TASK 2--");
        //System.out.println(hateOdds(integersStream(10)););
        iterate(10);
    }

    private static int readInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                String number = input.next();
                int numb = Integer.parseInt(number);
                System.out.print("Your number: ");
                return numb;

            } catch (NumberFormatException e) {
                //e.getMessage();
                System.out.print(ANSI_RED + "Wrong format of input! " + ANSI_RESET + "Please, enter a number: ");
            }
        }
    }

    private static void hateOdds(int n) throws Exception {
        if (n % 2 != 0) throw new Exception("The number is odd");
        //System.out.print("The number is even");
    }

//    private static IntStream integersStream(long n) {
//        return IntStream.iterate(1, x -> x + 1).limit(n);
//    }

    private static void iterate(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");

            try {
                hateOdds(i);
                System.out.print("NO EXCEPTION");
            } catch (Exception e) {
                System.out.print(ANSI_RED + "EXCEPTION" + ANSI_RESET);
            }

            System.out.println();

        }
    }
}

