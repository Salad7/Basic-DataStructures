import java.util.ArrayList;

public class LongestPathInGraph {
    Node root;
    Node valToSearchFor;
    int pathsFound;
    ArrayList<Node> n;

    public LongestPathInGraph(){
        root = new Node(7);
        root.left = new Node(3);
        valToSearchFor = root.right = new Node(4);
        n = new ArrayList<>();
//        root.right.left = new Node(2);
//        root.right.right = new Node(1);

        System.out.println("Paths found: "+findPaths(root,n,0));
        printCurrentSums(n);
    }

    public static void printCurrentSums(ArrayList<Node> s){
        for (Node n: s
             ) {
            System.out.print(n.val+" -> ");
        }
    }
    public int findPaths(Node current,ArrayList<Node> sums, int hardSum){
        System.out.println("Called Recursive Function");
        if(current.val == valToSearchFor.val){
            System.out.println("Node is value: "+current.val);
            pathsFound+=1;
        }
        for(int i = 0; i < hardSum-1; i++){
            int tempVal = current.val+sums.get(i).val;
            System.out.print("Adding: "+current.val+" + "+sums.get(i).val+"\n");
            if(tempVal == valToSearchFor.val){
                System.out.println("Sum found: "+tempVal);
                pathsFound+=1;
            }
            sums.add(new Node(tempVal));
        }
        sums.add(current);
        System.out.println("Adding current: "+current.val+"\n");

        if(current.left != null){
            pathsFound += findPaths(current.left,sums,sums.size()+1);
        }
        if(current.right != null){
            pathsFound += findPaths(current.right,sums,sums.size()+1);
        }
        return pathsFound;
    }





}
