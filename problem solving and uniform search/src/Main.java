public class Main {
    public static void main(String[] args) {

        Node n1 = new Node(1,"Arad");
        Node n2 = new Node(2,"Zerind");
        Node n3 = new Node(3,"Timisoara");

        Graph graph = new   Graph(false);
        graph.insertEdge(n1,n2);
        graph.insertEdge(n1,n3);
        graph.printEdge();

    }
}