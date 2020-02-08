public class BSTSet {

    private TNode root;

    // CONSTRUCTORS
    public BSTSet() {
        this.root = null;
    }

    public BSTSet(int[] input){

    }

    public boolean isIn(int v){
        return true; 
        
    }

    public void add(int v){
        
    }

    public boolean remove(int v){
        return true;
    }

    public BSTSet union(BSTSet s){
        return null;
    }

    public BSTSet intersection(BSTSet s){
        return null;
    }

    public BSTSet difference (BSTSet s){
        return null;
    }

    public int size(){
        return 1;
    }

    public int height(){
        return 1;
    }

    public void printBSTSet(){
        if (root==null){
            System.out.print("The set is empty");

        }
        else {
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }

    private void printBSTSet(TNode t){
        if (t != null){
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }

    public void printNonRec(){
        
    }
}