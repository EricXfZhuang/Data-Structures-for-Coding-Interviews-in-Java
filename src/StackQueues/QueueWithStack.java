package StackQueues;

public class QueueWithStack<V> {
    private Stack<V> stack1;
    private Stack<V> stack2;

    public QueueWithStack(int maxSize){
        // Write -- Your -- Code
        stack1 = new Stack<V>(maxSize);
        stack2 = new Stack<V>(maxSize);
    }

    public void enqueue(V value){
        // Write -- Your -- Code
        stack1.push(value);
    }
    public V dequeue(){
        // Write -- Your -- Code
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        V temp = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack2.pop();
    }
    public boolean isEmpty(){
        //Write -- Your -- Code
        return stack1.isEmpty();
    }
}
