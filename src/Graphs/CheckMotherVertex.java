package Graphs;

import java.util.Arrays;

public class CheckMotherVertex {

    /*
    * Using dfs to traverse all edges and compute the in-degree and out-degree of each node
    *
    * */

    public static int findMotherVertex(Graph g){
        // Write - Your - Code
        int[] indegree = new int[g.vertices];
        int[] outdegree = new int[g.vertices];
        boolean[] isVisited = new boolean[g.vertices];
        for(int i = 0; i < g.vertices; i++){
            if(!isVisited[i]){
                dfs(g, isVisited, indegree, outdegree, -1, i);
            }
        }
        System.out.println(Arrays.toString(indegree));
        System.out.println(Arrays.toString(outdegree));
        for(int i = 0; i < g.vertices; i++){
            if(indegree[i] > 0 && outdegree[i] > 0){
                return i;
            }
        }
        return -1;
    }

    public static void dfs(Graph g, boolean[] isVisited, int[] indegree, int[] outdegree, int prev, int cur){
        System.out.println("prev: " + prev);
        System.out.println("cur: " + cur);
        if(prev != -1){
            if(!isVisited[prev])
                outdegree[prev]++;
            indegree[cur]++;
        }
        isVisited[cur] = true;
        System.out.println(Arrays.toString(outdegree));
        System.out.println(Arrays.toString(indegree));
        DoublyLinkedList.Node headNode = g.adjacencyList[cur].getHeadNode();
        DoublyLinkedList.Node currNode = headNode;
        prev = cur;
        while(currNode != null){
            if(!isVisited[(int)currNode.data]){
                cur = (int)currNode.data;
                dfs(g, isVisited, indegree, outdegree, prev, cur);
            }
            prev = (int)currNode.data;
            currNode = currNode.nextNode;
        }
    }

    public static void main(String args[]) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));

    }
}
