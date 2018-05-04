import java.util.HashMap;

public class Main {
    static HashMap<Integer,Node> map = new HashMap<>();
    static ModifiedStack modifiedStack = new ModifiedStack(2);
    public static void main(String[] args){
        addToStack(1,1);
        addToStack(2,2);
        modifiedStack.printStack();
        System.out.println("");
        printMapItem(1);
        System.out.println("");
        modifiedStack.printStack();
        //addToStack(3,3);
        //printMapItem(2);




    }
    public static void printMapItem(int k){
        if(map.containsKey(k)){
            System.out.println(map.get(k).val);
            modifiedStack.moveToTop(k);
        }
        else{
            System.out.println("-1");
        }
    }
    public static void addToStack(int key,int val){
        if(!modifiedStack.capReached()){
            if(map.containsKey(key)){
                Node t = map.get(key);
                t.val = val;
                map.put(key,t);
            }
            else{
                Node t = new Node(key,val);
                map.put(key,t);
                modifiedStack.push(t);
            }

        }
        else{
            //Capacity Reached
            if(map.containsKey(key)){
                Node t = map.get(key);
                t.val = val;
                map.put(key,t);
            }
            else{
                modifiedStack.pop();
                Node t = new Node(key,val);
                map.put(key,t);
                modifiedStack.push(t);
            }
        }
    }
}
