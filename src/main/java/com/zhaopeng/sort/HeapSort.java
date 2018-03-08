package com.zhaopeng.sort;

/**
 * 大堆排序
 * 索引为 i 的左孩子 为 2i+1
 * 右孩子 为 2i+2
 * Created by zhaopeng on 2017/6/12.
 */
public class HeapSort {
    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void buildHeap(int a[]) {


        int len = a.length;
        //  建立堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, len - 1);
        }
        // 调整堆
        for (int i = len - 1; i >= 0; i--) {
            swap(a, 0, i);
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            heapAdjust(a, 0, i - 1);
        }

    }

    public void heapAdjust(int a[], int start, int end) {

        if (start > end) {
            return;
        }

        int value = a[start];
        int left = 2 * start + 1;
        int c = start;
        for (; left <= end; c = left, left = 2 * left + 1) {
            //右孩子
            int right = left + 1;

            if (left < end && a[left] < a[right])
                left = right; //找出孩子节点较大的数
            if (value >= a[left])
                break;        // 调整结束
            else {//value <a[left]
                swap(a, c, left);
            }
        }
    }

    public static void main(String args[]){
        int a[]=new int[10];

        int b[]={20,30,90,40,70,110,60,10,100,50,80};

        HeapSort s=new HeapSort();
        s.buildHeap(b);

        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }

    }


}