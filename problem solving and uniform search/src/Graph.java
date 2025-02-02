import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    HashMap <Node , LinkedList<Node>> adjacencyMap;
    boolean directed;
    path cityPath;

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
                LinkedList<Node> cities = adjacencyMap.get(n);
                for (Node c: cities){
                    System.out.print(c.getName()+",");
                }
                System.out.println("\n");
            }
        }
    }

    public static Graph defaultGraphOfCity(Node[]nodes){
        /*
        how this works is i have a array of nodes and from cityReader i will 2d array
        of n*2 size where is the number of pair of adjacent city where
        str[k][0] will be the name of source and  str[k][1] be the name of destination
        searching them in nodes we will find the respective nodes and
        then inserting edges using tempGraph.

         */
        Graph tempGraph =new Graph(false);
        String[][] adjacentCity = cityReader.defaultAdjecentCity();
        Node source, destination;

        for (String[] strings : adjacentCity) {

            source = Node.getNode(strings[0], nodes);
            destination = Node.getNode(strings[1], nodes);

            tempGraph.insertEdge(source, destination);
        }
        return tempGraph;
    }

    public void implementationOfDFS(Node source , Node destination){

        this.cityPath = new path();

        DFS(source,destination );

        System.out.println("city visited ");
        for (Node n : cityPath.getVisitedNode()){
            System.out.println(n.getName());
        }

        System.out.println("\n\nthe path it followed is ");
        for (Node n : cityPath.getPath()){
            System.out.println(n.getName());
        }
    }

    public void DFS(Node source, Node destination){
        cityPath.pushPath(source);
        cityPath.setVisitedNode(source);
        //destination has just reached
        if (source == destination){
            cityPath.setDestinationReached();
            return;
        }
        //destination has not reached
        if(adjacencyMap.get(source) != null){

            LinkedList<Node> adjCities = adjacencyMap.get(source);
            for (Node city : adjCities){
                if(!cityPath.isVisitedNode(city)){

                    DFS(city,destination);
                    if (cityPath.isDestinationReached()){
                        return;
                    }
                    cityPath.pullPath();
                }
            }
        }
    }

    public void implementationOBFS(Node source, Node destination){
        this.cityPath = new path();

        BFS(source,destination);

        System.out.println("city visited ");
        for (Node n : cityPath.getVisitedNode()){
            System.out.println(n.getName());
        }


    }

    public void BFS(Node source,Node destination){

        //destination has not reached
        cityPath.pushPath(source);
        cityPath.setVisitedNode(source);
        LinkedList<Node> queue = new LinkedList<>(adjacencyMap.get(source));

        while (!queue.isEmpty()){
            //destination reached
            if(source == destination){
                return;
            }
            source = queue.removeFirst();


            if(!cityPath.isVisitedNode(source)){
                cityPath.pushPath(source);
                cityPath.setVisitedNode(source);
                for (Node n : adjacencyMap.get(source)){
                    if((!cityPath.isVisitedNode(n)) && (!queue.contains(n))){
                        queue.add(n);
                    }
                }
            }
        }
    }

}
