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
        if (adjacencyMap.containsKey(source)){
            LinkedList<Node> tmp = adjacencyMap.get(source);
            tmp.add(target);
            adjacencyMap.replace(source,tmp);
        }else {
            LinkedList<Node> tmp = new LinkedList <Node>();
            tmp.add(target);
            adjacencyMap.put(source,tmp);
        }
    }

    public void printEdge(){
        for(Node n :adjacencyMap.keySet()){
            System.out.println( "city close to " +n.getName()+":");
            if(adjacencyMap.get(n)!= null){
                System.out.println();
                LinkedList<Node> cities = adjacencyMap.get(n);
                for (Node c: cities){
                    System.out.print(c.getName()+",");
                }
                System.out.println();
            }
        }
    }


    public static Graph defaultGraphOfCity(Node[]nodes){
        /*
        how this works is i have a array of nodes and from cityReader i will 2d array
        of n*2 size where is the number of pair of adjacent city where
        str[k][0] will be the source and  str[k][1] be the destination

         */

    }

}
