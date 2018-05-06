public class Operation {
    String op;
    int leftVal;
    int rightVal;
    int weight;
    Operation prev;
    Operation post;
    Operation left;
    Operation right;


    public Operation getLeft() {
        return left;
    }

    public int getValue() {
        switch(op) {
            case "*":
                return leftVal*rightVal;
            case "/":
                return leftVal/rightVal;
            case "+":
                return leftVal+rightVal;
             default:
                 return  leftVal-rightVal;
        }
    }
    public void setLeft(Operation left) {
        this.left = left;
    }

    public Operation getRight() {
        return right;
    }

    public void setRight(Operation right) {
        this.right = right;
    }

    Operation(String left, String op){
        leftVal = Integer.parseInt(left);
        this.op = op;
    }

    public int getWeight(){
        if(op.equals("*")||op.equals("/")){
            return 0;
        }
        return 1;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public int getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(int leftVal) {
        this.leftVal = leftVal;
    }

    public int getRightVal() {
        return rightVal;
    }

    public void setRightVal(int rightVal) {
        this.rightVal = rightVal;
    }

    public Operation getPrev() {
        return prev;
    }

    public void setPrev(Operation prev) {
        this.prev = prev;
    }

    public Operation getPost() {
        return post;
    }

    public void setPost(Operation post) {
        this.post = post;
    }
}
