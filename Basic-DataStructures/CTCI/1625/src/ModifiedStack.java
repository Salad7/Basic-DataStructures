public class ModifiedStack {

    Node front;
    Node end;
    int size;
    int capacity;

    public ModifiedStack(int capacity){
        this.capacity = capacity;
    }

    public void push(Node n){
        if(end == null){
            front = end = n;
        }
        else{
            n.prev = end;
            end.next = n;
            end = n;
        }
        size+=1;
    }

    public void printStack(){
        Node iterator = end;
        while(iterator != null){
            System.out.println(iterator.val);
            iterator = iterator.prev;
        }
    }

    public void pop(){
        end = end.prev;
        size-=1;
    }

    public void moveToTop(int k){
        Node current = front;
        while(current.key != k){
            current = current.next;
            //System.out.println("dasda");
        }
        //Found node to take to top
        Node topPlace = current;
        System.out.println("Current: "+current.key);
        //System.out.println("Previous: "+current.next.key);


        while(current != end){
           current = current.next;
           current.setNext(topPlace);

        }
//        Node temp = current.prev;
//        current.prev = topPlace;
//        topPlace.next = temp;

    }

    public boolean capReached(){
        if(size == capacity){
            return true;
        }
        return false;
    }





}
