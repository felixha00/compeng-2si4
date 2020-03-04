package Labs.Lab_04;

import java.util.Random;

/**
 * TestHashTable
 */
public class TestHashTableLin {

    public static void avgProbes(int num, int tests) {
        double loadVals[] = { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 };
        HashTableLin hsl;
        double avgProbeCount;
        double sumProbes = 0;
        double sumAvgProbeCount = 0;

        for (int i = 0; i < loadVals.length; i++) {
            for (int n = 0; n < tests; n++) {
                hsl = new HashTableLin(num, loadVals[i]);
                sumProbes = 0;
                for (int j = 0; j < num; j++) {
                    Random r = new Random();
                    int rNum = r.nextInt();
                    sumProbes += hsl.insertCount(Math.abs(rNum));
                }

                sumAvgProbeCount += (sumProbes/(hsl.getNumKeys()));
                
            }
            avgProbeCount = sumAvgProbeCount/tests;
            
            double S_lambda = 0.5*(1+(1/(1-loadVals[i])));
            System.out.println("Theoretical S_lambda: " + S_lambda);
            System.out.println("Load Value: " + loadVals[i] + ", Avg Probes = " +avgProbeCount+"\n" );
            sumAvgProbeCount = 0;

        }
        

    }

    public static void unsuccessfulProbes(int num, int tests) {
        double loadVals[] = { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 };
        HashTableLin hsl;
        double avgProbeCount;
        double sumProbes = 0;
        double sumAvgProbeCount = 0;

        for (int i = 0; i < loadVals.length; i++) {
            for (int n = 0; n < tests; n++) {
                hsl = new HashTableLin(num, loadVals[i]);
                sumProbes = 0;
                for (int j = 0; j < num; j++) {
                    Random r = new Random();
                    int rNum = r.nextInt();
                    hsl.insertCount(Math.abs(rNum));
                }
                for (int k = 0; k < num; k++) {
                    Random r = new Random();
                    int sNum = r.nextInt();
                    sumProbes += hsl.unsuccessfulprobes(Math.abs(sNum));
                }

                sumAvgProbeCount += (sumProbes/(hsl.getNumKeys()));
                
            }
            avgProbeCount = sumAvgProbeCount/tests;
            
            double S_lambda = 0.5*(1+(1/Math.pow((1-loadVals[i]),2)));
            System.out.println("Theoretical S_lambda: " + S_lambda);
            System.out.println("Load Value: " + loadVals[i] + ", Avg Probes = " +avgProbeCount+"\n" );
            sumAvgProbeCount = 0;

        }
        

    }

    public static void main(String[] args) {

        System.out.println("TEST HASHTABLELIN\n===========");
        HashTableLin hsl = new HashTableLin(5, 0.4);

        System.out.println("Data of HashTable after initialization:\n");
        hsl.printData();

        System.out.println("\nInsert: 13,26,39,15,20 \n");
        hsl.insert(13);
        hsl.insert(26);
        hsl.insert(39);
        hsl.insert(15);
        hsl.insert(20);
        hsl.printData();
        hsl.printKeysAndIndexes();

        System.out.println("\nInsert 30, forces rehashing to next double prime number");
        hsl.insert(30);
        hsl.printData();
        hsl.printKeysAndIndexes();

        System.out.println("\nInsert 10, already inside, does not insert and number of keys remains same");
        hsl.insert(26);
        hsl.printData();
        hsl.printKeysAndIndexes();

        //avgProbes(100000, 100);

        unsuccessfulProbes(100000, 100);



    }

}