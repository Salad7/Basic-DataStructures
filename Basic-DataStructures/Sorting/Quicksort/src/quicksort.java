import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class quicksort {

    public static void main(String[] args){
        int[] nums = {1,7,3,6,2};
        printArray(quickSort(nums));



    }

    public static void printArray(int[] n){
            for(int i = 0; i < n.length; i++){
                System.out.print(n[i]+" ");
            }
        System.out.println("");
    }

    public static int[] quickSort(int[] a){
        if(a.length == 0 || a.length == 1){
            return a;
        }
        int random = (a.length/2)+1;
        //System.out.println("Random index = "+random);
        int[] left = new int[random];
        int[] right = new int[a.length-random];

        for(int i = 0; i < left.length; i++){
            left[i] = a[i];
        }
        int j = 0;
        for(int i = left.length; i < a.length; i++, j++){
            right[j] = a[i];
        }
        System.out.print("Array:" +
                " ");
        printArray(a);
        System.out.print("Left: ");
        printArray(left);
        System.out.print("Right: ") ;
        printArray(right);
        System.out.println("");
        System.out.println("");
        if(a.length == 2){
            System.out.println("Checking swap!");
            if(a[0] < a[1]){
                int temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
            return a;
        }
        else{
            printArray(quickSort(left));
            int[] leftSide = quickSort(left);
            int[] rightSide = quickSort(right);
            return combineArrays(leftSide.length,leftSide.length+1,leftSide,rightSide);
        }
    }

    public static int[] combineArrays(int midIndex, int rightIndex, int[] leftArray, int[] rightArray){
        int leftSteps = 0;
        int rightSteps = 0;
        int leftCapacity = leftArray.length; //3
        int rightCapacity = rightArray.length; //2
        int currentStep = 0;
        int[] newArray = new int[leftCapacity+rightCapacity];

        while(leftSteps < leftCapacity && rightSteps < rightCapacity){
            if(leftArray[leftSteps] < rightArray[rightSteps]){
                newArray[currentStep] = leftArray[leftSteps];
                leftSteps+=1;
            }
            else {
                newArray[currentStep] = rightArray[rightSteps];
                rightSteps+=1;
            }
        }
        if(leftSteps != leftCapacity){
            int[] remainingLeft = new int[leftArray.length-leftCapacity];
            for(int i = leftCapacity; i < leftArray.length; i++){
                remainingLeft[i] = leftArray[i];
            }
            //Add remaining left array to new Array
            newArray = concat(newArray,remainingLeft);
        }
        int[] remainingRight = new int[rightArray.length-rightCapacity];
        for(int i = rightCapacity; i < rightArray.length; i++){
            remainingRight[i] = rightArray[i];
        }
        //Add remaining right array to new array
        newArray = concat(newArray,remainingRight);

        return newArray;


    }

    public static int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
