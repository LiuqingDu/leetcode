/*
 * @lc app=leetcode.cn id=1437 lang=java
 *
 * [1437] 是否所有 1 都至少相隔 k 个元素
 */

// @lc code=start
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        // 记录上一个 1 的位置,然后找到下一个 1 的位置,计算两者间距
        // pre = -1 表示之前没有出现过 1
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre == -1) {
                    pre = i;
                } else {
                    if (i - pre - 1 < k) {
                        return false;
                    } else {
                        pre = i;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

