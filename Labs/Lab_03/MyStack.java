package Labs.Lab_03;

/**
 * MyStack
 */
public class MyStack<E> {
    
    private int top;
    private E[] vals;


    public MyStack() {
        top = -1;
    }   

    public boolean push(int x){
        
    }

    public E pop(){

        if (top < 0){
            return 0;
        }
        else {
  
            return vals[top--];
        }

    }

    public boolean isEmpty() {
         return (top < 0);
    }
    public E top()  {
        return null;
    }

    public E peek(){
        if (isEmpty()){
            return null;
        }

        else {
            return vals[top];
        }
    }
}
