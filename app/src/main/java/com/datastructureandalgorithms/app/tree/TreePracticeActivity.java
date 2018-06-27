package com.datastructureandalgorithms.app.tree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.R;
import com.datastructureandalgorithms.app.util.FLogger;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by lixiang on 2018/6/26.<br/>
 */
public final class TreePracticeActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        findViewById(R.id.btn_level_order_traversal).setOnClickListener(this);
        findViewById(R.id.btn_pre_order_traversal).setOnClickListener(this);
        findViewById(R.id.btn_middle_order_traversal).setOnClickListener(this);
        findViewById(R.id.btn_last_order_traversal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_level_order_traversal:
                levelOrderTraversal(null);
                break;
            case R.id.btn_pre_order_traversal:
                preOrderTraversal(null);
                break;
            case R.id.btn_middle_order_traversal:
                middleOrderTraversal(null);
                break;
            case R.id.btn_last_order_traversal:
                lastOrderTraversal(null);
                break;
        }
    }

    /**
     * 二叉树广度遍历，是从树根层层往下遍历，使用队列可以实现
     */
    private void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            FLogger.msg(node.data);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
    }

    /**
     * 二叉树先序遍历，非递归，因为都需要回溯去找到节点的右子树，所以需要使用栈来暂存父节点，中序和后续遍历同样需要使用栈
     * @param root
     */
    private void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                FLogger.msg(node.data);
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                node = pop.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历，非递归，使用栈可以实现
     * @param root
     */
    private void middleOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // 两个循环条件
        while (node != null || !stack.isEmpty()) {
            // 先把左子树不为空的全部入栈
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            // 走到这里时，说明已经遍历到了左边最下面的叶子节点，此时直接出栈访问该节点，然后开始遍历该节点的右子树
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                FLogger.msg(pop.data);
                node = pop.rightChild;
            }
        }
    }

    /**
     * 二叉树后序遍历，非递归，使用栈可以实现
     * @param root
     */
    private void lastOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 游标节点
        TreeNode node = root;
        // 最近访问的节点
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                // 使用peek查看栈顶元素，不出栈
                TreeNode peek = stack.peek();
                // 节点的右孩子为空 或者 节点的右孩子和最近访问的节点相等则表示该节点的右子树已经访问完了，在以上两个条件下，可以直接访问该节点
                if (peek.rightChild == null || peek.rightChild == lastVisit) {
                    // 出栈
                    stack.pop();
                    FLogger.msg(peek.data);
                    //
                    lastVisit = peek;
                    // 把node置为空，让下一轮再次考察栈顶元素
                    node = null;
                } else {
                    node = peek.rightChild;
                }
            }
        }
    }
}
