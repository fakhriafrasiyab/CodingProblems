package com.example.tictactoe.graph;

import java.util.*;

public class BFSShortestPath {

    // Method to perform BFS and find the shortest path
    public static List<String> bfsShortestPath(Map<String, List<String>> graph, String start, String target) {
        Queue<Node> queue = new LinkedList<>(); // Queue for BFS
        Set<String> visited = new HashSet<>();  // Set to track visited nodes

        // Initialize the queue with the starting node
//        System.out.println(Arrays.asList(start));
        queue.add(new Node(start, Arrays.asList(start)));
//        printQueue(queue);
        visited.add(start); // Mark the start node as visited

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll(); // Dequeue the first element

            // Check if we've reached the target
            if (currentNode.name.equals(target)) {
                return currentNode.path; // Return the path to the target
            }

            // Explore neighbors
//            System.out.println(graph);
            for (String neighbor : graph.get(currentNode.name)) {
                if (!visited.contains(neighbor)) { // If not visited
                    visited.add(neighbor); // Mark as visited
                    // Enqueue the neighbor with the updated path
                    List<String> newPath = new ArrayList<>(currentNode.path);
                    newPath.add(neighbor);
                    queue.add(new Node(neighbor, newPath));
                }
            }
        }
        return Collections.emptyList(); // If no path is found
    }

    // Helper class to hold a node and the path taken to reach it
    static class Node {
        String name;
        List<String> path;

        Node(String name, List<String> path) {
            this.name = name;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        // Example graph as an adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "D", "E"));
        graph.put("D", Arrays.asList("B", "C", "F", "G"));
        graph.put("E", Arrays.asList("C"));
        graph.put("F", Arrays.asList("D"));
        graph.put("G", Arrays.asList("D"));

        // Find the shortest path from A to G
        String startNode = "A";
        String targetNode = "G";
        List<String> result = bfsShortestPath(graph, startNode, targetNode);

        if (!result.isEmpty()) {
            System.out.println("The shortest path from " + startNode + " to " + targetNode + " is: " + String.join(" -> ", result));
        } else {
            System.out.println("No path exists from " + startNode + " to " + targetNode + ".");
        }
    }

    public static void printQueue(Queue<Node> queue) {
        System.out.println("Queue elements:");
        for (Node node : queue) {
            System.out.println("Node: " + node.name + ", Path: " + node.path);
        }
    }
}
