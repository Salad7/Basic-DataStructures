public class NumberStack {
    Number r;
    int size;

    public NumberStack(){
        size = 0;
    }

    public void push(Number n){
        if(r == null){
            r = n;
        }
        else {
            n.next = r;
            r = n;
        }
        size+=1;
    }

    public Number pop(){
        Number temp = r;
        r = r.next;
        size-=1;
        return temp;
    }

}
