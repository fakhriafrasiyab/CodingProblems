package com.example.interview;


import java.util.List;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = leftDepth(root.left);
        int rightDepth = rightDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int leftDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + leftDepth(node.left);
    }

    public int rightDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + leftDepth(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxDepthOfBinaryTree maxDepth = new MaxDepthOfBinaryTree();
        int result = maxDepth.maxDepth(root);
        System.out.println(result);
    }
}
