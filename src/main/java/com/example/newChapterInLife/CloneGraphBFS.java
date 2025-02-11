package com.example.newChapterInLife;

import java.util.*;

public class CloneGraphBFS {


    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> connectionMap = new HashMap<>();

        Node copy = new Node(node.val);
        connectionMap.put(node, copy);
        queue.offer(copy);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!connectionMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    connectionMap.put(current, neighbor);
                }
                connectionMap.get(current).neighbors.add(neighbor);
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        //[[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node2.neighbors.add(node4);
        node4.neighbors.add(node2);

        node1.neighbors.add(node3);
        node3.neighbors.add(node1);

        Node cloneGraph = cloneGraph(node2);
        System.out.println(cloneGraph.val);
        printGraph(node2, new HashSet<>());
    }

    public static void printGraph(Node node, Set<Node> visitedNode) {
        if (node == null || visitedNode.contains(node)) return;

        visitedNode.add(node);
        System.out.print("NODE: " + node.val + " -> ");

        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visitedNode);
        }
    }
}
