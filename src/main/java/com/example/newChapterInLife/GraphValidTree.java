package com.example.newChapterInLife;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {

    public static boolean hasCycle(int node, int parent, Set<Integer> visited, List<List<Integer>> adjList) {
        if (visited.contains(node)) return true;
        visited.add(node);
        for (int neighbor : adjList.get(node)) {
            if (neighbor == parent) continue;
            if (hasCycle(neighbor, node, visited, adjList)) return true;
        }

        return false;
    }

    public static boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) return false;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (hasCycle(0, -1, visited, adjList)) return false;


        return visited.size() == n;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(5, edges));
    }
}
