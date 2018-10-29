package com.datastructureandalgorithms.app.link;

import com.datastructureandalgorithms.app.util.FLogger;

/**
 * Created by lixiang on 2018/5/30.
 */
public class LinkNode {
    public String data;
    public LinkNode next;

    public LinkNode(String data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public static LinkNode createLink(int len) {
        LinkNode pre = new LinkNode("0", null);
        LinkNode head = pre;
        for (int i = 1; i < len; i++) {
            LinkNode node = new LinkNode(String.valueOf(i), null);
            pre.next = node;
            pre = node;
        }
        return head;
    }

    public static void printLink(LinkNode head) {
        LinkNode cur = head;
        while (cur != null) {
            FLogger.msg(cur);
            cur = cur.next;
        }
    }
}
