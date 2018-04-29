import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class Merge {
    Queue queue;
    public Merge(){
        queue = new Queue();
        queue.enqueue(new Node(3));
        queue.enqueue(new Node(13));
        queue.enqueue(new Node(31));
        queue.enqueue(new Node(-3));
        queue.enqueue(new Node(23));
        initMerge(queue,0,queue.size()-1);
    }
    //3, 13, 31, -3, 23, 44, -1
    //0,  1,  2   3   4,  5   6
    public Queue initMerge(Queue nodes,int start, int end){
        if(nodes.size() == 1){
            return nodes;
        }
        else{
            //get left merge
            Queue left = initMerge(subset(nodes,start,end/2),start,end/2);
            Queue right = initMerge(subset(nodes,(end/2)+1,end),((end/2)+1),end);
            return merge(left,right,start,end);
        }
    }
    public void printNodes(Queue n){
        //for (int i = 0; i < n.size(); i++){
            //System.out.print(n.get(i).val+" ");
        //}
        //System.out.print("\n");
    }
    public Queue merge(Queue left, Queue right,int startIndex, int endIndex){
        Queue newBounds = new Queue();
        int leftStart = 0;
        int rightStart = 0;
        printNodes(left);
        printNodes(right);
        System.out.println("Left size: "+left.size());
        System.out.println("Right size: "+right.size());
        while(left != null && right != null){
            if(left.head.val < right.head.val){
                newBounds.enqueue(left.head);
                left.pop();
                System.out.println("Removing left");
                leftStart++;
            }
            else{
                newBounds.enqueue(right.head);
                right.pop();
                System.out.println("Removing right");

                rightStart++;
            }
        }
        if(left != null){
            newBounds.addAll(left);
        }
        else{
            newBounds.addAll(right);
        }
        for(int i = 0; i < newBounds.size(); i++){
           //////queue.set(startIndex+i,newBounds.get(i));
        }
        return queue;
    }

    public void printAll(){
        printNodes(queue);
    }

    public Queue subset(Queue n,int start, int end){
        ArrayList<Node> t = new ArrayList<>();
        for(int i = start; i <= end; i++){
            t.add(n.get(i));
        }
        return t;
    }

    public class Queue{
        Node head;
        Node tail;
        int size;
        
        public void enqueue(Node n){
            if(head == null){
                head = n;
            }
            else{
                tail.next = n;
                tail = tail.next;
            }
            size+=1;
        }
        
        public Node pop(){
            Node t = head;
            head = head.next;
            size-=1;
            return t;
        }
        
        public int size(){
            return size;
        }

        //public void

        public void addAll(Queue values){
            while(values != null){
                enqueue(values.head);
                values.head = values.head.next;
            }
        }

        public void set(int indexToSet, Node val){
            int i = 0;
            Node temp = head;
            while(i != indexToSet){
                temp = temp.next;
                i+=1;
            }

        }

        public Node get(int i){
            
        }
        
        
        
    }



}
