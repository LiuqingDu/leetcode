/*
 * @lc app=leetcode.cn id=2980 lang=java
 *
 * [2980] 检查按位或是否存在尾随零
 */

// @lc code=start
class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        // 按位或还要求末尾至少一个0
        // 那么说明原本的数字末尾至少全都是0
        // 也就是说原本的数字需要是偶数
        // 只要有至少两个偶数即可
        int count = 0;

        for (int num : nums) {
            if ((num & 1) == 0) {
                count++;
            }
        }

        // 至少两个偶数
        return count >= 2;
    }
}
// @lc code=end

