package StackQueues;

public class ReverseKChallenge {
    public static <V> void reverseK(Queue<V> queue, int k) {
        // Write -- Your -- Code
        Stack<V> stack = new Stack<V>(k);
        Queue<V> q = new Queue<>(queue.getMaxSize() - k);
        for(int i = 0; i < k; i++){
            stack.push(queue.dequeue());
        }
        for(int i = 0; i < queue.getMaxSize() - k; i++){
            q.enqueue(queue.dequeue());
        }
        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        while(!q.isEmpty()){
            queue.enqueue(q.dequeue());
        }
    }

    public static void main(String args[]) {

        Queue<Integer> queue = new Queue<Integer>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        reverseK(queue,5);

        System.out.print("Queue: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
