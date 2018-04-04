import java.util.HashMap;

public class Driver {


    static HashMap<Integer,Integer> amoritze;
    public static void main(String[] args){
        //amoritze = new HashMap<>();
        //System.out.println("Code challenge fib 6 = "+fib(15));

        System.out.println("Num combinations for 5 cents is "+(count811(10,0)+1));
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


    public static void permute(int k){
        0,3,2,1;
        int smallestIndex = 0;
        int flips = 0;
        4 < 3? y
                smallestIndex = 1;

    }
public static int count811(int num, int count){
        int q = num/25;
        int d = num/10;
        int n = num/5;
        int countQuaters = 0;
         System.out.println("Quarters "+q+" Dimes "+d+" Nickels "+n);
        while(q >= 1){
            count += count811(num-(25*q),1);
            q-=1;
        }
        while(d >= 1){
            count += count811(num-(10*d),1);
            d-=1;
        }
        while(n >= 1){
            count += count811(num-(5*n),1);
            n-=1;
        }
        System.out.println("");
        return count;
}

}
