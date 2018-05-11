public class Operation {
    int type;
    String classification;
    Operation next;
    Operation(String classif){
        this.classification = classif;
        if(classif.equals("*") || classif.equals("/")){

            type = 1;
        }
        else{
            type = 0;
        }
    }
    public int performOperation(int a, int b){
        switch (classification){
            case  ("*"):
                System.out.println(a+"*"+b);
            return a*b;
            case ("+"):
                System.out.println(a+"+"+b);
                return a+b;
            case ("-"):
                System.out.println(a+"-"+b);
                return a-b;
            default:
                System.out.println(a+"/"+b);
                return a/b;

        }
    }
}
