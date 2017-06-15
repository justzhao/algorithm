package com.zhaopeng.sort;

/**
 * 归并排序
 * Created by zhaopeng on 2017/6/15.
 */
public class MergeSort {


    public void merge(int[] array, int low, int mid, int high) {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        int[] temp = new int[high - low + 1]; // array2是临时合并序列
        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
                k++;
            } else {
                temp[k] = array[j];
                j++;
                k++;
            }
        }
        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }
        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            temp[k] = array[j];
            j++;
            k++;
        }
        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = temp[k];
        }
    }

    public void spilt(int[] array, int gap, int length) {
        int i = 0;
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length) {
            merge(array, i, i + gap - 1, length - 1);
        }
    }

    public int[] sort(int[] list) {
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            spilt(list, gap, list.length);
            System.out.print("gap = " + gap + ":\t");
            printArray(list);
        }
        return list;
    }

    private void printArray(int b[]) {

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String args[]) {
        int a[] = new int[10];

        int b[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        MergeSort s = new MergeSort();
        s.sort(b);
        s.printArray(b);

    }
}
