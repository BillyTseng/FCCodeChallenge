package com.billy;

import java.util.ArrayList;
import java.util.List;

class PrintTable {
    void printTable(int n) {
        FermatPrimality fp = new FermatPrimality();
        List<Integer> primeList = new ArrayList<>();
        int candidate = 1;
        while (n > 0) {
            if (fp.isPrime(candidate, 10)) {
                primeList.add(candidate);
                n--;
            }
            candidate++;
        }

        // Conduct a format string to align different length of product.
        int numOfDigits = getNumOfDigits(primeList);
        String formatStr = "%" + numOfDigits + "d ";

        // Print spaces on th first slot.
        for (int i = 0; i <= numOfDigits; i++) {
            System.out.print(" ");
        }

        // Print the first row with prime numbers.
        for (Integer aPrimeList : primeList) {
            System.out.printf(formatStr, aPrimeList);
        }
        System.out.println();

        for (int i = 0; i < primeList.size(); i++) {
            for (int j = 0; j < primeList.size(); j++) {
                if (j == 0) {
                    // Print the first col with prime numbers.
                    System.out.printf(formatStr, primeList.get(i));
                }
                // Print the products
                System.out.printf(formatStr, primeList.get(i) * primeList.get(j));
            }
            System.out.println();
        }
    }

    private int getNumOfDigits(List<Integer> primeList) {
        int largestProduct = (int)Math.pow(primeList.get(primeList.size() - 1), 2);
        int cnt = 0;
        while (largestProduct != 0) {
            largestProduct /= 10;
            cnt++;
        }
        return cnt;
    }
}
