public class Main {
    public static void main(String[] args){
    //initRouteBetweenNodes(); 4.2
    //initMinimumHeightBST(); 4.3
    initPrintNumPaths();




    }

    public static void initRouteBetweenNodes(){
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        int[][] no = {{0,1,0,0,0,0},{0,0,1,0,0,0},{0,0,0,1,0,0},{0,0,0,0,1,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        StringNode[] nodes = {new StringNode("Mohamed"),new StringNode("James"),new StringNode("Cody"),new StringNode("Sam"),new StringNode("Nick"),new StringNode("Andrew")};
        nodes = routeBetweenNodes.getGraph(nodes,no);
        System.out.println(routeBetweenNodes.traverse(nodes[0],nodes[5]));
    }

    public static void initMinimumHeightBST(){
        BinarySearch binarySearch = new BinarySearch();
        int[] nodes = {1,2,3,4,5,6};
        binarySearch.beginBalancing(nodes);
    }

    public static void initPrintNumPaths(){
        LongestPathInGraph longestPathInGraph = new LongestPathInGraph();
    }




}
