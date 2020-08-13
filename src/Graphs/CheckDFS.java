package Graphs;

public class CheckDFS {
    //Depth First Traversal of Graph g
    public static String dfs(Graph g) {
        String result = "";

        // Write - Your - Code
        boolean[] isVisited = new boolean[g.vertices];
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < g.vertices; i++){
            if(!isVisited[i])
                dfs(g, isVisited, str, i);
        }
        result = str.toString();
        return result;
    }

    /*
    * 1. mark the root as visited
    * 2. pick a child
    * 3. check if it is visited
    * 4. if not traverse the children of the node
    * 5. else visit next child of the root
    *
    * */
    public static void dfs(Graph g, boolean[] isVisited, StringBuilder str, int v){
        isVisited[v] = true;
        str.append(v);
        DoublyLinkedList.Node head = g.adjacencyList[v].getHeadNode();
        DoublyLinkedList.Node curr = head;
        while(curr != null){
            if(!isVisited[(int)curr.data]){
                dfs(g, isVisited, str, (int)curr.data);
            }
            curr = curr.nextNode;
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
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
