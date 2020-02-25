package Labs.Lab_04;

/**
 * HashTableLin
 */
public class HashTableLin {
    private int[] table;
    private int size;
    private int nKeys;
    private double maxLoad;

    public HashTableLin (int maxNum, double load){
        this.maxLoad = load;
        double minSize = maxNum/load;
        
        


    }

    public void insert (int n){
        if (nKeys == size){
            rehash();
        }
        if (!this.isIn(n)){
            nKeys++;
            int index = n%size;
            table[index] = n;
        }
        

        
        

    }

    private void rehash(){
        int newSize = 2*size;
        

        int[] rehashed = new int[newSize];
    }

    public boolean isIn(int n){
        if 
        return true;
    }

    public void printKeys(){
        for 
    }

    public void printKeysAndIndexes(){

    }

    public int getSize(){
        return this.size;
    }

    public double getLoadFactor(){
        return this.maxLoad;
    }

    public int nextPrime(double n){
        while (true){

        }
    }


}