import java.util.*;
import java.lang.StringBuffer;
public class MaxMinHeap {
    public static void main(String []args){
        MaxHeap heap = new MaxHeap();
        heap.add(new Node(8));
        heap.print();

    }

    public static class MaxHeap {
        ArrayList<Node> nodes;
        MaxHeap(){
            nodes = new ArrayList();
            nodes.add(new Node());
            nodes.add(new Node(6));
            nodes.add(new Node(4));
        }
        public void add(Node n){
            //Nodes parent == 1
            nodes.add(n);
            //Traverse up the parent until parent is null
            int parent = (nodes.size()-1)/2;
            System.out.println("Parent: "+parent);
            System.out.println("Parent Val: "+nodes.get(parent).val);
            while(parent > 0 &&  n.val > nodes.get(parent).val){
                //Swap parent and current
                Node temp = nodes.get(parent);
                nodes.set(parent,n);
                nodes.set(nodes.size()-1,temp);
                parent = parent/2;
                System.out.println("Performing swap!");
            }

        }

        public void print(){
            System.out.println("Nodes size: "+nodes.size());
            System.out.print("Null ");
            for(int i = 1; i < nodes.size(); i++){
                System.out.print(nodes.get(i).val + " ");
            }
            System.out.println("");
        }
    }


    public static class Node{
        int val;
        Node left;
        Node right;
        int numChildren = 0;
        Node(int v){
            val = v;
        }
        Node(){
        }
    }
}
