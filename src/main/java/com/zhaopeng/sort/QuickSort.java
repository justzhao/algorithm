package com.zhaopeng.sort;

/**
 * Created by zhaopeng on 2017/6/13.
 */
public class QuickSort {


    public void quickSort(int a[], int start, int end) {
        if (start > end) {
            return;
        }
        int low = start;
        int high = end;
        int b = a[start];
        while (low < high) {
            // 小的在左边,大的在右边
            while (low < high && a[high] >= b) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
                low++;
            }
            while (low < high && a[low] <= b) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
                high--;
            }
        }
        a[low] = b;

        quickSort(a, start, low - 1);
        quickSort(a, low + 1, end);

    }

    public static void main(String args[]) {
        int a[] = new int[10];

        int b[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        QuickSort s = new QuickSort();
        s.quickSort(b, 0, b.length - 1);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
