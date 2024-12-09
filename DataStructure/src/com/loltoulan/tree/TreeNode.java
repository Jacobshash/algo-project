package com.loltoulan.tree;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }


     public static TreeNode createTree(){
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);
         root.right = new TreeNode(3);
         root.right.left = new TreeNode(6);
         root.right.right = new TreeNode(7);
         return root;
     }


 }