import java.util.Random;

public class MinHeap {

    public static void main(String[] args){

        int[] nums = new int[100];

        for(int i = 0; i < nums.length; ++i)
        {
            nums[i] = i + 1;
        }

        Random generator = new Random();
        for(int i = 0; i < nums.length; ++i)
        {
            int j = generator.nextInt(nums.length - i);
            int tmp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[j];
            nums[j] = tmp;
        }

        MinHeapify heapify = new MinHeapify(nums);
        heapify.print();
        System.out.println("Smallest value is: "+heapify.remove());
        //heapify.print();
        System.out.println("Smallest value is: "+heapify.remove());
        //heapify.print();
        System.out.println("Smallest value is: "+heapify.remove());
        //heapify.print();
    }







    public static class Node {
        int val;
        Node left;
        Node right;
        Node parent;


        Node(int val){
            this.val = val;
            left = null;
            right = null;
            parent = null;
        }


    }

    public static class MinHeapify {
    int[] vals;
     int lastIndex = 1;
     int nullIndex;


        MinHeapify(int size) {
            vals = new int[size + 1];
        }

        MinHeapify(int[] vals){
            this.vals = new int[vals.length+1];
            for(int i = 1; i < this.vals.length-1; i++){
                add(vals[i]);
            }
            //lastIndex = this.vals.length-1;
            }


    public void print(){
            for(int i = 1; i < lastIndex; i++){
                System.out.println("Item: "+vals[i]);
            }
    }

    public void add(int num){
            if(lastIndex == 1){
                vals[1] = num;
                lastIndex++;
            }
            else{
               // ++size;
                vals[lastIndex] = num;
                System.out.println("");
                addTraverse(lastIndex);
                lastIndex++;
            }


    }

    public int remove(){
            int temp = vals[1];
            vals[1] = vals[lastIndex-1];
            lastIndex-=1;
            removeTraverse(1);

            return temp;
    }

        public void removeTraverse(int index){
            int leftChild = index+1;
            int rightChild = index+2;
            if(rightChild <= lastIndex){
                if(vals[leftChild] < vals[rightChild]){
                    if (vals[index] > vals[leftChild]) {
                        //We are at last available node, no need to do anything
                        int temp = vals[leftChild];
                        vals[leftChild] = vals[index];
                        vals[index] = temp;
                        removeTraverse(leftChild);
                    }
                }else{
                    if (vals[index] > vals[rightChild]) {
                        //We are at last available node, no need to do anything
                        int temp = vals[rightChild];
                        vals[rightChild] = vals[index];
                        vals[index] = temp;
                        removeTraverse(rightChild);
                    }
                }
            }
            if(leftChild <= lastIndex) {
                if (vals[index] > vals[leftChild]) {
                    //We are at last available node, no need to do anything
                    int temp = vals[leftChild];
                    vals[leftChild] = vals[index];
                    vals[index] = temp;
                    removeTraverse(leftChild);
                }
            }
        }

    public void addTraverse(int index){
            System.out.println("Last index "+ lastIndex);
            int parentIndex = index/2;
            if(vals[index] < vals[parentIndex] && parentIndex > 0){
                System.out.println("Swapping "+vals[index]+" with "+vals[parentIndex]);
                int temp = vals[parentIndex];
                vals[parentIndex] = vals[index];
                vals[index] = temp;
                addTraverse(parentIndex);
            }
    }







    }




}
