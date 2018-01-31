public class MainActivity {


    public static void main(String[] args){
        LinkedList linkedList;
        linkedList = new LinkedList();
        Node n = new Node();
        n.setNum(6);
        linkedList.add(n);
        linkedList.addWithNumber(4);
        linkedList.addWithNumber(8);
        linkedList.addWithNumber(11);
        linkedList.addWithNumber(15);
        linkedList.print();
        System.out.println("Deleting node");
        linkedList.remove(11);
        linkedList.print();
        System.out.println("Printing reverse");
        linkedList.printReverse();


    }
}
