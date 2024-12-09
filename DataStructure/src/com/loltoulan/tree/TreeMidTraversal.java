package com.loltoulan.tree;

import java.util.Stack;

/**
 * 左子树 ---> 根结点 ---> 右子树
 */
@SuppressWarnings("ALL")
public class TreeMidTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        StringBuilder sb = new StringBuilder();
        System.out.println(midTraversalRecursion(root, sb));
        System.out.println(midTraversal(root));
    }

    public static String midTraversalRecursion(TreeNode root,StringBuilder sb) {
        if (root == null) {
            return sb.toString();
        }
        midTraversalRecursion(root.left, sb);
        midTraversalRecursion(root.right, sb);
        sb.append(root.val).append(" ");
        return sb.toString();
    }

    public static String midTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();

        StringBuilder sb = new StringBuilder();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!result.isEmpty()) {
            sb.append(result.pop().val + " "); // 输出节点
        }
        return sb.toString();
    }

}
