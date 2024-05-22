/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int nextNum = 0;
        while (num != 0) {
            nextNum = nextNum + num % 10;
            num = num / 10;
        }
        
        return addDigits(nextNum);

    }
}
// @lc code=end

