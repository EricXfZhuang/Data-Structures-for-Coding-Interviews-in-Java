package Graphs;

import StackQueues.Queue;

public class CheckBFS {
    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        String result = "";

        // Write - Your - Code
        boolean[] isVisited = new boolean[g.vertices];
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < g.vertices; i++){
            if(!isVisited[i])
                bfs(str, g, i, isVisited);
        }
        result = str.toString();
        return result;
    }

    public static void bfs(StringBuilder str, Graph g, int v, boolean[] isVisited){
        Queue<Integer> q = new Queue<>(g.vertices);
        isVisited[v] = true;
        q.enqueue(v);
        str.append(v);
        while(!q.isEmpty()){
            int s = q.dequeue();
            DoublyLinkedList.Node head = g.adjacencyList[s].getHeadNode();
            DoublyLinkedList.Node curr = head;
            while(curr != null){
                if(!isVisited[(int)curr.data]){
                    isVisited[(int)curr.data] = true;
                    str.append(curr.data);
                    q.enqueue((int)curr.data);
                }
                curr = curr.nextNode;
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
