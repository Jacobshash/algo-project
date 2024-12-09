package com.loltoulan.tree;

public class DFSTreeTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        StringBuilder sb = new StringBuilder();
        System.out.println(dfs(root, sb));
    }

    public static String dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.toString();
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        return sb.toString();
    }

}
