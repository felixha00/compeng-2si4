package Labs.Lab_04;
import java.util.Random;
/**
 * TestHashTable
 */
public class TestHashTableQuad {

    public static void avgProbes(int num, int tests) {
        double loadVals[] = { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 };
        HashTableQuad hsq;
        double avgProbeCount;
        double sumProbes = 0;
        double sumAvgProbeCount = 0;

        for (int i = 0; i < loadVals.length; i++) {
            for (int n = 0; n < tests; n++) {
                hsq = new HashTableQuad(num, loadVals[i]);
                sumProbes = 0;
                for (int j = 0; j < num; j++) {
                    Random r = new Random();
                    int rNum = r.nextInt();
                    sumProbes += hsq.insertCount(Math.abs(rNum));
                }

                sumAvgProbeCount += (sumProbes/(hsq.getNumKeys()));
                
            }
            avgProbeCount = sumAvgProbeCount/tests;
            
            double S_lambda = 0.5*(1+(1/(1-loadVals[i])));
            System.out.println("Theoretical S_lambda: " + S_lambda);
            System.out.println("Load Value: " + loadVals[i] + ", Avg Probes = " +avgProbeCount+"\n" );
            sumAvgProbeCount = 0;

        }
        

    }
    public static void main(String[] args) {
        

        System.out.println("TEST HASHTABLEQUAD\n===========");
        HashTableQuad hsq = new HashTableQuad(45, 5); // give size 11

        System.out.println("Data of HashTable after initialization:\n");
        hsq.printData();

        System.out.println("\nInsert: 11, 22, 33, 44, 55, 66, 77 shows quadratic probing \n");
        hsq.insert(11);
        hsq.insert(22);
        hsq.insert(33);
        hsq.insert(44);
        hsq.insert(55);
        hsq.insert(66);
        hsq.printData();
        hsq.printKeysAndIndexes();
        
        avgProbes(100000, 100);
    }
    
}