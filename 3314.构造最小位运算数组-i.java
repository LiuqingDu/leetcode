/*
 * @lc app=leetcode.cn id=3314 lang=java
 *
 * [3314] 构造最小位运算数组 I
 */

// @lc code=start
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int res = -1;
            int d = 1;
            while ((x & d) != 0) {
                res = x - d;
                d <<= 1;
            }
            result[i] = res;
        }
        return result;

    }
}
// @lc code=end

