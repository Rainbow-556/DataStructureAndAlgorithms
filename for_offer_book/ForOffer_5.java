package com.datastructureandalgorithms.app.forofferbook;

import com.datastructureandalgorithms.app.util.FLogger;

import java.util.Stack;

/**
 * Created by lixiang on 2018/10/29.<br/>
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。<br/>
 * 思路：一个栈用于入队，一个栈用于出队
 */
public final class ForOffer_5 {
    public static void twoStackImplQueue() {
        MyQueue<String> queue = new MyQueue<>();
        queue.appendTail("1");
        queue.appendTail("2");
        queue.appendTail("3");
        queue.appendTail("4");
        queue.appendTail("5");
        String deleted = queue.deleteHead();
        FLogger.msg("a: " + deleted);
        queue.appendTail("6");
        while (!queue.isEmpty()) {
            deleted = queue.deleteHead();
            FLogger.msg("b: " + deleted);
        }
    }

    private static class MyQueue<T> {
        Stack<T> stack_1 = new Stack<>(), stack_2 = new Stack<>();

        void appendTail(T data) {
            if (data == null) {
                return;
            }
            stack_1.push(data);
        }

        T deleteHead() {
            if (!stack_2.isEmpty()) {
                return stack_2.pop();
            }
            if (!stack_1.isEmpty()) {
                while (!stack_1.isEmpty()) {
                    T pop = stack_1.pop();
                    stack_2.push(pop);
                }
                return stack_2.pop();
            }
            return null;
        }

        boolean isEmpty() {
            return stack_1.isEmpty() && stack_2.isEmpty();
        }
    }
}
