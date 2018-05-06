public class BinarySearchTree {

    Operation root;
    Operation last;
    int size;

    public BinarySearchTree(){

    }

    public void initAdd(Operation in){
        if(root == null){
            root = last = in;
            size = 1;
        }
        else{
            add(root,in);
        }
    }



    public void initInOrderTraversal(){
        operationTraversal(root,1);
    }
    public void operationTraversal(Operation in, int steps){
        if(in.getLeft() != null){
            operationTraversal(in.getLeft(),steps+1);
        }
        if(in.getPrev()!= null){
            in.getPrev().setRightVal(in.getValue());
        }
        if(in.getPost() != null){
            in.getPost().setLeftVal(in.getValue());

        }
        System.out.println("Operation "+in.getOp()+" Left: "+in.getLeftVal()+" Right: "+in.getRightVal());
        last = in;
        if(in.getRight() != null){
            operationTraversal(in.getRight(),steps+1);
        }

    }
    public void add(Operation current, Operation in){
        if(in.getWeight() < current.getWeight()){
            if(current.getLeft() == null){
                current.setLeft(in);
            }
            else{
                add(current.getLeft(),in);
            }
        }
        else if(in.getWeight() >= current.getWeight()){
            if(current.getRight() == null){
                current.setRight(in);
            }
            else{
                add(current.getRight(),in);
            }
        }
        size+=1;
    }
}
