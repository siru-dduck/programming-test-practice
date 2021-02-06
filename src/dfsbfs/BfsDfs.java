package dfsbfs;

import java.util.*;
import java.util.stream.IntStream;

class Graph {
    Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        IntStream.range(0,size).forEach(i -> {
            nodes[i] = new Node(i);
        });
    }

    // 노드를 논리적으로 이어주는 힘수 => 노드간의 간선추가
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void clearMarked() {
        Arrays.stream(nodes).forEach(node -> {
            node.marked = false;
        });
    }

    void visit(Node n) {
        System.out.print(n.data + ", ");
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            currentNode.adjacent.forEach(node -> {
                if(!node.marked) {
                    stack.push(node);
                    node.marked = true;
                }
            });
            visit(currentNode);
        }
        clearMarked();
    }

    void dfsWithRecursion() {
        dfsWithRecursion(0);
    }

    void dfsWithRecursion(int index) {
        Node node = nodes[index];
        dfsWithRecursion(node);
        clearMarked();
    }

    void dfsWithRecursion(Node node) {
        visit(node);
        node.marked = true;
        node.adjacent.forEach(n->{
            if(!n.marked){
                dfsWithRecursion(n);
            }
        });
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            currentNode.adjacent.forEach(node -> {
                if(!node.marked) {
                    queue.offer(node);
                    node.marked = true;
                }
            });
            visit(currentNode);
        }
        clearMarked();
    }


    class Node{
        int data;
        List<Node>  adjacent;
        boolean marked; // 노드에 방문했는지에 대한 여부

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }
    }
}
/*
Test with below Graph1 AND Graph2
@Graph1
            0
          /   \
         1     2
        / \    / \
       3  4   5   6
      / \     /
     7  8    9
 -----------------------
 @Graph2
   0
  /
 1 -- 3    7
 |  / | \ /
 | /  |  5
 2 -- 4   \
           6 - 8
 */
public class BfsDfs {
    public static void main(String[] args) {

        Graph graph1 = new Graph(10);
        Graph graph2 = new Graph(9);

        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,3);
        graph1.addEdge(1,4);
        graph1.addEdge(2,5);
        graph1.addEdge(2,6);
        graph1.addEdge(3,7);
        graph1.addEdge(3,8);
        graph1.addEdge(5,9);

        graph2.addEdge(0,1);
        graph2.addEdge(1,2);
        graph2.addEdge(1,3);
        graph2.addEdge(2,4);
        graph2.addEdge(2,3);
        graph2.addEdge(3,4);
        graph2.addEdge(3,5);
        graph2.addEdge(5,6);
        graph2.addEdge(5,7);
        graph2.addEdge(6,8);

        System.out.println("@Graph1");
        System.out.println("DFS:");
        graph1.dfs();
        System.out.println();
        System.out.println("DFS with Recursion:");
        graph1.dfsWithRecursion();
        System.out.println();
        System.out.println("BFS:");
        graph1.bfs();
        System.out.println();

        System.out.println("@Graph2");
        System.out.println("DFS:");
        graph2.dfs();
        System.out.println();
        System.out.println("DFS with Recursion:");
        graph2.dfsWithRecursion();
        System.out.println();
        System.out.println("BFS:");
        graph2.bfs();
    }
}
