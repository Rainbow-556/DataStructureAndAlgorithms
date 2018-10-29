package com.datastructureandalgorithms.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.util.FLogger;

import java.util.Random;

/**
 * Created by lixiang on 2018/6/29.<br/>
 */
public final class SortActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        findViewById(R.id.btn_quick_sort).setOnClickListener(this);
        findViewById(R.id.btn_bubble_sort).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int[] arr = createArr(10);
        switch (v.getId()) {
            case R.id.btn_quick_sort:
                printArr("pre", arr);
                quickSort(arr, 0, arr.length - 1);
                printArr("after", arr);
                break;
            case R.id.btn_bubble_sort:
                printArr("pre", arr);
                bubbleSort(arr);
                printArr("after", arr);
                break;
        }
    }

    /**
     * 快排思想：在待排序的数组中选头或者尾部的元素作为基数(以下选择头部第一个元素)，定义两个变量i，j。
     * j从end开始从右往左扫描，如果遇到比基数小的直接与i进行交换，然后执行i的从左到右扫描
     * i从start开始也就是从左向右扫描，如果遇到比基数大的则直接与j进行交换
     * 以上两个步骤循环，直到i和j相遇时，此时i和j的位置标识为k，则k左边的数都比k小，k右边的数都比k大，然后对左右两部分的数据分别进行快排，
     * 如果发现某一个部分只有一个元素时，则不需要排，否则对这部分的数进行快排
     * @param arr
     * @param start
     * @param end
     */
    private void quickSort(int[] arr, int start, int end) {
        // 当某个部分只剩下一个或者没有元素时，则该部分不需要排序
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        // 基数
        int base = arr[start];
        // 知道i和j相遇才跳出循环
        while (i < j) {
            // 从j处开始从右往左扫描，直到某个位置的元素比base小，则把该位置上的元素赋值给角标为i的元素
            while (i < j && arr[j] > base) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                // 赋值之后i向右移一位
                i++;
            }
            // 此时从i处开始从左往右扫描，直到某个位置上的元素比base大，则把该位置上的元素赋值给角标为j的元素
            while (i < j && arr[i] < base) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                // 赋值之后j往左移一位
                j--;
            }
        }
        // 跳出循环后，则代表i和j相遇了，此时直接把角标为i的元素赋值为base
        arr[i] = base;
        // 执行到这里，表示角标i左边的元素都比base小，而角标i右边的元素都比i大，从而把一个无序数组分离成了两个部分
        // 然后对这两个部分分别再进行快速排序
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    private static int[] createArr(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    private void printArr(String msg, int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg).append(": ");
        sb.append("[");
        for (int i : arr) {
            sb.append(i).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        FLogger.msg(sb.toString());
    }
}
