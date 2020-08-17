package Graphs;

import java.util.Arrays;

/**
 * @Author EricZhuang
 * @Date 2020/8/16
 */
public class CheckTree {
    public static boolean isTree(Graph g){
        if(containCycle(g)){
            return false;
        }

        if(!isConnected(g)){
            return false;
        }

        if(checkOneParent(g)){
            return false;
        }

        return true;
    }

    public static boolean checkOneParent(Graph g){
        int[] parents = new int[g.vertices];
        boolean[] visited = new boolean[g.vertices];
        Arrays.fill(parents, -1);
        for(int i = 0; i < g.vertices; i++){
            if(!visited[i]){
            }
        }
        return false;
    }

    public static boolean checkOneParent(Graph g, int v, int parent, int[] parents, boolean[] visited){
        visited[v] = true;

        if(parents[v] != -1 && parents[v] != parent){
            return false;
        }

        DoublyLinkedList<Integer>.Node curr = g.adjacencyList[v].getHeadNode();
        parents[v] = parent;
        int temp = parent;
        while(curr != null){
            if(!visited[v]){
                if(!checkOneParent(g, curr.data, temp, parents, visited)){
                    return false;
                }
            }
            temp = curr.data;
            curr = curr.nextNode;
        }
        return true;
    }

    public static boolean isConnected(Graph g){
        for(int i = 0; i < g.vertices; i++){
            boolean[] visited = new boolean[g.vertices];
            dfs(g, visited, i);
            if(allVisited(visited)){
                return true;
            }
        }
        return false;
    }

    public static void dfs(Graph g, boolean[] visited, int v){
        visited[v] = true;

        DoublyLinkedList<Integer>.Node curr = g.adjacencyList[v].getHeadNode();

        while(curr != null){
            if(!visited[v]){
                dfs(g, visited, curr.data);
            }
        }
    }

    public static boolean allVisited(boolean[] visited){
        for(boolean b : visited){
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static boolean containCycle(Graph g){
        boolean[] visited = new boolean[g.vertices];
        boolean[] recStack = new boolean[g.vertices];

        for(int i = 0; i < g.vertices; i++){
            if(!visited[i]){
                if(detectCycle(g, i, visited, recStack)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycle(Graph g, int v, boolean[] visited, boolean[] recStack){
        if(recStack[v]){
            return true;
        }

        if(visited[v]){
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        DoublyLinkedList<Integer>.Node curr = g.adjacencyList[v].getHeadNode();

        while(curr != null){
            if(!visited[curr.data]){
                if(detectCycle(g, curr.data, visited, recStack)){
                    return true;
                }
            }
        }

        recStack[v] = false;

        return false;
    }
}
