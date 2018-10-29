package com.datastructureandalgorithms.app.forofferbook;

import com.datastructureandalgorithms.app.link.LinkNode;
import com.datastructureandalgorithms.app.util.FLogger;

import java.util.Stack;

/**
 * Created by lixiang on 2018/10/29.<br/>
 * 题目：输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public final class ForOffer_3 {
    public static void reversePrintLink() {
        LinkNode head = LinkNode.createLink(5);
        LinkNode.printLink(head);
        Stack<LinkNode> stack = new Stack<>();
        stack.push(head);
        LinkNode node = head.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            LinkNode pop = stack.pop();
            FLogger.msg(pop.data);
        }
    }

    public static void reverseLink() {
        LinkNode head = LinkNode.createLink(5);
        LinkNode.printLink(head);
        LinkNode pre = head, cur = head.next;
        head.next = null;
        while (cur != null) {
            LinkNode next = cur.next;
            cur.next = pre;
            if (next == null) {
                head = cur;
            }
            pre = cur;
            cur = next;
        }
        LinkNode.printLink(head);
    }
}
