import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static String phrase = "sweet";
    static HashMap<String,ArrayList<String>> hashy;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args){
        merge(0,phrase.length()-1);
        for (String perm: list
             ) {
            System.out.println(perm);
        }
        System.out.println("Size: "+list.size());

    }


    public static void merge(int startIndex, int endIndex){
        String init = "";
        if(endIndex-startIndex > 1){
            String left = phrase.charAt(0)+"";
            String right = phrase.charAt(1)+"";
            permute(left,right);
        }
       for(int i = 2; i < phrase.length(); i++){
               permute("",phrase.charAt(i)+"");
       }
    }

    public static String permute(String left, String right){
        if(left.length()+right.length() == 2){
            list.add(left+right);
            list.add(right+left);
        }
        else{
            ArrayList<String> oldList = new ArrayList<>();
            oldList.addAll(list);
            list.clear();
            combine(oldList,right);
        }
        return left+right;
    }



    public static void combine(ArrayList<String> temp, String letter){
        for (String phrase: temp
             ) {
            list.add(letter+phrase);
            list.add(phrase+letter);
            for(int i = 1; i < phrase.length(); i++){
                String newS = "";
                newS+=phrase.substring(0,i)+letter+phrase.substring(i,phrase.length());
                list.add(newS);
            }
        }
    }




}
