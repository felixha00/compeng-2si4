package Labs.Lab_03;

public class BSTSet {

    private TNode root;

    // CONSTRUCTORS
    public BSTSet() {
        this.root = null;
    }

    public BSTSet(int[] input) {
        for (int i = input.length - 1; i >= 0; i--) { // BUBBLE SORT (n^2)
            for (int j = 1; j <= i; j++) {
                if (input[j - 1] > input[j]) {
                    int temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }
            }
        }

        int rootVal = input[(0 + input.length) / 2]; // get middle of array
        this.add(rootVal);

        for (int i = 0; i < input.length; i++) {
            if (!this.isIn(input[i])) { // check if not already in the tree
                this.add(input[i]);
            }

        }

    }

    public boolean isIn(int v) { // Binary Search
        if (this.root == null) {
            return false;
        }
        if (this.root.element == v) {
            return true;
        }

        TNode t = search(this.root, v);

        if (t != null && t.element == v) {
            return true;
        }

        return false;

    }

    public void add(int v) {

        if (this.isIn(v)){
            return;
        }
        TNode node = new TNode(v, null, null);

        // if tree is empty
        if (root == null) {
            root = node;

        } else {
            TNode current = root; // initialize current node
            TNode parent = null;

            while (true) {
                parent = current; // goes down tree and sets the parent every iteration

                
                if (v < parent.element) { // go to left of the tree
                    current = current.left;
                    // insert to the left

                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } // go to right of the tree
                else {
                    current = current.right;

                    // insert to the right
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }

        /*
         * TNode tmp = this.root; TNode node = new TNode(v,null,null);
         * 
         * if (root == null){ root = node; System.out.println("1"); }
         * 
         * TNode prev = null; while (tmp!=null){ prev = tmp; if (tmp.element < v) tmp =
         * tmp.right; else {tmp = tmp.left;} }
         * 
         * if (prev.element < v){ prev.right = node; } else { prev.left = node; }
         */

    }

    public boolean remove(int v) {
        TNode r = search(this.root, v); // returns the node where the removal is

        if (!this.isIn(v)){ // if its not in the function, remove
            return false;
        }

        TNode node = new TNode(v, null, null);

        // if tree is empty
        if (root == null) {
            root = node;

        } else {
            TNode current = root; // initialize current node
            TNode parent = null;

            while (true) {
                parent = current; // goes down tree and sets the parent every iteration

                if (v < parent.element) { // go to left of the tree
                    
                    current = current.left;
                    // insert to the left

                    /*
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                    */
                } // go to right of the tree
                
                else {
                    current = current.right;

                    // insert to the right
                    if (current == null) {
                        parent.right = node;
                        
                    }
                }
            }
        }

        return true;
    }

    public BSTSet union(BSTSet s) {
        BSTSet u = new BSTSet();
        
        TNode current = root;
        TNode parent = null;

        if (s.unionRec(this.root) == true){
            System.out.println("BruhTrue");
        }
        else {
            System.out.println("False");
        }

        return null;
    
    }

    public boolean unionRec(TNode t) {
        boolean isIn;

        if (t != null) {
            unionRec(t.left);
            isIn = isIn(t.element); // check if any element exists inside the BSTSet
            System.out.println(t.element);
            if (isIn == true) {
                return true;
            }
            unionRec(t.right);
        }

        return false;
    }

    public BSTSet intersection(BSTSet s) {
        BSTSet i = new BSTSet();
        return null;
    }

    public BSTSet difference(BSTSet s) {
        BSTSet d = new BSTSet();
        return null;
    }

    public int size() {
        if (root == null){
            return 0;
        }

        return 1;
    }

    public int height() {
        if (root == null){
            return 0;
        }
        return 1;
        
    }

    public void printBSTSet() {
        if (root == null) {
            System.out.print("The set is empty");

        } else {
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }

    private void printBSTSet(TNode t) {
        if (t != null) {
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }

    public void printNonRec() {
        if (root == null) {
            System.out.print("The set is empty");
        } else {

        }   
    }

    public TNode search(TNode t, int v) {
        if (t == null || t.element == v) {
            return t;
        }
        if (t.element > v) { // if the element is greater, call it recursively
            return search(t.left, v);
        }
        return search(t.right, v);
    }

    
}