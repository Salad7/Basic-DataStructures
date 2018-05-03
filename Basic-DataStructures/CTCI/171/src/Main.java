public class Main {

    static String friend = "";
    static boolean carry;
    public static void main(String[] arg){
        int test1 = -8;
        int test2 = -12;
        String t1 = Integer.toBinaryString(test1);
        String t2 = Integer.toBinaryString(test2);
        
        if(t1.length() > t2.length()){
            int lastIndex = t2.length()-1;
            System.out.println("t1 > t2");
            System.out.println("t1: "+t1+" t2: "+t2);
            for(int i = t1.length()-1; i >= 0; i--,lastIndex--){
               if(lastIndex < 0){
                   //Invalid add 0
                   isCarry(t1.charAt(i)+"","0");
               }
               else{
                   isCarry(t1.charAt(i)+"",t2.charAt(lastIndex)+"");

               }
            }
        }
        else{
            int lastIndex = t1.length()-1;
            for(int i = t2.length()-1; i >= 0; i--,lastIndex--){
                if(lastIndex < 0){ //t1 is null
                    isCarry(t2.charAt(i)+"","0");
                }
                else{
                    isCarry(t2.charAt(i)+"",t1.charAt(lastIndex)+"");
                }
            }
        }

        System.out.print("Value: "+Integer.parseInt(friend,2));
    }

    public static void isCarry(String a1, String a2){
        String combine = a1+a2;
        System.out.println("Comparing "+a1 +" : "+a2);

        if(combine.equals("01") || combine.equals("10")){
            if(carry){
               friend = "0"+friend;
               carry = true;

            }
            else{
                friend = "1"+friend;
                carry = false;
            }
        }
        else if (combine.equals("11")){
            if(carry){
                friend = "1"+friend;
                carry = true;
            }
            else{
                friend = "0"+friend;
                carry = true;
            }
        }
        else{
            if(carry){
                friend = "1"+friend;
                carry = false;
            }
            else{
                friend = "0"+friend;
                carry = false;
            }
        }
    }
}
