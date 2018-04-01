    import java.util.*;
import java.lang.*;
    public class Solution {

        public static void main(String[] args){
            ArrayList<Integer> items = new ArrayList<>();
            items.add(5);
            items.add(4);
            items.add(7);
            items.add(2);
            items.add(1);
            items.add(7);
            items.add(1);
            items.add(3);
            items.add(7);
            items.add(4);
            items.add(7);
            items.add(7);
            items.add(1);
            items.add(3);
            items.add(1);
            items.add(66);
            majorityElement(items);
        }

        public static int majorityElement(final List<Integer> a) {
            ArrayList<Integer> convert = new ArrayList();
            for(int i = 0; i < a.size(); i++){
                convert.add(a.get(i));
            }
            HashMap<String,Integer> hashmap = new HashMap();
            hashmap.put("count",1);
            hashmap.put("index",0);
            Merge merger = new Merge(a);
            merger.split(0,a.size()-1,convert);
            List<Integer> sorted = merger.nums;
            for(int i = 0; i < sorted.size(); i++){
                System.out.println("Item: "+sorted.get(i));
            }
            for(int i =0; i < sorted.size(); i++){
                int storage = i;
                int count = 0;
                //int subIndex = i+1;
                while(i< sorted.size() && sorted.get(i).intValue() == sorted.get(storage).intValue()){
                    count+=1;
                    i+=1;
                }
                if(count > hashmap.get("count")){
                    hashmap.put("count",count);
                    hashmap.put("index",storage);
                }
            }

            System.out.println("Value that shows up the most "+sorted.get(hashmap.get("index")));
            //System.out.println("Shows up a total amount of: "+sorted.get(hashmap.get("count")));//
            return sorted.get(hashmap.get("count"));
        }

        public static class Merge{
            List<Integer> nums;

            Merge(List<Integer> nums){
                this.nums = nums;
            }

            public void split(int start, int end,List<Integer> nums){
                if(start < end){

                    int mid = (start+end)/2;
                    //Split on the left
                    split(start,mid,nums);
                    //Split on the right
                    split(mid+1,end,nums);
                    System.out.println("Start: "+start+" Mid: "+mid+" End "+end);
                    this.nums = merge(start,mid,mid+1,end,(ArrayList<Integer>)nums);
                }
//                for(int i =0 ;i< this.nums.size(); i++){
//                    System.out.print(this.nums.get(i)+" ");
//                }
                //System.out.print("\n");
            }
            public List<Integer>  merge(int leftStart,int leftEnd, int rightStart, int rightEnd, ArrayList<Integer> nums){
                List<Integer> helper = new ArrayList<Integer>();
                List<Integer> leftSide = new ArrayList<Integer>();
                List<Integer> rightSide = new ArrayList<Integer>();

                for(int i = leftStart; i <= leftEnd; i++){
                    leftSide.add(nums.get(i));
                }
                for(int i = rightStart; i <= rightEnd; i++){
                    rightSide.add(nums.get(i));
                }
                System.out.println("Mid is: "+leftEnd);
                System.out.println("Left Side: ");
                for(int i = 0; i < leftSide.size(); i++){
                    System.out.println(leftSide.get(i)+" ");
                }
                System.out.print("\n");
                System.out.println("Right Side: ");
                for(int i = 0; i < rightSide.size(); i++){
                    System.out.println(rightSide.get(i)+" ");
                }
                System.out.print("\n");
                int leftCounter = 0;
                int rightCounter = 0;
                while(leftSide.size() != 0 && rightSide.size() != 0){
                    System.out.println("Leftside size "+leftSide.size()+" rightside "+rightSide.size());
                    if(leftSide.get(0) < rightSide.get(0)){
                        helper.add(leftSide.get(0));
                        leftSide.remove(0);
                        leftCounter+=1;
                    }
                    else{
                        helper.add(rightSide.get(0));
                        rightSide.remove(0);
                        rightCounter+=1;
                    }
                }

                if(leftSide.size() == 0){
                      helper.addAll(rightSide);
                }
                else if(rightSide.size() == 0){
                        helper.addAll(leftSide);
                }

                for(int i = leftStart; i <= rightEnd; i++){
//                    System.out.println("Helper Item: "+helper.get(i));
                    nums.set(i,helper.get(i-leftStart));

                    //helper.remove(0)
                }
                System.out.println("");

                return nums;
            }

        }





        }



//    public class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ArrayList<ListNode> newNums = new ArrayList<ListNode>();
//            int carry  = 0;
//            ListNode l1Start = l1;
//            ListNode l2Start = l2;
//            while(l1Start != null || l2Start != null){
//                carry = newListAdd(l1Start,l2Start,carry,newNums);
//                if(l1Start != null && l1Start.next != null){
//                    l1Start = l1Start.next;
//                }
//                else {
//                    l1Start = null;
//                }
//                if(l2Start != null && l2Start != null){
//                    l2Start = l2Start.next;
//                }
//                else{
//                    l2Start = null;
//                }
//            }
//            if(carry != 0){
//                newNums.add(new ListNode(carry));
//            }
//            return newNums.get(3);
//        }
//
//        public int newListAdd(ListNode l, ListNode l2, int cry, ArrayList<ListNode> newNums){
//            if(l == null){
//                l = new ListNode(0);
//            }
//            if(l2 == null){
//                l2 = new ListNode(0);
//            }
//            int newVal = (l2.val+l.val+cry);
//            if(l2.val + l.val+cry > 9){
//                newNums.add(new ListNode(newVal-10));
//                return 1;
//            }
//            newNums.add(new ListNode(newVal));
//            return 0;
//        }
//
//
//        public class LinkedListImp {
//            ListNode first;
//            LinkedListImp(){
//                first = null;
//            }
//            public void add(ListNode node){
//                if(first == null){
//                    first = node;
//                }
//                else{
//                    ListNode temp = new ListNode(3);
//                    while(temp.next != null){
//
//                        temp = temp.next;
//                    }
//                    temp.next = node;
//
//                }
//            }
//        }
//    }


