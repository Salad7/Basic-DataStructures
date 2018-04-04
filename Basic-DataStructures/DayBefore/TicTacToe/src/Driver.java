public class Driver {

    public static void main(String[] args){
        Node[][] grid = new Node[3][3];
        setGrid(grid,new Node("x",0,0));
    }

    public static void setGrid(Node[][] grid,Node n){
        grid[n.getR()][n.getC()] = n;
    }

    public static void BFS(Node[][] grid, int selectedR, int selectedC){
        if(selectedR-1 > -1 && selectedC-1 > -1){

        }
        else if(selectedR-1 > -1){

        }
        else if(selectedR+1 < 3){

        }

    }

    public static class Queue {
        Node front;
        Node back;

        public Queue() {
        }

        public void enqueue(Node n){
            if(front == null){
                front = back = n;
            }
            else{
                back.setNext(n);
                back = back.getNext();
            }
        }

        public Node dequeue(){
            Node temp = front;
            front = front.getNext();
            return temp;
        }
    }

    public static class Node {
        String val;
        int r;
        int c;
        Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(String val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }

        public Node(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }


}
