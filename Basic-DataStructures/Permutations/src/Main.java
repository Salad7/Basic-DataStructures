import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static HashMap<String,ArrayList<String>> hashy;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args){
        String s = "abc";
        initCombinations(s,0);
    }
    public static void initCombinations(String in, int startIndex){
        if(hashy == null){
            hashy = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();
            list.add(in.charAt(0)+"");
            hashy.put("stock",list);
            initCombinations(in,startIndex+1);
        }
        else if(startIndex >= in.length()){

        }
        else{
            list = hashy.get("stock");
            //for(int i = startIndex; i < in.length();){
                for(int x  = 0; x < list.size(); x++){
                    list = merge(in.charAt(startIndex)+"",list.get(x));
                }
            initCombinations(in,startIndex+1);

            //}
        }
    }

    public static ArrayList<String> merge(String singleLetter, String subset){
        String retString = "";
        System.out.println("Single Letter: "+singleLetter+" subset: "+subset);
        String front = singleLetter+subset;
        String back = subset+singleLetter;
        System.out.println("Front: "+front);
        System.out.println("Back: "+back);
        if(front.length() > 2){
            //If there is atleast one midpoint
            int midPoint = front.length()/2; // 1
            //___
            for(int i = 0; i < back.length(); i++){
                if(i < midPoint){
                    retString = back.charAt(i)+retString;
                }
                else if(i == midPoint){
                    retString = retString+singleLetter;
                }
                else if(i >= midPoint){
                    retString = retString+subset.charAt(i - midPoint);
                }
            }
            System.out.println("Returned string: "+retString);
        }
        ArrayList<String> newStocks = new ArrayList<>();
        newStocks.add(front);
        newStocks.add(back);
        hashy.put("stock",newStocks);
        return hashy.get("stock");


    }

    public static void mergeMiddle(int place){

    }




}
