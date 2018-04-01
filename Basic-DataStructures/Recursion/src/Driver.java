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



public int count811(int num, int count){
        int q = num/25;
        int d = num/10;
        int n = num/5;
        int countQuaters = 0;

    while(q > 1){
            countQuaters += count811(num-(25*q),1);
            q-=1;
        }
        while(d > 1){

        }
        while(n > 1){

        }

        return 1;
}

}
