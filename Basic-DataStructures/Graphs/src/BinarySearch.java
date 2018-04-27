

public class BinarySearch {
    Node root;

    BinarySearch(){
        root = null;
    }

    public void beginBalancing(int[] vals){
        Node[] nodes = new Node[vals.length];
        for (int i = 0; i < vals.length; i++){
            nodes[i] = new Node(vals[i]);
        }
        balancer(nodes);
        inOrder(root,0);
    }
    public void balancer(Node[] nodes){
        int midIndex = nodes.length/2;
        if(nodes.length == 1){
            initAdd(nodes[0]);
        }
        else if(nodes.length == 2){
            initAdd(nodes[0]);
            initAdd(nodes[1]);
        }
        else{
            System.out.println(nodes.length);
            initAdd(nodes[midIndex]);
            Node[] left = new Node[midIndex];
            Node[] right = new Node[nodes.length-midIndex-1];
            for(int i = 0; i < right.length; i++){
                right[i] = nodes[midIndex+1+i];
            }
            for(int i = 0; i < left.length; i++){
                left[i] = nodes[i];
            }
            balancer(left);
            balancer(right);
        }


    }

    public void inOrder(Node start,int height){
        if(start.left != null){
            inOrder(start.left,height+1);
        }
        System.out.println("Height: "+ height+" Value: "+start.val);
        if(start.right != null){
            inOrder(start.right, height+1);
        }
    }

    public void initAdd(Node nodeToAdd){
            add(root,nodeToAdd);
    }
    public void add(Node current,Node n){
        if(root == null){
            root = n;
        }
        else{
            //If the incoming node is smaller then current
            if(n.val < current.val){
                //If the left side is not null then add the node
                if(current.left != null) {
                    add(current.left,n);
                }
                //Else traverse left and pass in current.left
                else{
                    current.left = n;
                }
            }
            //If the incoming node is greater then current
            if(n.val > current.val){
                //If the right side is not null then add the node
                if(current.right != null) {
                    add(current.right,n);
                }
                //Else traverse right and pass in current.left
                else{
                    current.right = n;
                }
            }
        }
    }



}
