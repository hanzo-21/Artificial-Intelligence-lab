
import java.util.LinkedList;

public class path {
    LinkedList<Node> path = new LinkedList<>();
    LinkedList<Node> visitedNode = new LinkedList<>();
    boolean destinationReached;

    path(){
        path.clear();
        visitedNode.clear();
        destinationReached =false;
    }

    public void pushPath(Node node){
        path.offer(node);
    }

    public void pullPath(){
        path.poll();
    }

    public LinkedList<Node> getPath(){
        return path;
    }

    public void setVisitedNode(Node node){
        visitedNode.add(node);
    }

    public boolean isVisitedNode(Node n){
        return visitedNode.contains(n);
    }

    public boolean isDestinationReached(){
        return destinationReached;
    }

    public void setDestinationReached(){
        destinationReached= true;
    }
}
