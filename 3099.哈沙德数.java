/*
 * @lc app=leetcode.cn id=3099 lang=java
 *
 * [3099] 哈沙德数
 */

// @lc code=start
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int num = x;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}
// @lc code=end

