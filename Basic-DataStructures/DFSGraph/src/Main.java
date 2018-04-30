public class Main {

    public static void main(String[] args){
     initDFS();
    }

    public static void initDFS(){
        Node[] nodys = {new Node(1),new Node(3),new Node(4),new Node(5),new Node(7)};
        int[][] matrix = {{0,1,1,0,0},{0,0,0,1,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0}};
        DFS dfs = new DFS(nodys,matrix);
        dfs.printNodePaths(nodys[0]);
    }
}
