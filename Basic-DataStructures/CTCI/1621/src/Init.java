import java.util.HashMap;

public class Init {

    HashMap<Integer,Integer> map;
    boolean pairFound;
    int sumA = 0;
    int sumB = 0;

    public Init(){
        map = new HashMap<>();
        int[] a = {4,1,2,1,1,2,1,5,6,2,4,-1};
        int[] b = {3,6,3,3,4,3,14,4,3,12,3};
        for (int i = 0; i < a.length; i++){
            sumA+=a[i];
            map.put(a[i],i);
        }
        for (int i = 0; i < b.length; i++){
            sumB+=b[i];
        }
        System.out.println("SumA: "+sumA);
        System.out.println("SumB: "+sumB);
        System.out.println("");
        for(int i = 0; i < b.length; i++){
            int newSumA = sumA+b[i];
            int newSumB = sumB-b[i];
            if(map.containsKey((newSumA-newSumB)/2) && (sumA+sumB)%2 == 0){
                //Found pair
                pairFound = true;
                printPair((newSumA-newSumB)/2,b[i]);
            }
        }
        if(!pairFound){
            System.out.println("Pair not found");
        }

    }
    public void printPair(int fromA, int fromB){
        System.out.println("{ "+fromA+" , "+fromB+"}");
        System.out.println("New SumA: "+((sumA-fromA)+fromB));
        System.out.println("New SumB: "+((sumB-fromB)+fromA));
        System.out.println("");

    }
}
