public class BST {
    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node n = new Node(3);
        binarySearchTree.insert(new Node(3));
        binarySearchTree.insert(new Node(1));
        binarySearchTree.insert(new Node(-2));
        binarySearchTree.insert(new Node(2));
        binarySearchTree.insert(new Node(4));
        binarySearchTree.insert(new Node(5));
        System.out.println("In");
        binarySearchTree.in();
        System.out.println("Pre");
        binarySearchTree.pre();
        System.out.println("Post");
        binarySearchTree.post();



    }

    public static class BinarySearchTree{
        static Node root;
        BinarySearchTree(){
            root = null;
        }

        public void insert(Node n){
            boolean added = false;
            Node temp = root;
            if(root == null){
                root = n;
            }
            else{

                while(!added) {
                    if (n.val >= temp.val) {
                        if (temp.right == null) {
                            temp.right = n;
                            added = true;
                        }
                        else{
                            temp = temp.right;
                        }
                    }
                    if (temp.left == null) {
                        temp.left = n;
                        added = true;
                    }
                    else {
                        temp = temp.left;

                    }
                }

            }

        }
        public static void in(){
            printInOrder(root);
        }
        public static void pre(){
            printPreOrder(root);
        }
        public static void post(){
            printPostOrder(root);
        }

        public static void printInOrder(Node n){
            if(n != null){
                printInOrder(n.left);
                System.out.println(n.val);
                printInOrder(n.right);
            }
        }
        public static void printPreOrder(Node n){
            if(n != null){
                System.out.println(n.val);
                printInOrder(n.left);
                printInOrder(n.right);
            }
        }
        public static void printPostOrder(Node n){
            if(n != null){
                printInOrder(n.left);
                printInOrder(n.right);
                System.out.println(n.val);
            }
        }

    }
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int v){
            val = v;
            left = right = null;
        }
    }

}
