package Labs.Lab_03;

public class BSTSet {

    private TNode root;

    // CONSTRUCTORS
    public BSTSet() {
        this.root = null;
    }
    
    public BSTSet(int[] input){
        for (int i = input.length-1; i >= 0 ; i--){ // BUBBLE SORT (n^2)
            for (int j = 1; j <= i; j++){
                if (input[j-1] > input[j]){
                    int temp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                }
            }
        }

        

        

        

        

        int rootVal =input[(0 + input.length)/2];
        this.add(rootVal);
        
        for (int i = 0; i < input.length; i++){
            
            System.out.println("Bdruh");
            this.add(input[i]);
            System.out.println("Basddruh");
            
        }

        
        



    }

    public boolean isIn(int v){ // Binary Search
        if (this.root == null){return false;}
        if (this.root.element == v){return true;}
        
        TNode t = search(this.root, v);

        
        if (t!= null && t.element == v){
            return true;
        }

        return false;
        

        
    }

    public void add(int v){
        TNode tmp = this.root;
        TNode node = new TNode(v,null,null);
        
        if (root == null){
            root = node;
            System.out.println("1");
        }
        
        TNode prev = null;
        while (tmp!=null){
            prev = tmp;
            if (tmp.element < v)
                tmp = tmp.right;
            else {tmp = tmp.left;}
        }

        if (prev.element < v){
            prev.right = node;
        }
        else {
            prev.left = node;
        }

     
    }

    public boolean remove(int v){
        TNode r = search(this.root, v);

        return true;
    }


    public BSTSet union(BSTSet s){
        BSTSet u = new BSTSet();
        
        if (s.unionRec(this.root) == true); // check if 
        {
            //u.addAllToSet();
        }
        

        return u;
    }

    public boolean unionRec(TNode t){
        boolean isIn;

        if (t != null){
            unionRec(t.left);
            isIn = this.isIn(t.element); // check if any element exists inside the BSTSet

            if (isIn == true){
               return true;
            }
            unionRec(t.right);
        }

        return false;
    }



    public BSTSet intersection(BSTSet s){
        BSTSet i = new BSTSet();
        return null;
    }

    public BSTSet difference (BSTSet s){
        BSTSet d = new BSTSet();
        return null;
    }

    public int size(){
        while (this.root != null)
        {
           
        }
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
        if (root == null){
            System.out.print("The set is empty");
        }
        else {

        }
    }
    /*
    public  inOrder(TNode t){ // Non Recursive In-Order Traversal 
        if (t != null){
            inOrder(t.left);
            return t;
            inOrder(t.right);
        }
    }
    */

    public TNode search(TNode t, int v){
        if (t == null || t.element == v){
            return t;
        }

        if (t.element > v){
            return search(t.left, v);
    }
        return search(t.right, v);
    }


    
    public TNode insert(TNode head, int v){

        TNode tmp = head;
        TNode n = new TNode(v,null,null);

        if (head == null) { // check if node is empty
            head = new TNode(v,null,null); 
            return root;
        } 

        if (v < root.element){
            root.left = insert(root.left, v);
        }

        else if (v > root.element){
            root.right = insert(root.right, v);
        }

        /* return the (unchanged) node pointer */
        return root;

    }
    

}