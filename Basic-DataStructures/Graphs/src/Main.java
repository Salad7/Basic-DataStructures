import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){



        int[][] no = {{0,1,0,0,0,0},{0,0,1,0,0,0},{0,0,0,1,0,0},{0,0,0,0,1,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        Node[] nodes = {new Node("Mohamed"),new Node("James"),new Node("Cody"),new Node("Sam"),new Node("Nick"),new Node("Andrew")};
        nodes = getGraph(nodes,no);
        System.out.println(traverse(nodes[0],nodes[5]));




    }

    public static Node[] getGraph(Node[] nodes, int[][] coors){
        for(int i = 0; i < nodes.length; i++){
            for(int x =0; x < nodes.length; x++) {
               if(coors[i][x] == 1){
                   nodes[i].connections.add(nodes[x]);
               }
            }
        }
        return nodes;
    }

//    public static boolean initGraph(Node start,Node find,Node[] graph){
//        if(start.name.equals(find.name)){
//            return true;
//        }
//        else{
//            start.isVisited = true;
//            return traverse(start,find,graph);
//        }
//    }
    public static boolean traverse(Node start,Node find){
        if(start.name.equals(find.name)){
            return true;
        }
        start.isVisited = true;
        for (Node connection: start.connections
             ) {
            if(!connection.isVisited){
                return traverse(connection,find);
            }
        }
        return false;
    }


}
