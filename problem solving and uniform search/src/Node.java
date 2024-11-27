import java.util.LinkedList;

public class Node extends LinkedList<Node> {
    int nodeID;
    String name;
    boolean visited;

    public Node(int nodeID, String  name){
        this.nodeID = nodeID;
        this.name = name;
        visited = false;
    }
}
