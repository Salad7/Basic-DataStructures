public class Main {
    public static void main(String[] args){
        //int[] unsorted = {4, -3, 3, 5, 1, -1, 2, -2};
        int[] unsorted = {-5,-1,-2,-3,-4};

        HeapSort heap = new HeapSort(unsorted);
        heap.runHeap();
        heap.pop();
        //heap.sortItems();
        heap.printHeap();

    }
}
