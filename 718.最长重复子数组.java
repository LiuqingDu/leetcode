/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    // 动态规划, 基于公共前缀
    // 记 nums1[i:]表示 nums1 的从索引 i 到末尾之间的子数组
    // 记 dp[i][j] 表示 nums1[i:] 和 nums2[j:] 两个子数组的公共前缀长度
    // 可以看出, 如果 nums1[i] == nums2[j]
    // 那么 dp[i][j] = dp[i+1][j+1] +1
    // 也就是如果两个数字相同, 那么它们到末尾的公共前缀长度
    // 就等于它们后面的子数组的公共前缀长+1
    // 或者说, 从后往前算, 在当前的两个子数组基础上,如果它们左边外的数字相同
    // 那么它们的公共前缀和可以+1
    // 最终答案就是 dp 当中最大值
    // public int findLength(int[] nums1, int[] nums2) {
        // int m = nums1.length, n = nums2.length;
        // // 因为 dp[i][j] 依赖于 dp[i+1][j+1], 也就是需要 0~m 和 0~n
        // // 所以这里长度要多一个
        // int[][] dp = new int[m + 1][n + 1];
        // int ans = 0;
        // // 倒着来
        // for (int i = m - 1; i >= 0; i--) {
        //     for (int j = n - 1; j >= 0; j--) {
        //         dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
        //         ans = Math.max(ans, dp[i][j]);
        //     }
        // }
        // return ans;
    // }

    // 滑动窗口
    // 一个数组不动,另一个数组从右边向左滑动
    //            1,2,3,3,2,1
    //  4,5,2,3,3,4
    // --------------------------------
    //          1,2,3,3,2,1
    //  4,5,2,3,3,4
    // --------------------------------
    //        1,2,3,3,2,1
    //  4,5,2,3,3,4
    // --------------------------------
    //      1,2,3,3,2,1
    //  4,5,2,3,3,4
    // 然后对相交的区域查找是否有相同的部分
    public int findLength(int[] nums1, int[] nums2) {
        // 确保第一个参数是短的那一个
        return nums1.length <= nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
    }

    private int findMax(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int max = 0;

        // 分三步计算, 因为涉及到参数不同
        // 先算右边滑入,直到右边界对齐
        // 然后算滑动到左边界对齐
        // 最后算从左边滑出

        /*
        A:           |*|*|*|*|
        B: |*|*|*|*|*|*|
                 ↓
        A:       |*|*|*|*|
        B: |*|*|*|*|*|*|
         */
        for (int len = 1; len < m; len++) {
            max = Math.max(max, find(A, B, 0, n - len, len));
        }

        /*
        A:     |*|*|*|*|
        B: |*|*|*|*|*|*|
                 ↓
        A: |*|*|*|*|
        B: |*|*|*|*|*|*|
         */
        for (int j = n - m; j >= 0; j--) {
            max = Math.max(max, find(A, B, 0, j, m));
        }

        /*
        A: |*|*|*|*|
        B:   |*|*|*|*|*|*|
                 ↓
        A: |*|*|*|*|
        B:       |*|*|*|*|*|*|
         */
        for (int len = m - 1; len > 0; len--) {
            max = Math.max(max, find(A, B, m - len, 0, len));
        }

        return max;
    }

    // 参数 i j 分别表示相交区域的起点索引, len 表示相交区间的长度
    private int find(int[] A, int[] B, int i, int j, int len) {
        int max = 0, count = 0;
        for (int k = 0; k < len; k++) {
            if (A[i + k] == B[j + k]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        return Math.max(max, count);
    }
}
// @lc code=end

