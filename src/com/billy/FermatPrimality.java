package com.billy;

import java.util.HashSet;
import java.util.Set;

public class FermatPrimality {
    // A Carmichael number is an odd composite number n which is a pseudoprime to base a for every number a prime to n.
    private final int[] CARMICHAEL_NUMBERS = new int[] {561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341,
            41041, 46657, 52633, 62745, 63973, 75361, 101101, 115921, 126217, 162401, 172081, 188461,
            252601, 278545, 294409, 314821, 334153, 340561, 399001, 410041, 449065, 488881, 512461};

    private long powerAndMod(long factor, long power, long modulus) {
        long result = 1;
        while(power > 0) {
            if (power % 2 == 1){
                result = (result * factor) % modulus;
                power = power - 1;
            }
            power = power / 2;
            factor = (factor * factor) % modulus;
        }
        return result;
    }

    public boolean isPrime(int inputNum, int numTrials) {
        // Corner cases
        if (inputNum <= 1) return false;
        if (inputNum <= 3) return true;

        // Check Carmichael number
        if (isCarmichaelNumber(inputNum)) {
            // must be composite
            return false;
        }

        // run through numTrials
        for (int trial = 0; trial < numTrials; trial++){

            // generate a randNumber between 2 and inputNum - 1
            int randNumber = 2 + (int)(Math.random() * ((inputNum - 1) - 2 + 1));


            // fermat test
            if (powerAndMod(randNumber,inputNum - 1, inputNum) != 1) {
                // must be composite
                return false;
            }
        }

        return true;
    }

    private boolean isCarmichaelNumber(int inputNum) {
        if (inputNum >= CARMICHAEL_NUMBERS[0]) {
            Set<Integer> cnSet = new HashSet<>();
            for (int num : CARMICHAEL_NUMBERS) {
                cnSet.add(num);
            }
            return cnSet.contains(inputNum);
        }
        return false;
    }
}
