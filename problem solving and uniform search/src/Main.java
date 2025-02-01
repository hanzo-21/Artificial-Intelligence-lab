public class Main {
    public static void main(String[] args) {

        Node[] nodes = Node.defaultInitial();

        //Node.displayIdOfCity(nodes);

        Graph graph = new   Graph(false);

        graph = Graph.defaultGraphOfCity(nodes);

        //graph.printEdge();

        Node source = Node.getNode("Arad",nodes);
        Node destination = Node.getNode("Neamt",nodes);

        graph.implementationOfDFS(source,destination);

    }
}