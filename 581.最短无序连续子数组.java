/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 最终的目标是排序为从小到大
        // 原数组从左往右依次看,如果一个数比它左边的最大值要大
        // 那么它是符合最终结果要求的, 不需要参与重新排序
        // 如果一个数比它左边的最大数要小,那么它需要参与排序,记录这个数字的位置
        // 从左到右遍历,不断更新左侧数字的最大值,同时比较不符合的数字
        // 找出最后一个不符合要求的数字的位置,这就是右边界.
        // 这个数右边的数都比他们左边的最大值要大,就是符合升序排序
        // 这个数自身是最后一个不符合的,它比它左边的最大值要小,他就是参与排序的最后一个数
        // 同理从右边往左,每个数应当小于它右边的最小值,否则就需要参与重新排序
        // 找到最左侧的那个不符合的数,就是左边界

        int n = nums.length;
        // 记录左侧的最大值,以及右边界
        int maxn = Integer.MIN_VALUE, right = -1;
        // 记录右侧的最小值,以及左边界
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < maxn) {
                right = i;
            } else {
                maxn = nums[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > minn) {
                left = i;
            } else {
                minn = nums[i];
            }
        }
        // 只要有需要移动的,那么 right 和 left 就都不会是-1
        // 判断任意一个数是不是-1 都可以
        return right == -1 ? 0 : right - left + 1;
    }
}
// @lc code=end

