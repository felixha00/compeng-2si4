package Labs.Lab_05;

import java.util.Arrays;


/**
 * MaxHeap
 */
public class MaxHeap {
    private int numElem;
    private int arrSize; 
    private Integer items[];
    private boolean isMaxHeap = false;
     

    public MaxHeap (int size){
        this.arrSize = size; 
        this.numElem = 0; 
        items = new Integer[size];
    }

    public MaxHeap(Integer[] someArray){
        arrSize = someArray.length;
        numElem = someArray.length;
        items = new Integer[numElem];

        for (int i = 0; i < numElem; i++){
            items[i] = someArray[i];
        }
        buildHeap(items);
    }

    public void percolateDown (Integer[] arr, int pos){
        int largest = pos;
        int left = 2*pos + 1;
        int right = 2*pos + 2;


        if (left < numElem && arr[left] > arr[largest]){
            largest = left;
        }

        if (right < numElem && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != pos){
            swap(arr,pos,largest);
            percolateDown(arr,largest);
        }

    }
    public void percolateUp (int i){
        int parentIndex = (i-1)/2;
        if (i > 0 && items[parentIndex] < items[i]){
            swap (items, parentIndex, i);
            percolateUp(parentIndex);
        }
    }
    public void buildHeap(Integer[] arr) {
        int startInd = (numElem/2) -1;
        for (int i = startInd; i >= 0; i--){
           percolateDown(arr, i);
        }
    }
  
    private void swap(Integer[] arr, int pos1, int pos2){
        int temp; 
        temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp; 
    }
    public void insert(int n){

        if (arrSize == numElem){
            Integer[] newArr = new Integer[2*arrSize];
            for (int i = 0; i < arrSize; i++){
                newArr[i] = items[i];
            }
            items = newArr;
            arrSize = newArr.length;
        }

        items[numElem] = n; // insert at last element
        numElem++;
        percolateUp(numElem-1);
    }
    private int deleteMax(){

        int max = items[0];
        items[0] = items[numElem-1]; // last element becomes root
        items[numElem-1] = null;
        numElem--;
        percolateDown(items, 0);
        return max;
    }

    public String toString(){
        String s ="";
        for (int i = 0; i < numElem; i++) 
            if (i == numElem-1)
            {
                s+= items[i];
            }
            else {
                s += items[i]+",";
            }
        return s;
    }

    public static void heapsort(Integer[] arrayToSort){ // returns in descending order
        MaxHeap mh = new MaxHeap(arrayToSort);
        int loop = mh.numElem;
        for (int i = 0; i < loop; i++){
            arrayToSort[i] = mh.deleteMax();
        }
    }

    public int getSize(){
        return numElem;
    }

    public int getCapacity(){
        return arrSize;
    }
    
    public boolean isMaxHeap(){
        percolateDown(items,0);
        return isMaxHeap;
    }

    public int[] stringToArray (String s){
        return null;
    }

    public static void main(String[] args) {
    Integer a[] = { 1, 3, 5, 4, 6, 13, 10, 
        9, 8, 15, 17 }; 
    

    MaxHeap heap = new MaxHeap(10);
    MaxHeap h2 = new MaxHeap(a);

    System.out.println("Empty Heap: "+ heap.toString());

    System.out.println("{Insert 0-9}");
    for (int i = 0; i < 10; i++)
    {
        heap.insert(i);
    }
    System.out.println("Heap after: "+ heap.toString());
    System.out.println("Number of elements: "+ heap.getSize());
    System.out.println("{Insert 10} - forces resize");
    heap.insert(10);
    System.out.println(heap.toString());
    System.out.println("New Capacity after resizing 2x: "+heap.getCapacity());
    System.out.println("Number of Elements after resizing and inserting: "+heap.getSize());

    System.out.println("################### ARRAY TESTING");
    System.out.println(h2.toString());
    
    System.out.println("Delete Max 4 times:");
    System.out.println(h2.deleteMax());
    System.out.println(h2.deleteMax());
    System.out.println(h2.deleteMax());
    System.out.println(h2.deleteMax());

    System.out.println("After deleting: "+h2.toString());

    Integer[] t = new Integer[] {23,-5,223,291,-33,-333,65,683};
    System.out.println("TEST HEAP SORT");
    System.out.println("Before sorting: " + Arrays.toString(t));
    heapsort(t);
    System.out.println("After sorting: " +Arrays.toString(t));
}
}
