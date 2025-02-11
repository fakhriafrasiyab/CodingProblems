package com.example.interview;

public class LowestCommonAncestor {

//    The Lowest Common Ancestor (LCA) of two nodes p and q in a Binary Tree
//    is the lowest node in the tree that has both p and q as descendants.

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {

    }
}
