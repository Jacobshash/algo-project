package com.loltoulan.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {

    public static void main(String[] args) {
        // 测试用例1: 两个空树
        System.out.println((isSameTree(null, null)));

        // 测试用例2: 一个空树，一个非空树
         System.out.println(isSameTree(new TreeNode(1), null));
         System.out.println(isSameTree(null, new TreeNode(1)));

        // 测试用例3: 结构和值都相同的树
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println(isSameTree(tree1, tree2));

        // 测试用例4: 结构相同但值不同的树
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(4);

         System.out.println(isSameTree(tree1, tree3));

        // 测试用例5: 结构不同但值相同的树
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);

         System.out.println(isSameTree(tree1, tree4));
    }

    // 深度优先
    public static boolean isSameTreeFromDFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTreeFromDFS(p.left, q.left) && isSameTreeFromDFS(p.right, q.right);
    }

    // 广度优先
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode pPoll = queue.poll();
            TreeNode qPoll = queue.poll();
            if (pPoll == null && qPoll == null) {
                continue;
            }
            if (pPoll == null || qPoll == null) {
                return false;
            }

            if (pPoll.val != qPoll.val) {
                return false;
            }
            queue.offer(pPoll.left);
            queue.offer(qPoll.left);
            queue.offer(pPoll.right);
            queue.offer(qPoll.right);
        }
        return true;
    }

}
