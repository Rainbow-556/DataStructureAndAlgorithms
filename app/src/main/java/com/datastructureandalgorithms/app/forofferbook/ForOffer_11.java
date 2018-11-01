package com.datastructureandalgorithms.app.forofferbook;

import com.datastructureandalgorithms.app.util.FLogger;

import java.util.Arrays;

/**
 * Created by lixiang on 2018/11/1.<br/>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数放到数组的前半部分，所有偶数放到数组的后半部分。
 */
public final class ForOffer_11 {
    public static void reorder() {
        // 类似于快排的处理
        int[] arr = {20, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int start = 0, end = arr.length - 1;
        while (start < end) {
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            if (start < end) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                end--;
                start++;
            }
        }
        FLogger.msg(Arrays.toString(arr));
    }
}
