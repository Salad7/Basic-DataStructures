public class RouteBetweenNodes {


    public static boolean traverse(StringNode start, StringNode find){
        if(start.name.equals(find.name)){
            return true;
        }
        start.isVisited = true;
        for (StringNode connection: start.connections
                ) {
            if(!connection.isVisited){
                return traverse(connection,find);
            }
        }
        return false;
    }

    public static StringNode[] getGraph(StringNode[] nodes, int[][] coors){
        for(int i = 0; i < nodes.length; i++){
            for(int x =0; x < nodes.length; x++) {
                if(coors[i][x] == 1){
                    nodes[i].connections.add(nodes[x]);
                }
            }
        }
        return nodes;
    }

}
