package com.datastructureandalgorithms.app.forofferbook;

import com.datastructureandalgorithms.app.link.LinkNode;

/**
 * Created by lixiang on 2018/11/1.<br/>
 * 题目：给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。
 */
public final class ForOffer_10 {
    public static LinkNode delete(LinkNode head, LinkNode toDeleted) {
        if (head == null || toDeleted == null) {
            return null;
        }
        if (head == toDeleted) {
            return head;
        }
        if (toDeleted.next == null) {
            // toDeleted位于链表的最后
            LinkNode pre = head;
            while (pre.next != toDeleted) {
                pre = pre.next;
            }
            pre.next = null;
        } else {
            // toDeleted位于链表的中间，直接用next的值覆盖toDeleted的值
            LinkNode next = toDeleted.next;
            toDeleted.data = next.data;
            toDeleted.next = next.next;
        }
        return head;
    }
}
