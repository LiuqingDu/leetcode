/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] 二进制字符串前缀一致的次数
 */

// @lc code=start
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0;
        int max = 0;

        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);

            // i + 1 表示当前进行了多少步
            if (max == i + 1) {
                ans++;
            }
        }

        return ans;
    }
}
// @lc code=end

