public class BinarySearchTree {


    public static void main(String[] args){
        BST bst = new BST();
        bst.add(new Node(4));
        bst.add(new Node(2));
        bst.add(new Node(71));
        bst.add(new Node(15));
        bst.printIn();

    }

    public static class BST{

        Node root;

        public void printIn(){
            recursivePrint(root);
        }
        public void recursivePrint(Node n){

                if(n.leftChild != null){
                    recursivePrint(n.leftChild);
                }
                System.out.println(n.getVal());
            if(n.rightChild != null){
                recursivePrint(n.rightChild);
            }
        }

        public void add(Node n){
            if (root == null){
                root = n;
            }
            else {
                recursiveTraverse(root,n);
            }
        }

        public void recursiveTraverse(Node current, Node n){
            if(n.getVal() > current.getVal()){
                if(current.rightChild == null){
                    current.rightChild = n;
                }
                else{
                    recursiveTraverse(current.rightChild,n);
                }
            }
            else if(current.leftChild == null){
                current.leftChild = n;
            }
            else{
                recursiveTraverse(current.leftChild,n);
            }
        }

    }

    public static class Node {
        int val;
        Node leftChild;
        Node rightChild;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node(int val) {
            this.val = val;
        }


    }

}