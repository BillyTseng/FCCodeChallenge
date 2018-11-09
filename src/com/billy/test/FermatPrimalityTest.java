package com.billy.test;
import com.billy.FermatPrimality;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FermatPrimalityTest {
    private final int[] HUNDRED_PRIMES = new int[] {
            2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,
            73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,
            179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,
            283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,
            419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541};

    private final int NUM_TRAILS = 5;

    @Test
    public void test1_hundredPrimes() {
        // test 100 prime numbers.
        FermatPrimality solution = new FermatPrimality();
        boolean res = true;
        for (int prime : HUNDRED_PRIMES) {
            res &= solution.isPrime(prime, NUM_TRAILS);
        }
        assertTrue(res);
    }

    @Test
    public void test2_NotPrimes() {
        // test the numbers which is not prime in range 1 to 541.
        Set<Integer> primeSet = new HashSet<>();
        for (int prime : HUNDRED_PRIMES) {
            primeSet.add(prime);
        }

        // generate not prime numbers
        List<Integer> notPrimes = new ArrayList<>();
        int i = 1;
        while (i < 541) {
            if (!primeSet.contains(i)) {
                notPrimes.add(i);
            }
            i++;
        }

        FermatPrimality solution = new FermatPrimality();
        boolean res = false;
        for (int notPrime : notPrimes) {
            res |= solution.isPrime(notPrime, NUM_TRAILS);
        }
        assertFalse(res);
    }

    @Test
    public void test3_CarmichaelNumber() {
        // test carmichael numbers.
        final int[] carmichaelNumbers = new int[] {
                561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973, 75361};
        FermatPrimality solution = new FermatPrimality();
        boolean res = false;
        for (int num : carmichaelNumbers) {
            boolean temp = solution.isPrime(num, NUM_TRAILS);
            if (temp) {
                System.out.println(num);
            }
            res |= temp;
        }
        assertFalse(res);
    }
}
