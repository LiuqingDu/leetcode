/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        
        // dp[i]：map<diff, length>
        Map<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        
        int res = 2; // 最少2个
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                
                int len = dp[j].getOrDefault(diff, 1) + 1;
                
                dp[i].put(diff, len);
                
                res = Math.max(res, len);
            }
        }
        
        return res;
    }
}
// @lc code=end

