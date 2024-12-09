package com.loltoulan.tree;

import java.util.Stack;

/**
 * 根结点 ---> 左子树 ---> 右子树
 */
@SuppressWarnings("ALL")
public class TreePreTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        StringBuilder sb = new StringBuilder();
        System.out.println(preTraversalRecursion(root, sb));
        System.out.println(preTraversal(root));
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

    public static String preTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                sb.append(root.val).append(",");
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }
        return sb.toString();
    }

}
