package exceptions;


import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String title = scanner.next();


        System.out.println(title);
    }
}