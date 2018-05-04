import java.util.ArrayList;

public class Mergesort {
    ArrayList<String> perms;
    String buffer;
    int numOps;
    public Mergesort(String phrase){
        perms = new ArrayList<>();
        if(phrase.length() == 1){
            perms.add(phrase);
        }else {
            merge(phrase);
        }
    }

    public void printPermutations(){
        for (String s: perms
             ) {
            System.out.println(s);
        }
        System.out.println("Number operations: "+numOps);
    }

    public String merge(String phrase){
        String left;
        String right;
        int midIndex = ((phrase.length()+1)/2)-1;
        if(phrase.length() > 1) {
            //split
            System.out.println("Left: "+phrase.substring(0,midIndex+1));
            System.out.println("Right: "+phrase.substring(midIndex+1));

            left = merge(phrase.substring(0,midIndex+1));
            right = merge(phrase.substring(midIndex+1));
            numOps+=left.length()+right.length();
            perms.clear();
            return permute(left,right);
        }
        else{
            return phrase;
        }
    }


    public String permute(String left, String right){
        if(left.length()+right.length()> 2){
            permuteInner(left,right);
        }else{
            perms.add(left+right);
            perms.add(right+left);
        }
        return left+right;
    }

    public void permuteInner(String original, String letter){
        //int indexWhereLetterShouldGo = 0;
        int newSize = original.length()+letter.length()-1;
        for(int indexWhereLetterShouldGo = 0;indexWhereLetterShouldGo < newSize; indexWhereLetterShouldGo++){
            String newLetter = "";
            newLetter+=letter;
            newLetter = original.substring(0,indexWhereLetterShouldGo)+newLetter;
            newLetter+= original.substring(indexWhereLetterShouldGo);
            numOps+=newLetter.length();
            perms.add(newLetter);
            perms.add(reverseString(newLetter));
            numOps+=1;
        }
    }

    public String reverseString(String t){
        StringBuilder stringBuilder = new StringBuilder(t);
        return stringBuilder.reverse().toString();
    }


}
