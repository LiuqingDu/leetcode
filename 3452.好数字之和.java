/*
 * @lc app=leetcode.cn id=3452 lang=java
 *
 * [3452] 好数字之和
 */

// @lc code=start
class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if ((i < k || x > nums[i - k]) && (i + k >= n || x > nums[i + k])) {
                ans += x;
            }
        }
        return ans;

    }
}
// @lc code=end

