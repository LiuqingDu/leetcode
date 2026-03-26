/*
 * @lc app=leetcode.cn id=2855 lang=java
 *
 * [2855] 使数组成为递增数组的最少右移次数
 */

// @lc code=start
class Solution {
    public int minimumRightShifts(List<Integer> nums) {

        int n = nums.size();
        int count = 0;   // 断点个数
        int index = -1;  // 断点位置

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (nums.get(i) > nums.get(next)) {
                count++;
                index = i;
            }
        }

        // 已经递增
        if (count == 0) return 0;

        // 只有一个断点
        if (count == 1) {
            return n - (index + 1);
        }

        // 多个断点，不可能
        return -1;
    }
}
// @lc code=end

