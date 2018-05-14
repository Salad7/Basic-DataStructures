public class Mergesort(){
        int[] a;
public Mergesort(int[] a){
        this.a = a;
        if(a.length > 1){
        this.a = msort(0,a.length-1);
        }
        }
public void init(){

        }

public int[] msort(int s, int e){
        if(s == e){
        int[] sub = new int[1];
        sub[0] = a[s];
        return sub;
        }
        else{
        int m = (s+e)/2;
        int[] left = msort(s,m);
        int[] right = msort(m+1,e);
        return merge(s,e,left,right);
        }
        }

public int[] merge(int s, int e, int[] left, int[] right){
        int[] buffer = new int[left.length+right.length];
        int bufferPoint = 0;
        int lsv = 0;
        int rsv = 0;
        while(lsv != left.length && rsv != right.length){
        if(left[lsv] < right[rsv]){
        buffer[bufferPoint] = left[lsv];
        lsv++;
        }
        else{
        buffer[bufferPoint] = right[rsv];
        rsv++;
        }
        bufferPoint++;
        }
        if(left.length == lsv){
        for(int i = rsv; i < right.length; i++){
        buffer[bufferPoint] = right[i];
        bufferPoint++;
        }
        }else{
        for(int i = lsv; i < left.length; i++){
        buffer[bufferPoint] = left[i];
        bufferPoint++;
        }
        }
        return buffer;
        }

        }