package com.example.interview;

import java.util.*;

//Given a binary tree, return the level order traversal of its nodes’ values (i.e., from left to right, level by level).
//[[3], [9,20], [15,7]]

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LevelOrderTraversal {

    public List<List<Integer>> traverseTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<Integer>> traverseTree = traversal.traverseTree(root);
        System.out.println(traverseTree);
    }
}
