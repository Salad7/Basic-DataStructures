import java.util.ArrayList;

public class Solution {
    public Solution(){

    }
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
            int steps = 0;

            for(int i = 0; i < X.size()-1;i++){
                int dx = Math.abs(X.get(i+1)-X.get(i));
                steps += dx;
                if(Y.get(i+1) < 0 && Y.get(i+1) < Y.get(i)-dx){
                    steps+= Math.abs(Y.get(i+1) - Math.abs(Y.get(i)-dx));
                }
                else if(Y.get(i+1) > 0 && Y.get(i+1) > Y.get(i)+dx ){
                    steps+= Math.abs(Y.get(i+1)) - Math.abs(Y.get(i)+dx);
                }
            }
            return steps;
        }
}
