package Graphs;

public class Graph {
    int vertices; //Total number of vertices in graph
    DoublyLinkedList<Integer>[] adjacencyList; //An array of linked lists to store adjacent vertices.

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new DoublyLinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){
        if(source >= 0 && source < vertices && destination >= 0 && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }

    void printGraph(){
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    } //Prints Graph (Adjaceny List)

    /*
    *               0
    *              / \
    *             v   v
    *             1   2
    *             \   /
    *              v v
    *               3
    * */

    public static void main( String args[] ) {
        Graph g= new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.printGraph();
    }
}
