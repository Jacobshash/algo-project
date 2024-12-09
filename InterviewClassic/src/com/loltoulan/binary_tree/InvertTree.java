package com.loltoulan.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        StringBuilder sb = new StringBuilder();
        System.out.println(TreeNode.levelOrderTree(invertTree(root), sb));
    }

    public static TreeNode invertTreeFromBFS(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            if(tmp.left!=null) {
                queue.add(tmp.left);
            }
            if(tmp.right!=null) {
                queue.add(tmp.right);
            }
        }
        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
