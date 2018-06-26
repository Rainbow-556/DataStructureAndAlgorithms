package com.datastructureandalgorithms.app.tree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.R;
import com.datastructureandalgorithms.app.util.FLogger;

import java.util.ArrayDeque;

/**
 * Created by lixiang on 2018/6/26.<br/>
 */
public final class TreePracticeActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        findViewById(R.id.btn_level_order_traversal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_level_order_traversal:
                levelOrderTraversal(null);
                break;
        }
    }

    /**
     * 二叉树广度遍历，是从树根层层往下遍历，使用队列实现
     */
    private void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.remove();
            FLogger.msg(node.data);
            if (node.leftChild != null) {
                deque.add(node.leftChild);
            }
            if (node.rightChild != null) {
                deque.add(node.rightChild);
            }
        }
    }
}
