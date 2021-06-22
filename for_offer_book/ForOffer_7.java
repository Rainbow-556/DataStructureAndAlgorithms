package com.datastructureandalgorithms.app.forofferbook;

/**
 * Created by lixiang on 2018/10/30.<br/>
 * 写一个函数，输入n，求斐波那契数列的第n项值。<br/>
 * 斐波那契数列的定义如下：<br/>
 * F0 = 0;<br/>
 * F1 = 1;<br/>
 * Fn = F(n - 1) + F(n - 2);
 */
public final class ForOffer_7 {
    /**
     * 递归实现
     * @param n
     * @return
     */
    public static long fibonacci_1(int n) {
        long result;
        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fibonacci_1(n - 1) + fibonacci_1(n - 2);
        }
        return result;
    }

    /**
     * 非递归方式
     * @param n
     * @return
     */
    public static long fibonacci_2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        // n - 1
        long pre = 1;
        // n - 2
        long prePre = 0;
        long curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = pre + prePre;
            prePre = pre;
            pre = curr;
        }
        return curr;
    }
}
