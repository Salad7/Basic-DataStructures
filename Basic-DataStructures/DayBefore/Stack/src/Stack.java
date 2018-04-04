public class Stack {
    public static void main(String[] args){
        stackDS stackDS = new stackDS();
        stackDS.add(new Node(1));
        stackDS.add(new Node(2));
        stackDS.add(new Node(3));
        stackDS.print();
        System.out.println(stackDS.remove());

    }


    public static class stackDS {
        Node front;
        Node back;
        int size;

        public stackDS() {

        }

        public void print(){
            Node temp = front;
            while(temp != null){
                System.out.println(temp.getVal());
                temp = temp.getNext();
            }
        }

        public void add(Node n){
            if(size == 0){
                front = back = n;
            }
            else{
                n.setNext(front);
                front = n;
            }
            size+=1;

        }

        public int remove(){
            if(front == null){
                return 0;
            }
            else{
                size-=1;
                int temp = front.getVal();
                front = front.getNext();
                return temp;
            }
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node(int v) {
            next = null;
            val = v;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
