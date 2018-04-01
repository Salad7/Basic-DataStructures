import java.util.HashMap;

public class Driver {


    static HashMap<Integer,Integer> amoritze;
    public static void main(String[] args){
        amoritze = new HashMap<>();
        System.out.println("Code challenge fib 6 = "+fib(15));
    }

    public static  int fib(int term){
        if(term == 0 || term == 1){
            return 1;
        }
        else if(amoritze.containsKey(term)){
            return amoritze.get(term);
        }
        else{
            int numToAmoritze = fib(term-2) +fib(term-1);
            amoritze.put(term,numToAmoritze);
            return numToAmoritze;
        }
    }


}
