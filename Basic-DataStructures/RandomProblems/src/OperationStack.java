public class OperationStack {
    Operation r;
    int size;

    public OperationStack(){
        size = 0;
    }

    public void push(Operation o){
        if(r == null){
            r = o;
        }
        else {
            Operation temp = r;
            o.next = temp;
            r = o;
        }
        size+=1;
    }

    public Operation pop(){
        Operation temp = r;
        r = r.next;
        size-=1;
        return temp;
    }

}
