package Graphs;

import java.util.Arrays;

public class CheckMotherVertex {

    /*
    * Using dfs to traverse all edges and compute the in-degree and out-degree of each node
    *
    * */

    public static int findMotherVertex(Graph g){
        // Write - Your - Code
        // visited[] is used for DFS. Initially all are
        // initialized as not visited
        boolean[] visited = new boolean[g.vertices];
        Arrays.fill(visited, false);

        // To store last finished vertex (or mother vertex)
        int lastV = 0;

        // Do a DFS traversal and find the last finished vertex
        for (int i = 0; i < g.vertices; i++) {
            if (visited[i] == false) {
                dfs(g, i, visited);
                lastV = i;
            }
        }

        // If there exist mother vertex (or vetices) in given
        // graph, then lastV must be one (or one of them)

        // Now check if lastV is actually a mother vertex (or graph
        // has a mother vertex). We basically check if every vertex
        // is reachable from lastV or not.

        // Reset all values in visited[] as false and do
        // DFS beginning from lastV to check if all vertices are
        // reachable from it or not.
        Arrays.fill(visited, false);
        dfs(g, lastV, visited);

        for (int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                return -1;
            }
        }

        return lastV;
    }

    public static void dfs(Graph g, int v, boolean[] visited){
        visited[v] = true;
        DoublyLinkedList<Integer>.Node head = null;
        if(g.adjacencyList[v] != null){
            head = g.adjacencyList[v].getHeadNode();
        }

        while(head != null){
            if(!visited[head.data]){
                dfs(g, head.data, visited);
            }
            head = head.nextNode;
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
