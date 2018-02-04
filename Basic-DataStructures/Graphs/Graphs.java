import java.util.ArrayList;
import java.util.Queue;

public class Graphs {


    public static void main(String[] args){
        Graph g = new Graph();
        g.initGraph();


    }
    public static class Graph {
        static ArrayList<Node> edges;
        Graph(){
            edges = new ArrayList<>();
        }

        public static void initGraph(){
            Node a = new Node("A");
            Node b = new Node("B");
            Node c = new Node("C");
            Node d = new Node("D");
            a.addConnection(b);
            a.addConnection(d);
            b.addConnection(c);
            c.addConnection(b);
            d.addConnection(b);
            edges.add(a);
            edges.add(b);
            edges.add(c);
            edges.add(d);
            //System.out.println("Depth First");
            //DFS(a);
            System.out.println("Breadth First");
            BFS(a);
        }



        public static void DFS(Node current){
            System.out.println(current.name);
            current.isVisited = true;
            for (Node connection: current.connections
                 ) {
                if(!connection.isVisited){
                    DFS(connection);
                }
            }
        }

        public static void BFS(Node current){
            CustomQueue nodeQueue = new CustomQueue();
            current.isVisited = true;
            nodeQueue.enqueue(current);
            while(!nodeQueue.isEmpty()){
                Node r = nodeQueue.dequeue();
                System.out.println(r.name);
                for (Node connection: r.connections
                     ) {
                    if(!connection.isVisited){
                        connection.isVisited = true;
                        nodeQueue.enqueue(connection);
                    }
                }
            }
        }

        public static class CustomQueue{
            static Node first;
            static  Node last;
            CustomQueue(){
                first = null;
            }
            public  static void enqueue(Node n){
                if(first == null){
                    first = last = n;
                }
                else{
                    last.next = n;
                    last = last.next;
                }
            }

            public  static Node dequeue(){
                Node temp = first;
                first = first.next;
                return temp;

            }
            public static boolean isEmpty(){
                if(first == null){
                    return true;
                }
                return false;
            }

        }
    }

    public static class Node{
        String name;
        ArrayList<Node> connections;
        boolean isVisited;
        Node next;

        Node(String name){
            this.name = name;
            isVisited = false;
            connections = new ArrayList<>();
        }

        public void addConnection(Node c){
            connections.add(c);
        }
    }

}
