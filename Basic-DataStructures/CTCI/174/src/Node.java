public class Node {
    String letter;
    String val;
    int weight;
    boolean hasBoth;


    public Node(String someVal, int weight){
        if(letter == null){
            letter="";
        }
        if(val == null){
            val = "";
        }
        try{
            int value = Integer.parseInt(someVal);
            val+=value;
        }
        catch (NumberFormatException e){
            letter+=someVal;
        }
        if(letter.length() > 0 && val.length() > 0){
            hasBoth = true;
        }
        else {
            hasBoth = false;
        }
        this.weight = weight;
    }

    public void append(String someVal){
        try{
            int value = Integer.parseInt(someVal);
            val+=value;
        }
        catch (NumberFormatException e){
            letter+=someVal;
        }
        if(letter.length() > 0 && val.length() > 0){
            hasBoth = true;
        }
        else {
            hasBoth = false;
        }
    }

    public void set(Node n){
        letter = n.letter;
        val = n.val;
        hasBoth = n.hasBoth;
        weight = n.weight;
    }

    public void remove(String someVal){
        try{
            int value = Integer.parseInt(someVal);
            int indexToRemove = val.indexOf(someVal);
            val = val.substring(0,indexToRemove)+val.substring(indexToRemove,val.length());
        }
        catch (NumberFormatException e){
            int indexToRemove = letter.indexOf(someVal);
            letter = letter.substring(0,indexToRemove)+letter.substring(indexToRemove,letter.length());
        }
        if(letter.length() > 0 && val.length() > 0){
            hasBoth = true;
        }
        else {
            hasBoth = false;
        }
    }
}
