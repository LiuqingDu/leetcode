/*
 * @lc app=leetcode.cn id=2824 lang=java
 *
 * [2824] 统计和小于目标的下标对数目
 */

// @lc code=start
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

