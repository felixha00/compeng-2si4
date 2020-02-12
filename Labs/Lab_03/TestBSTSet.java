package Labs.Lab_03;

public class TestBSTSet {

    public static void main(String[] args) {
        int[] i= {3, 5, 7, 78, 9, 1, 32, 23};
        int[] i2 = {2, 5, 12, 312, 12, 512, 123, 34};

        BSTSet b1 = new BSTSet(i);
        BSTSet b2 = new BSTSet(i2);
        
        b1.printBSTSet();
        b2.printBSTSet();

        b1.union(b2);
    }   
}