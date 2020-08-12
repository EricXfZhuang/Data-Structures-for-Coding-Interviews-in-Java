package Graphs;

public class CheckBFS {
    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        String result = "";

        // Write - Your - Code
        boolean[] isVisited = new boolean[g.vertices];
        for(int i = 0; i < g.vertices; i++){
            if(!isVisited[i])
                result += i;
                result += bfs("", g, g.adjacencyList[i].getHeadNode(), isVisited);
            isVisited[i] = true;
        }
        return result;
    }

    public static String bfs(String result, Graph g, DoublyLinkedList.Node root, boolean[] isVisited){
        String temp = "";
        if(root == null || isVisited[(int)root.data]){
            return "";
        }
        DoublyLinkedList.Node curr = root;
        while(curr != null){
            if(!result.contains(String.valueOf(curr.data)) && !temp.contains(String.valueOf(curr.data)))
                temp += curr.data;
            curr = curr.nextNode;
        }
        result += temp;
        curr = root;
        while(curr != null){
            isVisited[(int)curr.data] = true;
            temp = bfs("", g, g.adjacencyList[(int)root.data].getHeadNode(), isVisited);
            result += temp;
            curr = curr.nextNode;
        }
        return result;
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
