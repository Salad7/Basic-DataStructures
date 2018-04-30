public class DFS {
    Node[] nodes;
    public DFS(Node[] nodes,int[][] adjMatrix){
        this.nodes = nodes;
        for(int row = 0; row < adjMatrix[0].length; row++){
            for(int col = 0; col < adjMatrix.length; col++){
                if (adjMatrix[row][col] == 1){
                    nodes[row].connenctions.add(nodes[col]);
                }
            }
        }
    }

    public void printNodePaths(Node current){
        System.out.println("Value: "+current.val);
        current.isVisited = true;
        for (Node n: current.connenctions
             ) {
            if(n.isVisited == false){
                printNodePaths(n);
            }
        }
    }



}
