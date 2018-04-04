public class Queue {



    public static void main(String[] args){
        QueueDS queueDS = new QueueDS();
        queueDS.enqueue(new Node(1));
        queueDS.enqueue(new Node(2));
        queueDS.enqueue(new Node(3));
        queueDS.print();
        System.out.println(queueDS.dequeue());
        System.out.println(queueDS.dequeue());



    }
    public static class QueueDS {
        Node back;
        Node front;

        public void print(){
            Node temp = front;
            while(temp != null){
                System.out.println(temp.getVal());
                temp = temp.getN();
            }
        }
        public void enqueue(Node n) {
            if(front == null){
                front = back = n;
            }
            else{
                back.setN(n);
                back = back.getN();
            }
        }

        public int dequeue(){
            if(front == null){
                return 0;
            } else{
                int v = front.getVal();
                front = front.getN();
                return v;
            }
        }




    }

    public static class Node {
    int val;
    Node n;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getN() {
            return n;
        }

        public void setN(Node n) {
            this.n = n;
        }

        public Node(int val) {
            this.val = val;
        }
    }

}




