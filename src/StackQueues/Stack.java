package StackQueues;

/**
 * @Author EricZhuang
 * @Date 2020/8/10
 */
public class Stack<E> {
    private int maxSize;
    private int top;
    private E arr[];

    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.top = -1;
        arr = (E[]) new Object[maxSize];
    }

    public int getCapacity(){
        return this.maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public E top(){
        if(isEmpty()){
            return null;
        }
        return arr[top];
    }

    public void push(E value){
        if(isFull()){
            System.err.println("Stack is Full");
            return;
        }
        arr[++top] = value;
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        return arr[top--];
    }
}
