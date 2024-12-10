package com.loltoulan.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    // 反转+比较
    public static boolean isSymmetricFromInvertAndCompare(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 反转二叉树
        TreeNode invertRoot = invertTree(right);
        // 比较二叉树是否相同
        return isSameTree(invertRoot, left);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 减少反转二叉树的步骤，左和右比，右和左比
    public static boolean isSymmetricFromCompare(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }

    // 广度优先搜索
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);

            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

}
