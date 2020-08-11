package StackQueues;

public class Queue<E> {
    private int maxSize;
    private int front;
    private int back;
    private E[] arr;
    private int currentSize;

    public Queue(int maxSize){
        arr = (E[]) new Object[maxSize];
        this.maxSize = maxSize;
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public E top(){
        return arr[front];
    }

    public void enqueue(E value){
        if(isFull()){
            return;
        }
        back = (back + 1) % maxSize;
        arr[back] = value;
        currentSize++;
    }

    public E dequeue(){
        if(isEmpty()){
            return null;
        }
        E value = arr[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return value;
    }

}
