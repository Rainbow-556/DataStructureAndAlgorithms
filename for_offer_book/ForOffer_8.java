package com.datastructureandalgorithms.app.forofferbook;

import com.datastructureandalgorithms.app.util.FLogger;

/**
 * Created by lixiang on 2018/10/30.<br/>
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制1001，有2位1。因此如果输入9，该函数输出2。
 */
public final class ForOffer_8 {
    public static void numberOfOne(int n) {
        // 一个int由4个字节组成，每个字节由8位二进制数组成，所以一个int有32位二进制数
        // 然后依次把n无符号向右移，得到的最低位和1相与，从结果就可以得知该位置上是否为1
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // n的最低位和1与，如果最低位为1，则加1，否则不加
            count += (n & 1);
            // n无符号右移1位
            n = n >>> 1;
        }
        FLogger.msg(count);
    }
}
