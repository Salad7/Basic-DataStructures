public class LinkedList {

    Node head;
    Node last;



    LinkedList(){
        head = last = null;

    }

    public void addWithNumber(int n){
        Node node = new Node();
        node.setNum(n);
        add(node);
    }

    public void print(){
        Node temp = head;
        if(temp == null){
            System.out.print("Empty linked list");
        }else{
            System.out.print(temp.num + " ");
            while(temp.getNext() != null){
                System.out.print(temp.getNext().num + " ");
                temp = temp.getNext();
            }
        }
        System.out.print("\n");

    }

    public void add(Node n){
        Node temp = null;
        if(head == null){
            head = last = n;
        }else{
            temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(n);
            n.setPrev(temp);
            last = n;
        }

    }

    public Node remove(int val){
        Node temp = null;
        if(head == null){
            return null;
        }else{
            temp = head;
            while(temp.getNext() != null) {
                if (temp.getNext().num == val) {
                    Node deletedNode = temp.getNext();
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrev(temp);
                    return deletedNode;
                }else{
                    temp = temp.getNext();
                }
            }
        }
        return null;
    }

    public void printReverse(){
        Node temp = last;
        if(temp == null){
            System.out.print("Empty linked list");
        }else{
            System.out.print(temp.num + " ") ;
            while(temp.getPrev() != null){
                System.out.print(temp.getPrev().num + " ");
                temp = temp.getPrev();
            }
        }
        System.out.print("\n");
    }


}
