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
        int[] n = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        //int[] n = {10,50,100,200};
        int count = 0;
        

        HugeInteger hu1, hu2;
        BigInteger h1, h2, h3;
        HugeInteger huge1, huge2, huge3;
        long startTime, endTime;
        for (int a =0; a < n.length; a++){

        
        double runTime=0.0;
        for (int numInts=0; numInts < MAXNUMINTS; numInts++){
        
        //h1 = new BigInteger();
        huge1 = new HugeInteger (n[a]) ; //creates a random integer of n digits
        huge2 = new HugeInteger(n[a]) ; //creates a random integer of n digits
        startTime = System.currentTimeMillis();
        for(int numRun=0; numRun < MAXRUN; numRun++)
        { 
            huge3 = huge1.add(huge2); }
            endTime = System.currentTimeMillis() ;
            runTime +=(double) (endTime - startTime)/((double) MAXRUN) ;
        }
            runTime = runTime/((double) MAXNUMINTS) ;
            System.out.println(runTime);
    }
    }
}