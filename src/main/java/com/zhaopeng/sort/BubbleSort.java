package com.zhaopeng.sort;

/**
 * Created by zhaopeng on 2017/6/14.
 */
public class BubbleSort {

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(int a[]) {

        boolean flag = false;
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    swap(a, j, j + 1);
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    public static void main(String args[]) {
        int a[] = new int[10];

        int b[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        BubbleSort s = new BubbleSort();
        s.sort(b);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
