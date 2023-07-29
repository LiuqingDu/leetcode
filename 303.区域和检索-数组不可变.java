/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    // 提前遍历把所有的和都算好存起来
    // left到right的和等于left到right-1的和再加上当前数
    // 题目里n比较大，二维数组比较浪费空间
    // 可以用一维数组，存0到当前数的和，
    // 然后在sumRange方法内把left左边的和减去后返回

    // private int[][] sum;
    // public NumArray(int[] nums) {
    //     int n = nums.length;
    //     sum = new int[n][n];

    //     for (int i = 0; i < n; i++) {
    //         sum[i][i] = nums[i];
    //     }
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             sum[i][j] = sum[i][j - 1] + nums[j];
    //         }
    //     }
    // }
    
    // public int sumRange(int left, int right) {
    //     return sum[left][right];
    // }

    private int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        // 在方法sumRange内涉及到索引-1
        // 为防止越界，统一把sums往右挪一位
        // sums[i] 表示 i 左边的和，不包括 i
        // 因此如果需要包括n的和，需要找到sums[n+1]
        sum = new int[n + 1];

        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            // sum[i] 表示一直加到 i 左边也就是 i-1 这个数
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        // sum[right + 1]包含right
        // sum[left] 不包含left
        return sum[right + 1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

