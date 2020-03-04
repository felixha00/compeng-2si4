package Labs.Lab_05;

/**
 * MaxHeap
 */
public class MaxHeap {
    int heapSize;
    int arrSize; 
    int items[]; 

    public MaxHeap (int size){
        this.arrSize = size; 
        this.heapSize = 0; 
        
        //items = new int[this. + 1]; 
        items[0] = Integer.MAX_VALUE; 
    }

    public MaxHeap(Integer[] someArray){

        arrSize = someArray.length;
        for (int i = 0; i < arrSize; i++){

        }
    }

    private int leftChild(int pos){
        return (2*pos);
    }

    private int rightChild(int pos){
        return (2*pos)+1;
    }

    private int parent(int pos){    
        return pos/2;
    }
    
    private void swap(int pos1, int pos2){
        int temp; 
        temp = items[pos1];
        items[pos1] = items[pos2];
        items[pos2] = temp; 
    }

    public void insert(int n){

    }

    private int deleteMax(){
        return 0;
    }

    public String toString(){
        return "";
    }

    public static void heapsort(Integer[] arrayToSort){
        
    }

    public int getHeapSize(){
        return heapSize;
    }

    public int getArrSize(){
        return arrSize;
    }









    
}