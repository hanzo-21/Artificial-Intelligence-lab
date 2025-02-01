import java.util.LinkedList;
import java.util.Objects;

public class Node   {
    int nodeID;
    String name;
    //boolean visited;

    public Node(){
        //visited=false;
    }
    /*
    public boolean isVisited(){
        return visited;
    }

     */

    public Node(int nodeID, String  name){
        this.nodeID = nodeID;
        this.name = name;
        //visited = false;
    }
    public String getName() {
        return name;
    }
    public int getId(){return nodeID;}

    public void markVisited(){
        //visited =true;
    }

    public static Node[] defaultInitial(){
        Node[] nodes = new Node[20];

        String[] cityName = cityReader.readCity();
        for (int i = 0; i < 20; i++) {
            nodes[i] = new Node(i, cityName[i]);
        }
        return nodes;

    }

    public static void displayIdOfCity(Node[] nodes){
        for(Node n : nodes){
            System.out.println(n.getId() + " = " + n.getName());
        }

    }

    public static Node getNode(String name , Node[]nodes){
        for(Node n : nodes){
            if (Objects.equals(name, n.getName())){
                return n;
            }
        }
        return new Node();
    }
}
