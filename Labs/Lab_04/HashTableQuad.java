package Labs.Lab_04;

/**
 * HashTableQuad
 */
public class HashTableQuad {

    private Integer[] table;
    private int size;
    private int nKeys;
    private double maxLoad;

    public HashTableQuad (int maxNum, double load){
        this.nKeys = 0;
        this.maxLoad = load;
        
        this.size = maxNum;
        double minSize = maxNum/load;
        
        table = new Integer[this.nextPrime(minSize)];
        
        for (int i = 0; i < table.length; i++){
            table[i] = -1; // fills table with dummy values
        }

    }

    public void insert (int n){
        int count = 0;
        if (nKeys == size){
            rehash();
        }
        if (!this.isIn(n)){
            nKeys++;
            int index = n%table.length;
            int baseIndex = index;
            try {
            while (table[index] != -1){ // linear probing
                
                index = (baseIndex+(count*count))%table.length;
                count++;
                
            }
            table[index] = n;
        }
        catch (ArrayIndexOutOfBoundsException e){
            rehash();
            insert(n);
        }
        }
    
    }

    public int insertCount (int n){
        int probeCount = 0;
        int count = 0;
    
        if (nKeys == size){
            rehash();
        }

        
        if (!this.isIn(n)){
            probeCount++;
            nKeys++;
            int index = n%table.length;
            int baseIndex = index;
            while (table[index] != -1){ // linear probing
                index = (baseIndex+(count*count))%table.length;
                count++;
                probeCount++;
            }
            table[index] = n;
        }
        
        return probeCount;
        
    }

    private void rehash(){
        int count = 0;
        int newSize = this.nextPrime(2*table.length);
        Integer[] rehashed = new Integer[newSize];
        
        
        for (int i = 0; i < rehashed.length; i++){
            rehashed[i] = -1;
        }

        for (int i = 0; i < table.length; i++){
            int index = table[i]%rehashed.length;
            int baseIndex = index;

            if (table[i] != -1){
                while (rehashed[index] != -1){ // linear probing
                    index = (baseIndex+(count*count))%rehashed.length;
                    count++;
                }
                rehashed[index] = table[i];
                count = 0;
            }
            
        }
       
        

        this.table = rehashed;
        this.size = (int)(newSize*maxLoad); // get maximum 
        return;
    }

    public boolean isIn(int n){
        if (this.nKeys == 0){
            return false;
        }

        int index = n%table.length; // set starting index
        for (int i = index; i < this.table.length; i++){
            if (n == this.table[index]){
                return true;
            }
        }
        return false; 
    }

    public void printKeys(){
        for (int i = 0; i < this.table.length; i++){
            if (table[i] != -1){
                System.out.print(table[i]+" ");
            } 
            
        }
    }

    public void printKeysAndIndexes(){
        for (int i = 0; i < this.table.length; i++){
            if (table[i] == -1){
                System.out.println("[" + i+ "]:\t-");
            } 
            else {
                System.out.println("[" + i+ "]:\t" +table[i]);
            }
            
        }
    }

    public int getSize(){
        return this.size;
    }
    public int getNumKeys(){
        return this.nKeys;
    }
    public double getLoadFactor(){
        return this.maxLoad;
    }
    public void printData(){
        System.out.println("HashTableSize: "+ this.table.length);
        System.out.println("MaxNumKeys: "+ getSize());
        System.out.println("Number of Keys: "+ getNumKeys());
        System.out.println("Maximum Load: " + getLoadFactor());
    }
    
    public int nextPrime(double n){
        int prime = (int)Math.ceil(n) - 1 ; // rounds up -1 just in case the number is already a prime, so it returns that number
        int counter;
        prime++;


        while(true){
          int l = (int) Math.sqrt(prime);
          counter = 0;
          for(int i = 2; i <= l; i ++){
            if(prime % i == 0)  counter++;
          }
          if(counter == 0)
            return prime;
          else{
            prime++;
            continue;
          }
        }
            
        
    }

}