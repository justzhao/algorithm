package com.zhaopeng.sort;

/**
 * 归并排序
 * <p>
 * <p>
 * 时间复杂度为O(nlog₂n) 这是该算法中最好、最坏和平均的时间性能。
 * 空间复杂度为 O(n)
 * Created by zhaopeng on 2017/6/15.
 */
public class MergeSort {


    public static void sort(int[] arr, int low, int high) {
      //使用递归的方式进行归并排序，所需要的空间复杂度是O（N+logN）

        if(low>=high){
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        //合并
        merge(arr, low, mid, high);

       /*   int mid = (low + high) / 2;
        if (low < high) {
            //递归地对左右两边进行排序
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            //合并
            merge(arr, low, mid, high);
        }*/
    }

    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for (; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }


    //非递归

    public static void MergeSort2(int[] arr)
    {
        //使用非递归的方式来实现归并排序
        int len = arr.length;
        int k = 1;
       //k表示子数组的长度
        while(k < len)
        {
            MergePass(arr, k, len);
            k *= 2;
        }
    }

    //MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
    private static void MergePass(int[] arr, int k, int len)
    {
        int i = 0;
        //从前往后,将2个长度为k的子序列合并为1个
        while(i < len - 2*k + 1)
        {
            merge(arr, i, i + k-1, i + 2*k - 1);
            i += 2*k;
        }

        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if(i < len - k )
        {
            merge(arr, i, i+k-1, len-1);
        }

    }




    public static void main(String args[]) {
        int b[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        MergeSort s = new MergeSort();
        //s.sort(b);
        sort(b, 0, b.length - 1);
        s.printArray(b);

    }


    public void merge1(int[] array, int low, int mid, int high) {
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


    /**
     * @param array
     * @param gap
     * @param length
     */
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


}
