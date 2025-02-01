public class Main {
    public static void main(String[] args) {

        Node[] nodes = Node.defaultInitial();

        Node.displayIdOfCity(nodes);

        Graph graph = new   Graph(false);

        graph = Graph.defaultGraphOfCity(nodes);

        graph.printEdge();

    }
}