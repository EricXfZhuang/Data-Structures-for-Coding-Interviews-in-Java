package Graphs;

/**
 * @Author EricZhuang
 * @Date 2020/8/16
 */
public class CheckPaths {
    public static boolean checkPath(Graph g, int source, int destination) {
        // Write - Your - Code
        boolean[] visited = new boolean[g.vertices];
        return dfsUtil(g, source, destination, visited);
    }

    public static boolean dfsUtil(Graph g, int root, int dest, boolean[] visited){
        if(root == dest){
            return true;
        }

        visited[root] = true;

        DoublyLinkedList<Integer>.Node head = g.adjacencyList[root].getHeadNode();

        while(head != null){
            if(!visited[head.data]) {
                if(dfsUtil(g, head.data, dest, visited)){
                    return true;
                }
            }
            head = head.nextNode;
        }

        return false;
    }

    public static void main(String args[]) {

        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }
}
