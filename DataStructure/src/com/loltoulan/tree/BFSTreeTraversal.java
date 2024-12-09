package com.loltoulan.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeTraversal {


    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        StringBuilder sb = new StringBuilder();
        System.out.println(bfs(root, sb));
    }

    public static String bfs(TreeNode root, StringBuilder sb) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.val).append(" ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return sb.toString();
    }


}
