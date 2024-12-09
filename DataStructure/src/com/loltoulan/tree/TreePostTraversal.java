package com.loltoulan.tree;

import java.util.Stack;

/**
 * 左子树 ---> 右子树 ---> 根结点
 */
@SuppressWarnings("ALL")
public class TreePostTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        StringBuilder sb = new StringBuilder();
        System.out.println(postTraversalRecursion(root, sb));
        System.out.println(postTraversal(root));
    }

    public static String postTraversalRecursion(TreeNode root,StringBuilder sb) {
        if (root == null) {
            return sb.toString();
        }
        postTraversalRecursion(root.left, sb);
        sb.append(root.val).append(",");
        postTraversalRecursion(root.right, sb);
        return sb.toString();
    }

    public static String postTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                sb.append(root.val).append(",");
                root = root.right;
            }
        }
        return sb.toString();
    }

}
