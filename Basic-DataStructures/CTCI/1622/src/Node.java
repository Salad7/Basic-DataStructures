public class Node {
    int row;
    int col;
    int color;
    String direction;


    public Node(int r, int c, int color, String dir){
        this.row = r;
        this.col = c;
        this.color = color;
        this.direction = dir;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void flipColor(){
        if(color == 0){
            color = 1;
        }
        else{
            color = 0;
        }
    }

    public String getStringColor(){
        if(color == 0){
            return "White";
        }
        return "Black";
    }
    public String getDirection() {
        return direction;
    }

    public String getNextDirection(){
        if(direction.equals("R")){
            return "D";
        }
        else if(direction.equals("L")){
            return "U";
        }
        else if(direction.equals("U")){
            return "R";
        }
        else{
            return "L";
        }
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    public void moveDirection(){
        if(direction.equals("R")){
            direction = "D";
        }
        else if(direction.equals("L")){
            direction = "U";
        }
        else if(direction.equals("U")){
            direction = "R";
        }
        else{
            direction = "L";
        }
    }
}
