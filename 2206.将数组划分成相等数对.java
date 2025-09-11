/*
 * @lc app=leetcode.cn id=2206 lang=java
 *
 * [2206] 将数组划分成相等数对
 */

// @lc code=start
class Solution {
    public boolean divideArray(int[] nums) {
        // 相同的数字的个数应当是偶数
        int[] count = new int[501];
        for (int num : nums) {
            count[num]++;
        }
        for (int c : count) {
            if (c % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

