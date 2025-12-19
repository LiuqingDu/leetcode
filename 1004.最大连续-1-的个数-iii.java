/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        // 滑动窗口
        // left 和 right 指向窗口两头
        // lsum 和 rsum 记录窗口两头经过的 0 的总数
        // 其中 lsum 是更新之后再移动 left 指针,所以 lsum 表示窗口外左侧,不包含窗口内左侧第一个的
        // 这个总数是不会减少的, 所以 rsum - lsum 就是窗口内 0 的总数

        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int res = 0;

        for (int right = 0; right < n; right++) {
            // 右边新进来的数字是否需要替换为1并计入总数
            rsum += 1 - nums[right];
            // 如果两边替换的总数大于k则需要从左边窗口排除
            // 直到排除了真正是被替换的1为止
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
// @lc code=end

