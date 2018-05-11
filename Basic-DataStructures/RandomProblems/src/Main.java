import java.util.ArrayList;

public class Main {
    static ArrayList<String> numPerms;
    static ArrayList<String> opPerms;
    static ArrayList<String> superOpPerms;
    static OperationStack operationStack;
    static ArrayList<String> fitsValue;
    static NumberStack numberStack;

    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        fitsValue = new ArrayList();
        numPerms = new ArrayList();
        opPerms = new ArrayList();
        superOpPerms = new ArrayList();
        operationStack = new OperationStack();
        numberStack = new NumberStack();
        String opSet = "*/+-";
        for (int i = 0; i < nums.length; i++) {
            generatePermutations(nums[i] + "");
        }
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder(opSet);
            String sub = sb.deleteCharAt(i) + "";
            for (int x = 0; x < 3; x++) {
                generateOpPerms(sub.charAt(x) + "");
            }
            superOpPerms.addAll(opPerms);
            opPerms.clear();
        }

//        for(int i = 0; i < superOpPerms.size(); i++){
//            System.out.println(superOpPerms.get(i));
//        }
//        System.out.println(superOpPerms.size());

        for (int i = 0; i < numPerms.size(); i++) {
            for (int x = 0; x < superOpPerms.size(); x++) {
                formulate(numPerms.get(i), superOpPerms.get(i));
            }
        }

    }

    public static void generatePermutations(String letter) {
        ArrayList<String> newPerms = new ArrayList();
        if(numPerms.size() == 0){
            String s = letter;
            numPerms.add(s);
        }
        else if(numPerms.size() == 1){
            numPerms.add(numPerms.get(0)+letter);
            numPerms.add(letter+numPerms.get(0));

            numPerms.remove(0);
        }
        else {
            for (int i = 0; i < numPerms.size(); i++) {
                for (int x = 0; x < numPerms.get(i).length()+1; x++) {
                    String item = numPerms.get(i);
                    String temp = "";
                    temp += item.substring(0, x) + "";
                    temp += letter;
                    temp += item.substring(x);
                    newPerms.add(temp);
                }
            }
            numPerms.clear();

            numPerms.addAll(newPerms);
        }
    }

        public static void generateOpPerms(String letter){
            ArrayList<String> newOps = new ArrayList();
            if(opPerms.size() == 0){
                opPerms.add(letter);
            }
            else if(opPerms.size() == 1){
                opPerms.add(opPerms.get(0)+letter);
                opPerms.add(letter+opPerms.get(0));
                opPerms.remove(0);
            }
            else {
                for (int i = 0; i < opPerms.size(); i++) {
                    for (int x = 0; x < opPerms.get(i).length() + 1; x++) {
                        String item = opPerms.get(i);
                        String temp = "";
                        temp += item.substring(0, x) + "";
                        temp += letter;
                        temp += item.substring(x);
                        newOps.add(temp);
                    }
                }
                opPerms.clear();
                opPerms.addAll(newOps);
            }


        }


    /**
     *[4]
     *[3][]
     *[1][+]
     *[6][-]
     *
     *
     *
     *
     *
     *
     *
     *
     * @param
     * @param operations
     */
    public static void formulate(String numbs, String operations){
        int i = 0;
        StringBuilder numbers = new StringBuilder(numbs);
        int[] ns = new int[4];
        for(int z = 0; z < ns.length; z++){
            ns[z] = numbs.charAt(z);
        }
        while(i < operations.length()){
            Number  n = new Number(ns[i]+"");
            Operation o = new Operation(operations.charAt(i)+"");
            if(o.type == 1){
            //Get next number
                Number next = new Number(numbers.charAt(i+1)+"");
                int value = o.performOperation(n.num,next.num);
                numbers.replace(i,i,value+"");
                //numberStack.push(new Number(value+""));
            }
            else {
                numberStack.push(n);
                operationStack.push(o);
            }
            i++;
        }
        numberStack.push(new Number(numbers.toString().charAt(numbers.length()-1)+""));
        while(operationStack.size > 0){
            Number a = numberStack.pop();
            Number b = numberStack.pop();
            System.out.println("Operation size: "+operationStack.size);
            Operation currentOp = operationStack.pop();
            int val = currentOp.performOperation(a.num,b.num);
            Number n = new Number(val+"");
            numberStack.push(n);
        }
        System.out.println(numbers+" "+operations+" = "+numberStack.r.num);

        if(numberStack.r.num == 24){
            fitsValue.add(numbers+operations);
        }
    }


}
