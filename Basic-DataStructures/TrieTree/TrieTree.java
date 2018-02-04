import java.util.LinkedList;

public class TrieTree {
    public static void main(String []args){
        Trie trie = new Trie();

        boolean isFound = trie.search("dog",0,null);
        System.out.println(isFound);
//        System.out.println("Num connections: "+trie.top.connections.size());
//        System.out.println("Value: "+trie.top.connections.get(0).letter);
        System.out.println("\n");
        isFound = trie.search("doa",0,null);
        System.out.println(isFound);
//        System.out.println("Num connections: "+trie.top.connections.size());
//        System.out.println("Value: "+trie.top.connections.get(0).letter);



    }

    public static class Trie {
        int size = 0;
        TrieNode top;


        Trie(){
            top = new TrieNode();
        }

        public void print(){
            inorder(top);


        }
        public void inorder(TrieNode item){
            //Left recurse

            //Print item
            //Right recurse

        }

        public String charToString(char c){
            return Character.toString(c);
        }
        public boolean search(String word, int position, TrieNode shiftNode){
            //Base cases
            if(top.connections.size() == 0){
                //Then add the first letter as a connection to top
                TrieNode currentNode = new TrieNode(charToString(word.charAt(0)));
                top.connections.add(currentNode);
                TrieNode temp = currentNode;
                for(char letter: word.substring(1).toCharArray()){
                    //For every remaining character in the word starting from index 1
                    temp.connections.add(new TrieNode(Character.toString(letter)));
                    temp = temp.connections.get(temp.connections.size()-1);
                }
               temp.connections.add(new TrieNode("*"));
            }
            else{
                //System.out.println("Hit else case!");
                //Base case
                if(position >= word.length()){
                    //System.out.println("Found all letters, returning true");
                    return true;
                }
                if(shiftNode == null){
                    //System.out.println("ShiftNode null, using top");
                    shiftNode = top;
                }
                //System.out.println("Number of connrections: "+shiftNode.connections.size());
                for (TrieNode item: shiftNode.connections){
                    //For every connection If we find a letter matching the position were looking for
                    if(item.letter.equals(charToString(word.charAt(position)))){
                        //System.out.println("Does: "+item.letter+" = "+charToString(word.charAt(position)));
                        //Continue looking for the next word
                        return search(word,position+1,item);
                    }
                    else{
                        //Word has finally broken, we need to add a connection to the current item
                        item.connections.add(new TrieNode(charToString(word.charAt(position))));
                        for(char letter: word.substring(1).toCharArray()){
                            //For every remaining character in the word starting from index 1
                            item.connections.add(new TrieNode(Character.toString(letter)));
                            item = item.connections.get(item.connections.size()-1);
                        }
                        item.connections.add(new TrieNode("*"));
                    }
                }
            }
            return false;

        }



    }

    public static class TrieNode {
        String letter;
        TrieNode nextNode;
        LinkedList<TrieNode> connections;
        TrieNode(String letter){
            this.letter = letter;
            nextNode = null;
            connections = new LinkedList<>();
        }
        TrieNode(){
            nextNode = null;
            connections = new LinkedList<>();

        }
    }
}
