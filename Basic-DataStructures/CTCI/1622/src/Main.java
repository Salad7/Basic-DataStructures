import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static HashMap<String, Node> map = new HashMap<>();
    static ArrayList<Node> totalMoves;

    public static void main(String[] args){
        init();
        totalMoves = new ArrayList<>();
    }

    public static void init(){
        Node n = new Node(0,0,0,"R"); //Current Direction
        totalMoves = new ArrayList<>();
        //map.put("00",n);
        //totalMoves.add(n);
        step(0,0,6,n);
    }
    public static void printBoard(){
        System.out.println("Board Size: "+totalMoves.size());
        for (Node f: totalMoves
             ) {
            System.out.println("Row: "+f.row+" Col: "+f.col+" Color: "+f.getStringColor()+" Direction: "+f.getDirection());
        }
    }
    public static void step(int row, int col,int moves, Node old){
        Node n = null;
        if(moves == 0){
            //finish
            printBoard();
            return;
        }
        else if(map.containsKey(row+""+col)){
            n = map.get(row+""+col);
        }
        else{
            n = new Node(row,col,0,old.getDirection());
            map.put(row+""+col,n);
            //if(!totalMoves.contains(n)){
//                totalMoves.add(n);
            //}

        }
        //totalMoves.add(n);
        if(!totalMoves.contains(n)){
                totalMoves.add(n);
        }
        n.flipColor();
        n.moveDirection();
        if(n.getDirection().equals("U")){
            step(row-1,col,moves-1,n);
        }
        else if(n.getDirection().equals("R")){
            step(row,col+1,moves-1,n);

        }
        else if(n.getDirection().equals("L")){
            step(row,col-1,moves-1,n);

        }
        else{
            //go down
            step(row+1,col,moves-1,n);
        }
    }
}
