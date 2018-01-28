package com.zhaopeng.array;

/**https://hk029.gitbooks.io/leetbook/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/
 *
 * http://blog.csdn.net/linhuanmars/article/details/31354941
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 *
 *如果令 `left <= right，则right = middle - 1;
 如果令left < right，则 right = middle;`
 *
 *
 * Created by zhaopeng on 2018/1/18.
 */
public class KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) {
            return 0;
        }

        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1] ;//【)
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, j = n-1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
