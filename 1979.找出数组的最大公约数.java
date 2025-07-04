/*
 * @lc app=leetcode.cn id=1979 lang=java
 *
 * [1979] 找出数组的最大公约数
 */

// @lc code=start
class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return gcd(min, max);
        
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
// @lc code=end

