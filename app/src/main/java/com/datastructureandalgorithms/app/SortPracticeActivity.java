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
public final class SortPracticeActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        findViewById(R.id.btn_quick_sort).setOnClickListener(this);
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
        }
    }

    /**
     * 快排思想：在待排序的数组中选头或者尾部的元素作为基数(以下选择头部第一个元素)，定义两个变量i，j。
     * i从end开始也就是从右向左扫描，如果遇到比基数小的则直接与j进行交换，然后执行j的从左向右扫描
     * j从begin开始从左往右扫描，如果遇到比基数大的直接与i进行交换，然后执行i的从右到左扫描
     * 以上两个步骤循环，直到i和j相遇时，此时i和j的位置标识为k，则k左边的数都比k小，k右边的数都比k大，然后对左右两部分的数据分别进行快排，
     * 如果发现某一个部分只有一个元素时，则不需要排，否则对这部分的数进行快排
     * @param arr
     * @param begin
     * @param end
     */
    private void quickSort(int[] arr, int begin, int end) {
        int base = arr[begin];
        int i = end, j = begin;
        int k;
        boolean lookI = true;
        while (j < i) {
            if (lookI) {
                if (arr[i] < base) {
                    swap(arr, i, j);
                } else {
                    i--;
                    continue;
                }
            }
            if (arr[j] > base) {
                swap(arr, j, i);
                lookI = true;
            } else {
                j++;
                lookI = false;
                continue;
            }
        }
        k = i;
        if (k - begin > 1) {
            quickSort(arr, begin, k - 1);
        }
        if (end - k > 1) {
            quickSort(arr, k + 1, end);
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
