import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Solution solution = new Solution();
         ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();

        xValues.add(8);
        xValues.add(8);
        xValues.add(8);
        xValues.add(-7);
        xValues.add(-5);
        xValues.add(-13);
        xValues.add(9);
        xValues.add(-7);
        xValues.add(8);

        yValues.add(8);
        yValues.add(4);
        yValues.add(-15);
        yValues.add(-10);
        yValues.add(-3);
        yValues.add(-13);
        yValues.add(12);
        yValues.add(8);
        yValues.add(-8);
        System.out.println(solution.coverPoints(xValues,yValues));
    }
}
