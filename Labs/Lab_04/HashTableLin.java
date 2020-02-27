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
        for (int i = 0; i < size; i++){
            table[i] = -1; // fills table with dummy values
        }
        


    }

    public void insert (int n){
        if (nKeys == size){
            rehash();
        }
        if (!this.isIn(n)){
            nKeys++;
            int index = n%size;
            while (table[index] != -1){ // linear probing
                index = (index+1)%size;
            }
            table[index] = n;

        }
        

        
        

    }

    private void rehash(){
        int newSize = 2*this.size;
        

        int[] rehashed = new int[newSize];
        for (int i = 0; i < newSize; i++){
            
        }
    }

    public boolean isIn(int n){
        int index = n%size; // set starting index
        for (int i = index; i < size; i++){
            if (n == this.table[index]){
                return true;
            }
        }
        return false; 
    }

    public void printKeys(){
        for (int i = 0; i < size; i++){
            if (table[i] != -1){
                System.out.print(table[i]+" ");
            } 
            System.out.println("\n");
        }
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
        int prime = (int)n;
        boolean isPrime = false;

        if (prime == 1){
            return 2;
        }
        
        while (true){
            for (int i = prime; i>2; i-- ){
                if (prime%i == 0){
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }

            prime++;
        }
            
        
    }


}