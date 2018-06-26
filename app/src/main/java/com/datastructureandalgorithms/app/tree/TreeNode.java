package com.datastructureandalgorithms.app.tree;

/**
 * Created by lixiang on 2018/6/26.<br/>
 */
public class TreeNode {
    public TreeNode leftChild, rightChild;
    public int data;

    public TreeNode() {}

    public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(50, null, null);
        TreeNode node = root;
        int count = 1;
        while (node != null && count <= 10) {

            count++;
        }
        return root;
    }
}
