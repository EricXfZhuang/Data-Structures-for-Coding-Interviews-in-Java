package Graphs;

public class Graph<DoublyLinkedList> {
    int vertices; //Total number of vertices in graph
    DoublyLinkedList<Integer> adjacencyList[]; //An array of linked lists to store adjacent vertices.

    void printGraph(); //Prints Graph (Adjaceny List)
    void addEdge(int source,int destination); //Adds an Edge from source vertex to destination vertex
}
