/*
 * @lc app=leetcode.cn id=3349 lang=java
 *
 * [3349] 检测相邻递增子数组 I
 */

// @lc code=start
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        int cnt = 1, precnt = 0, ans = 0;

        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++cnt;
            } else {
                precnt = cnt;
                cnt = 1;
            }
            ans = Math.max(ans, Math.min(precnt, cnt));
            ans = Math.max(ans, cnt / 2);
        }

        return ans >= k;

    }
}
// @lc code=end

