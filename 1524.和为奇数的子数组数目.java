/*
 * @lc app=leetcode.cn id=1524 lang=java
 *
 * [1524] 和为奇数的子数组数目
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr) {
        
        final int MODULO = 1_000_000_007;
        int odd = 0, even = 1;
        int subarrays = 0;
        int total = 0;
        
        for (int x : arr) {
            total += x;
            if (total % 2 == 0) {
                subarrays = (subarrays + odd) % MODULO;
                even++;
            } else {
                subarrays = (subarrays + even) % MODULO;
                odd++;
            }
        }
        
        return subarrays % MODULO;

    }
}
// @lc code=end

