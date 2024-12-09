package com.loltoulan.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        // root.right.right.right = new TreeNode(7);
        // root.right.right.right.right = new TreeNode(7);
        // root.left.left.left = new TreeNode(8);
        // root.left.left.left.left = new TreeNode(8);
        // System.out.println(maxDepth(root));

        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(9);
        // root.right = new TreeNode(20);
        // root.right.left = new TreeNode(15);
        // root.right.right = new TreeNode(7);
        // System.out.println(maxDepth(root));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(maxDepthFromDFS(root));
    }

    // 广度优先
    public static int maxDepthFromBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int deepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode pop = queue.poll();
                if (pop != null) {
                    if (pop.left != null) {
                        queue.offer(pop.left);
                    }
                    if (pop.right != null) {
                        queue.offer(pop.right);
                    }
                }
            }
            deepth++;
        }
        return deepth;
    }

    // 深度优先
    public static int maxDepthFromDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = dfs(root.left);
        int rightDeep = dfs(root.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }



}
