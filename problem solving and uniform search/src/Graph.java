import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    HashMap <Node , LinkedList<Node>> adjacencyMap;
    boolean directed;

    Graph(boolean directed){
        adjacencyMap = new HashMap<>();
        this.directed = directed;
    }

    public void insertEdge(Node source, Node target ){
        if (!adjacencyMap.keySet().contains(source)){
            LinkedList<Node> tmp = new LinkedList <Node>();
            tmp.add(target);
            adjacencyMap.put(source,target);
        }else {
            LinkedList<Node> tmp = adjacencyMap.get(source);
            tmp.add(target);
            adjacencyMap.put(source,tmp);
        }
    }

    public void printEdge(){
        for(Node n :adjacencyMap.keySet()){
            System.out.print(n.getName()+":");
            if(adjacencyMap.get(n)!= null){
                LinkedList<Node> cities = adjacencyMap.get(n);
                for (Node c: cities){
                    System.out.println(c.getName()+",");
                }
            }
        }
    }
}
