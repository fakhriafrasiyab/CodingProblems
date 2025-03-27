package com.example.newChapterInLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePath {

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobTime(graph, bob, -1, 0, bobTime);

        return 0;
    }


    private static void findBobTime(List<Integer>[] graph, int time, int node, int parent, int[] bobTime) {
        bobTime[node] = time;

        for (int neighbor : graph[node]) {
            if (neighbor != parent)
                findBobTime(graph, time + 1, node, parent, bobTime);
        }
    }
}
