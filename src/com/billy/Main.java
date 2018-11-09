package com.billy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many prime numbers do you need? (Please limit in 1 to 100) ");
        int n = sc.nextInt();
        if (n <= 0 || n > 100) {
            throw new IllegalArgumentException();
        }

        PrintTable print = new PrintTable();
        print.printTable(n);
    }
}
