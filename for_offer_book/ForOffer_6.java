package com.datastructureandalgorithms.app.forofferbook;

import com.datastructureandalgorithms.app.util.FLogger;

/**
 * Created by lixiang on 2018/10/30.<br/>
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如数组{3,4,5,1,2｝为｛1,2,3,4,5}的一个旋转，该数组的最小值为1。<br/>
 */
public final class ForOffer_6 {
    public static void findMin() {
        int[] arr = {5, 6, 7, 8, 9, -2, -1, 0, 1};
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            // 二分查找
            int middle = (low + high) / 2;
            FLogger.msg(low + ", " + middle + ", " + high);
            int middleNum = arr[middle];
            if (middleNum >= arr[low]) {
                // 中间的元素大于低位，则表示min位于middle的右侧
                low = middle;
            } else if (middleNum <= arr[high]) {
                // 中间的元素小于高位，则表示min位于middle的左侧
                high = middle;
            }
            if (high - low <= 1) {
                // 高位和低位相等或相邻时，表示最小的数就在它们中间
                int min = arr[high] > arr[low] ? arr[low] : arr[high];
                FLogger.msg("min=" + min);
                break;
            }
        }
    }
}
