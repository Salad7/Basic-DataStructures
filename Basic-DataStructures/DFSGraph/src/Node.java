import java.util.ArrayList;

public class Node {
    int val;
    boolean isVisited;
    ArrayList<Node> connenctions;

    public Node(int v){
        connenctions = new ArrayList<>();
        val = v;
    }
}
