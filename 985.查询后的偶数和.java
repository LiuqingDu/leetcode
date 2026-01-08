/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int m = queries.length, t = 0;
        int[] ans = new int[m];
        for (int x : nums) t += x % 2 == 0 ? x : 0;
        for (int i = 0; i < m; i++) {
            int val = queries[i][0], idx = queries[i][1];
            if (nums[idx] % 2 == 0) t -= nums[idx];
            nums[idx] += val;
            if (nums[idx] % 2 == 0) t += nums[idx];
            ans[i] = t;
        }
        return ans;
    }
}
// @lc code=end

