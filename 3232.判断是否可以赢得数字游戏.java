/*
 * @lc app=leetcode.cn id=3232 lang=java
 *
 * [3232] 判断是否可以赢得数字游戏
 */

// @lc code=start
class Solution {
    public boolean canAliceWin(int[] nums) {
        
        int singleDigitSum = 0;
        int doubleDigitSum = 0;
        for (int num : nums) {
            if (num < 10) {
                singleDigitSum += num;
            } else {
                doubleDigitSum += num;
            }
        }
        return singleDigitSum != doubleDigitSum;

    }
}
// @lc code=end

