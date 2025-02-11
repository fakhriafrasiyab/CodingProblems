package com.example.newChapterInLife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    List<Node> neighbors;

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraphDFS {

    public static Node dfs(Node node, Map<Node, Node> connectionMap) {
        if (connectionMap.containsKey(node)) return connectionMap.get(node);
        Node copy = new Node(node.val);
        connectionMap.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, connectionMap));
        }

        return copy;
    }


    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> connectionMap = new HashMap<>();
        return dfs(node, connectionMap);

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n2.neighbors.add(n4);
        n3.neighbors.add(n1);
        n3.neighbors.add(n4);
        n4.neighbors.add(n2);
        n4.neighbors.add(n3);

        Node clonedGraph = cloneGraph(n1);
        System.out.println("Cloned Graph Root Value: " + clonedGraph.val);
    }

}
