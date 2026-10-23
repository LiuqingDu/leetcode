/*
 * @lc app=leetcode.cn id=3364 lang=java
 *
 * [3364] 最小正和子数组
 */

// @lc code=start
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        Integer[] a = nums.toArray(Integer[]::new);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= a.length - l; i++) {
            int s = 0;
            for (int j = i; j < a.length && j - i + 1 <= r; j++) {
                s += a[j];
                if (s > 0 && j - i + 1 >= l) {
                    ans = Math.min(ans, s);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
// @lc code=end

