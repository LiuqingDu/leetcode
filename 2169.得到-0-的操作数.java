/*
 * @lc app=leetcode.cn id=2169 lang=java
 *
 * [2169] 得到 0 的操作数
 */

// @lc code=start
class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

