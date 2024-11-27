import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    HashMap <Node , LinkedList<Node>> adjacencyMap;
    boolean directed;

    Graph(boolean directed){
        this.directed = directed;
    }

    public void insertEdge(Node source, Node target ){
        if (!(adjacencyMap.keySet().contains(source))){
            LinkedList<Node> tmp = new LinkedList<Node>();
            tmp.add(target);
            adjacencyMap.put(source,target);
        }else {
            LinkedList<Node> tmp = adjacencyMap.get(source);
            tmp.add(target);
            adjacencyMap.put(source,tmp);
        }
    }
}
