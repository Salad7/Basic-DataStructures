import java.util.ArrayList;

public class Knapsack {

    static ArrayList<String> chains = new ArrayList<>();
    static Node[] sack = new Node[5];

    public static void main(String[] args){
        int capacity = 5;

        sack[0] = new Node(1,1);
        sack[1] = new Node(1,2);
        sack[2] = new Node(1,3);
        sack[3] = new Node(1,3);
        sack[4] = new Node(1,3);

        for(int i = 0; i < 5; i++){
            if(sack[i].getWeight() <= capacity) {
                //Add the l
                recursive(i, capacity-sack[i].getWeight(), sack[i].getValue(), i + "");
                //chains.add(i+"");
            }
        }

        for (String ch: chains
             ) {
                System.out.println(ch);
        }

    }

    public static void recursive( int position, int weightLeft, int value, String chain){
        //If were not at the end of the array
        //And the weight left after adding the node is greater then the 0
        if(position != sack.length-1 && weightLeft - sack[position].getWeight() > 0){
            //Try to add the next node
            recursive(position+1,weightLeft-sack[position].getWeight(),value+sack[position].getValue(),(chain+(position+1)));
        }
        chains.add(chain+"");
    }


    public static class Node {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
