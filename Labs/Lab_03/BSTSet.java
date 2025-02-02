package Labs.Lab_03;

public class BSTSet {

    private TNode root;

    // CONSTRUCTORS
    public BSTSet() {
        this.root = null;
    }

    public BSTSet(int[] input) {

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
        
        if (!this.isIn(v)){ // if its not in the function, remove
            return false;
        }

        deleteKey(root, v);
        return true;
    }

    private TNode deleteKey(TNode curr, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (curr == null)  return curr; 
  
        /* Otherwise, recur down the tree */
        if (key < curr.element) 
            curr.left = deleteKey(curr.left, key); 
        else if (key > curr.element) 
            root.right = deleteKey(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (curr.left == null) 
                return curr.right; 
            else if (curr.right == null) 
                return curr.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            curr.element = minValue(curr.right); 
  
            // Delete the inorder successor 
            root.right = deleteKey(curr.right, root.element); 
        } 
  
        return curr; 
    } 

    int minValue(TNode n) 
    { 
        int minV = n.element; 
        while (n.left != null) 
        { 
            minV = n.left.element; 
            root = n.left; 
        } 
        return minV; 
    } 



    public BSTSet union(BSTSet s) {
        BSTSet u = new BSTSet();
        
        this.union(root, u);
        this.union(s.root, u);
        return u;
       
    }

    private void union(TNode curr, BSTSet u){
        if (curr != null) {

            u.add(curr.element);
            this.union(curr.left, u);
            this.union(curr.right,u);
        }
    }


    public BSTSet intersection(BSTSet s) {
        BSTSet i = new BSTSet();

        intersect(s.root, i, this, s);
        intersect(root, i, this, s);
        return i;
    }

    private void intersect(TNode curr, BSTSet i, BSTSet s1, BSTSet s2)
    {
        if(curr != null)
        {
    
            
            if(s1.isIn(curr.element) && s2.isIn(curr.element))
                i.add(curr.element);

            intersect(curr.left, i, s1, s2);
            intersect(curr.right, i, s1, s2);
        }
        
    }

    public BSTSet difference(BSTSet s) {
        BSTSet d = new BSTSet();

        diff (root, d, this, s); // helper function call
        return null;
    }

    private void diff(TNode curr, BSTSet d, BSTSet s1, BSTSet s2){
        if (curr != null){

            if (s2.isIn(curr.element) && !s2.isIn(curr.element)){
                d.add(curr.element);
            }
            
            diff (curr.left, d, s1, s2);
            diff (curr.right, d, s1, s2);
            
        }
    }

    public int size() {
        return getSize(root);
        
    }

    private int getSize(TNode curr){
		if(curr==null){
			return 0;
		}
		return 1 + getSize(curr.left) + getSize(curr.right);
	}


    public int height() {
        if (root == null){
            return -1;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        // returns the largest value for height
        if(l > r)
            return l;
        else
            return r;
        
    }

    public int depth(TNode n)
    {
        if(n == null)
        {
            return -1;
        }
        int l = depth(n.left);
        int r = depth(n.right);
        
        if(l > r)
            return l +1;
        else
            return r+1;
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

            MyStack <TNode> s = new MyStack();
            TNode curr = this.root;

        while(curr != null || !s.isEmpty())
        {
            while(curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.top();
            System.out.print(curr.element + ", ");
            curr = curr.right;
            s.pop();
        }
        
        }
        System.out.println("\n");
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