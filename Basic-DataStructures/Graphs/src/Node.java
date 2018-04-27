import java.util.ArrayList;

public class Node {
    ArrayList<Node> connections;
    String name;
    boolean isVisited;

    public Node(String name) {
        this.name = name;
        connections = new ArrayList<>();
        isVisited = false;
    }



}
