package com.example.newChapterInLife;

import java.util.ArrayList;
import java.util.List;

public class NumCoursesPrerequisites {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        int[] visitedNode = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adjList, visitedNode)) return false;
        }

        return true;
    }

    public static boolean dfs(int node, List<List<Integer>> adjList, int[] visitedNode) {
        if (visitedNode[node] == 2) return false;
        if (visitedNode[node] == 1) return true;

        visitedNode[node] = 1;
        for (int neighbour : adjList.get(node)) {
            if (dfs(neighbour, adjList, visitedNode)) return false;
        }

        visitedNode[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(2, prerequisites));
    }
}
