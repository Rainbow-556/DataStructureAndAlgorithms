package com.datastructureandalgorithms.app.link;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.R;
import com.datastructureandalgorithms.app.util.FLogger;

/**
 * Created by lixiang on 2018/5/30.
 */
public class LinkActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        findViewById(R.id.btn_reverse_link).setOnClickListener(this);
    }

    /**
     * 反转链表
     */
    private void reverseLink() {
        LinkNode head = createLink();
        FLogger.msg("before");
        printLink(head);
        // 前一个
        LinkNode pre = head;
        // 当前
        LinkNode cur = head.next;
        while (cur != null) {
            // 下一个
            LinkNode next = cur.next;
            // 每次逆转一个指针
            cur.next = pre;
            // 往后移动
            pre = cur;
            cur = next;
        }
        head.next = null;
        // 新的head
        head = pre;
        FLogger.msg("after");
        printLink(head);
    }

    private void printLink(LinkNode head) {
        LinkNode cur = head;
        while (cur != null) {
            FLogger.msg(cur);
            cur = cur.next;
        }
    }

    private LinkNode createLink() {
        LinkNode pre = new LinkNode("0", null);
        LinkNode head = pre;
        for (int i = 1; i < 5; i++) {
            LinkNode node = new LinkNode(String.valueOf(i), null);
            pre.next = node;
            pre = node;
        }
        return head;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reverse_link:
                reverseLink();
                break;
        }
    }
}
