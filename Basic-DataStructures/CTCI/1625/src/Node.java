public class Node {
    int key;
    Node next;
    Node prev;
    int val;


    public Node(int k, int v){
        key = k;
        val = v;
    }
    public Node(){
        next = new Node();
        prev = new Node();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
