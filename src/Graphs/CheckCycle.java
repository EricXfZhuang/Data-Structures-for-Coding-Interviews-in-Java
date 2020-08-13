package Graphs;

import StackQueues.Queue;

public class CheckCycle {
    public static boolean detectCycle(Graph g){
        // Write -- Your -- Code
        boolean[] isVisited = new boolean[g.vertices];
        boolean[] recStack = new boolean[g.vertices];

        for(int i = 0; i < g.vertices; i++){
            if(dfs(isVisited, recStack, g, i)){
                return true;
            }
        }

        return false;
    }

    public static boolean dfs(boolean[] isVisited, boolean[] recStack, Graph g, int v){
        if(recStack[v]){
            return true;
        }

        if(isVisited[v]){
            return false;
        }

        isVisited[v] = true;
        recStack[v] = true;

        DoublyLinkedList.Node head = g.adjacencyList[v].getHeadNode();
        DoublyLinkedList.Node curr = head;

        while(curr != null){
            if(dfs(isVisited, recStack, g, (int)curr.data)){
                return true;
            }
            curr = curr.nextNode;
        }

        recStack[v] = false;

        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}
