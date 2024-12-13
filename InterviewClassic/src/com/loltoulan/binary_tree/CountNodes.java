package com.loltoulan.binary_tree;

public class CountNodes {

    public static void main(String[] args) {
        CountNodes countNodes = new CountNodes();
        int result = countNodes.countNodes(TreeNode.createTree());
        System.out.println(result);
    }

    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return count;
        }
        count++;
        if (root.right != null) {
            countNodes(root.right);
        }
        if (root.left != null) {
            countNodes(root.left);
        }
        return count;
    }

    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        return preTraversalRecursion(root, sb).split(",").length;
    }

    public static String preTraversalRecursion(TreeNode root,StringBuilder sb) {
        if (root == null) {
            return sb.toString();
        }
        sb.append(root.val).append(",");
        preTraversalRecursion(root.left, sb);
        preTraversalRecursion(root.right, sb);
        return sb.toString();
    }

}
