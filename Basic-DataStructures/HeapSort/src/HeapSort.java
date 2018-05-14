public class HeapSort {
    int[] B;
    int[] orig;
    int openSpot;
    public HeapSort(int[] A){
        this.orig = A;
        B= new int[orig.length];
        openSpot = 1;
    }

    public void runHeap(){
        for(int i = 1; i < B.length; i++){
            add(orig[i]);
            //System.out.println("Adding: "+orig[i]);
        }
    }

    public void printMaxHeap(int limit){
        for(int i = 1; i < limit; i++){
            System.out.println(B[i]);
        }
    }

    public void pop(){
        for(int i = B.length-1; i >= 1; i--) {
            System.out.println(B[1]);
            System.out.println("");
            System.out.println("");
//            printHeap();
            printMaxHeap(i);
            swap(i,1);
            System.out.println("");
            System.out.println("");
            if(i-1 > 0) {
                recursiveTraverse(1, i - 1);
            }


        }

    }
    public void recursiveTraverse(int current, int swapSpot){
        int lc = current+1;
        int rc = current+2;
        if(rc <= swapSpot){
            if(B[rc] > B[lc] && B[rc] > B[current]){
                    swap(rc,current);
                    recursiveTraverse(rc,swapSpot);
            }
            else if(B[lc] > B[current]){
                swap(lc,current);
                recursiveTraverse(lc,swapSpot);
            }
        }
        else if(lc <= swapSpot){
            if(B[lc] > B[current]) {
                swap(lc, current);
                recursiveTraverse(lc, swapSpot);
            }
        }
    }

    public void printHeap(){
        for(int i = 1; i < B.length; i++){
            System.out.println(B[i]);
        }
    }

    public void sortItems(){
        for(int i = B.length-1; i >= 1; i--){
            swap(1,i);
            reheapify(1,i-1);
        }
    }

    public void reheapify(int currentIndex, int endIndex){
        int left = currentIndex+1;
        int right = currentIndex+2;
        if(right < endIndex){
            if(B[right] > B[left]){
                if(B[right] > B[currentIndex]){
                    swap(right,currentIndex);
                    reheapify(right,endIndex);
                }
            }
            else{
                if(B[left] > B[currentIndex]){
                    swap(left,currentIndex);
                    reheapify(left,endIndex);
                }
            }
        }
        else if(left < endIndex){
            if(B[left] > B[currentIndex]){
                swap(left,currentIndex);
                reheapify(left,endIndex);
            }
        }
    }

    public void add(int n){
        if(openSpot == 1){
            B[1] = n;
        }
        else {
            B[openSpot] = n;
            int current = openSpot;
            int parent = openSpot/2;
            while(parent != 0 && B[current] > B[parent]){
                swap(parent,current);
                current = parent;
                parent = current/2;
            }
        }
        openSpot+=1;
    }


    public void swap(int a, int b){
        int temp = B[a];
        B[a] = B[b];
        B[b] = temp;
    }
}
