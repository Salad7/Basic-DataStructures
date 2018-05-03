import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        String[] test = {"3","a"};
        HashMap<String,Integer> freqHashMap = new HashMap<>();
        HashMap<Integer,Node> containerHash = new HashMap<>();
        Node nodeWithLongestSubSequence = new Node("",0);
        for(int i = 0; i < test.length; i++){
            if(freqHashMap.containsKey(test[i])){
                Node temp = null;
                int frequence = freqHashMap.get(test[i]);
                freqHashMap.remove(test[i]);
                freqHashMap.put(test[i],frequence+1);
                containerHash.get(frequence).remove(test[i]);
                if(containerHash.containsKey(frequence+1)){
                    containerHash.get(frequence+1).append(test[i]);
                    temp = containerHash.get(frequence+1);
                }
                else{
                    containerHash.put(frequence+1,new Node(test[i],frequence+1));
                }
                if(temp != null && temp.hasBoth){
                    if(nodeWithLongestSubSequence != null){
                        if(temp.weight > nodeWithLongestSubSequence.weight) {
                            nodeWithLongestSubSequence = temp;
                        }
                    }
                    nodeWithLongestSubSequence = temp;
                }

            }
            else{
                freqHashMap.put(test[i],1);
                if(containerHash.containsKey(1)){
                    containerHash.get(1).append(test[i]);
                }
                else{
                    containerHash.put(1,new Node(test[i],1));
                }
                if(containerHash.get(1).hasBoth){
                    nodeWithLongestSubSequence = containerHash.get(test[i]);
                    System.out.print("hah");
                }
            }
        }
        if(nodeWithLongestSubSequence != null) {
            System.out.print(nodeWithLongestSubSequence.val + " " + nodeWithLongestSubSequence.letter);
        }
        System.out.print("Nope: "+containerHash.get(1).val + " " + containerHash.get(1).letter);




    }

}
