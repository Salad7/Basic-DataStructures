import java.util.List;

public class GDCProblem {
        public static int gcd(int A, int B) {
            if (A == 0)
                return B;
            return gcd(B % A, A);
        }

    public static ListNode deleteDuplicates(ListNode a) {

        if(a.val == 1){
            return a;
        }
        else if(a.next == null){
            return null;
        }
            if(a.val == a.next.val){
                System.out.println("Hit");
                a.next = duplicate(a,a.val);
                a.next = a;

            }
        return deleteDuplicates(a.next);
    }

    //Add beginning of concurrent ListNode items
    public static ListNode duplicate(ListNode a,int b){
            if(a.next == null){
                return null;
            }
        else if(a.next.val != b ){
            return a.next;
        }
        return duplicate(a.next,b);
    }

    public static class ListNode {
            ListNode next;
            int val;
            ListNode(){

            }
            ListNode(int v){
                val = v;
            }
    }


    public static void main(String[] args){
        //System.out.println(gcd(12,39));
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node = deleteDuplicates(node);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
        System.out.println(node.next.next.next.val);
    }
}
