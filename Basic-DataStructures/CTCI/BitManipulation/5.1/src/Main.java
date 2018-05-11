public class Main {

    static int A = 1024;
    static int B = 19;
    static StringBuilder Bstring = new StringBuilder(Integer.toBinaryString(B));
    static StringBuilder Astring = new StringBuilder(Integer.toBinaryString(A));
    public static void main(String[] args){

        int j = 2;
        int i = 6;
        //Normalize step
        B = B << j;
        Bstring =  new StringBuilder(Integer.toBinaryString(B));
        int step = 0;
        System.out.println(Astring.toString());

        for(int x = Bstring.length()-1; x >= 0; x--){
            System.out.println("X: "+x);
            setBit(Astring.length()-Bstring.length()+x,j,i,step);
            step++;
        }
        System.out.println(Bstring.toString());

        System.out.println(Astring.toString());



    }

    public static void setBit(int index,int begin, int end, int step){
        int Bindex = index-Astring.length()+Bstring.length();
        if(step >= begin && step <= end){
            Astring.replace(index,index+1,Bstring.substring(Bindex,Bindex+1));
        }
    }
}
