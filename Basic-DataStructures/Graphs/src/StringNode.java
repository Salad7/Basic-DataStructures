import java.util.ArrayList;

public class StringNode {
    ArrayList<StringNode> connections;
    String name;
    boolean isVisited;

    public StringNode(String name) {
        this.name = name;
        connections = new ArrayList<>();
        isVisited = false;
    }



}
