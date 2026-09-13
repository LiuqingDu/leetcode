/*
 * @lc app=leetcode.cn id=3300 lang=java
 *
 * [3300] 替换为数位和以后的最小元素
 */

// @lc code=start
class Solution {
    public int minElement(int[] nums) {
        
        int ans = 37;
        for (int num : nums) {
            int dig = 0;
            while (num > 0) {
                dig += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, dig);
        }
        return ans;

    }
}
// @lc code=end

