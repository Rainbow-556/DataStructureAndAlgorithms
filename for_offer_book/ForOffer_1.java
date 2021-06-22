package com.datastructureandalgorithms.app.forofferbook;

/**
 * Created by lixiang on 2018/10/29.<br/>
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路：由于这个二维数组的元素排列特性，直接取右上角的元素num和target比较，如果num和target相等，则直接返回；
 * 如果num比target大，则说明该位置下面的元素全都比target大，所以排除该列；如果num比target小，则说明该位置所在行的之前的所有
 * 元素都比target小，所以排除该行，依次去排除
 * <p>
 * 测试数据：int[][] arr = {{1, 2, 3}, {2, 3, 4}, {5, 6, 10}};
 */
public final class ForOffer_1 {
    public static boolean searchNumber(int[][] arr, int target) {
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) {
            return false;
        }
        int col = arr[0].length - 1, row = 0, totalRows = arr.length;
        while (row < totalRows && col >= 0) {
            int num = arr[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
