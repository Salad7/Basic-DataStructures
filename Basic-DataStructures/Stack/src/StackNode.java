public class StackNode {
    Node top;


    StackNode(){
        top = null;
    }

    public void push(Node item){
        if(top == null){
            top = item;
        }else{
            item.setNext(top);
            top = item;
        }
    }

    public Node pop(int val){
        if(top == null){
            return null;
        }
        //Remove from the top
        //Store temp
        //Set top equal to next
        //return temp
        Node temp = top;
        if(temp.getNext() != null){
            top.setNext(top.getNext());
            return temp;
        }
        return null;
    }

    public Node peek(){
        return top;
    }

    public void sortStack(){
        //Case 1: Already sorted

        //Case 2: Swap first two

        //Case 3 or more:
        //
    }
}
