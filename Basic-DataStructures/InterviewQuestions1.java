import java.util.ArrayList;

public class InterviewQuestions1 {

    static boolean[] codex;

    public static void main(String[] args){
//        codex = new boolean[26];
//        String sample = "omgthisgyigbibhyuvftgcfrdrtcdfv";
//        for (char letter: sample.toCharArray()) {
//            if(hashFunction(letter)){
//            System.exit(0);            }
//        }
//        System.out.println("No duplicate letters");

        //runRecursion();
        int[] test = {1,2,3};
        mergeSplit(0,test.length,test);


    }

    public static boolean hashFunction(char letter){
        int position = (int)letter-97;
        if(codex[position]){
            System.out.println("Found duplicate letter " + letter);
            return true;
        }else{
            codex[position] = true;
        }
        return false;

    };

    public static void runRecursion(){
        int[] test = {1,2,5};
        System.out.println(recursion(test));
    }

    public static int recursion(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        if(start < end){
            int[] newArray = new int[end/2];
            //Create subarray
            for(int i = 0; i < end/2; i++){
                newArray[i] = nums[i];
            }
            return recursion(newArray);
        }
        else{
            return nums[start];
        }

    }

    public static void mergeSplit(int start, int end, int[] sub){

        if( end > start){
            int middle = (start+end)/2;
            //Call mergeSort on the left half
          mergeSplit(start,middle,sub);
            //Call mergeSort on the right half
            mergeSplit(middle+1,end,sub);
          //We now have a range of indexes to merge, so merge them!
            merge(sub,start,middle,end);
//            int[] leftGroup = new int[end/2];
//            int[] rightGroup = new int[end-(end/2)];
//            for(int i =0; i < leftGroup.length; i++){
//                    leftGroup[i] = sub[start+i];
//            }
//            for(int i =0; i < rightGroup.length; i++){
//                rightGroup[i] = (end/2)+i;
//            }
//            System.out.println("Left group: ");
//            for (int i = 0; i < leftGroup.length; i++){
//                System.out.print(i+" ");
//            }
//            System.out.println("");
//            System.out.println("Right group: ");
//            for (int i = 0; i < leftGroup.length; i++){
//                System.out.print(i+" ");
//            }
//            System.out.println("");

        }
    }

    public static void merge(int[] sub,int start, int middle,int end){

        //[7,4]
        int[] leftArray = new int[middle-start+1];
        int[] rightArray = new int[end-middle];
        for(int i = 0; i < leftArray.length;++i){
            leftArray[i] = sub[i+start];
        }
        for(int i = 0; i < rightArray.length;++i){
            rightArray[i] = sub[middle+1+i];
        }
        for (int i = 0; i < leftArray.length; i++){
                System.out.print(leftArray[i]+" ");
            }


    }




}
