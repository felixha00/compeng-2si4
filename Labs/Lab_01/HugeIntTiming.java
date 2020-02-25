package Labs.Lab_01;

import java.math.BigInteger;
import java.util.Random;

/**
 * HugeIntTiming
 */
public class HugeIntTiming {

    public static void main(String[] args) {

        int MAXNUMINTS = 500;
        int MAXRUN = 2000;
        int[] n = {10, 100, 500, 750};
        // int[] n = {10,50,100,200};
        int count = 0;

        HugeInteger hu1, hu2;
        BigInteger h1, h2, h3;
        HugeInteger huge1, huge2, huge3;
        long startTime, endTime;
        for (int a = 0; a < n.length; a++) {

            double runTime = 0.0;
            for (int numInts = 0; numInts < MAXNUMINTS; numInts++) {

                huge1 = new HugeInteger(n[a]); // creates a random integer of n digits
                huge2 = new HugeInteger(n[a]); // creates a random integer of n digits
                h1 = new BigInteger(huge1.toString());
                h2 = new BigInteger(huge2.toString());
                startTime = System.currentTimeMillis();
                for (int numRun = 0; numRun < MAXRUN; numRun++) {
                   //h3 = h1.multiply(h2);
                   h1.compareTo(h2);
                   //huge2.compareTo(huge1);
                }
                endTime = System.currentTimeMillis();
                runTime += (double) (endTime - startTime) / ((double) MAXRUN);
            }
            runTime = runTime / ((double) MAXNUMINTS);
            System.out.println(runTime);
        }
    }
}