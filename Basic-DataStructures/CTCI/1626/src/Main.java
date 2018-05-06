public class Main {
    //10:45
    //11:08
    static String leftBuffer;
    static String rightBuffer;
    static Operation currentOperation;
    static boolean foundOperation;
    static BinarySearchTree binarySearchTree;
    public static void main(String[] args){
        leftBuffer = "";
        rightBuffer = "";
        binarySearchTree = new BinarySearchTree();
        initCalculator("2+3*4+1");
        System.out.println("Size: "+binarySearchTree.size);
        binarySearchTree.initInOrderTraversal();
        System.out.println("Sum: "+binarySearchTree.last.getValue());
        System.out.println("In: "+binarySearchTree.last.getLeftVal()+" "+binarySearchTree.last.getRightVal());




    }

    public static void initCalculator(String nums){
        for(int i = 0; i < nums.length(); i++){
            String currentItem = nums.charAt(i)+"";
            if(isNum(currentItem)){
                if(foundOperation){
                    rightBuffer+=currentItem;
                }
                else{
                    leftBuffer+=currentItem;
                }
            } else{
                if(foundOperation){
                    currentOperation.setRightVal(Integer.parseInt(rightBuffer));
                    Operation old = currentOperation;
                    currentOperation = new Operation(rightBuffer,currentItem);
                    old.setPost(currentOperation);
                    currentOperation.setPrev(old);
                    leftBuffer = rightBuffer;
                    rightBuffer = "";
                }
                else{
                    currentOperation = new Operation(leftBuffer,currentItem);
                    foundOperation = true;
                }
                binarySearchTree.initAdd(currentOperation);
            }
        }
        currentOperation.setRightVal(Integer.parseInt(rightBuffer));
        rightBuffer = "";
        //
    }

    public static boolean isNum(String q){
        try{
            int a = Integer.parseInt(q);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

}
