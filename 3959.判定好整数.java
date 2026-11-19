/*
 * @lc app=leetcode.cn id=3959 lang=java
 *
 * [3959] 判定好整数
 */

// @lc code=start
class Solution {
    public boolean checkGoodInteger(int n) {
        
        int diff = 0;
        for (; n > 0; n /= 10) {
            int d = n % 10;
            diff += d * d - d;
        }
        return diff >= 50;

    }
}
// @lc code=end

