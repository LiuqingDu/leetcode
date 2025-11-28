/*
 * @lc app=leetcode.cn id=2535 lang=java
 *
 * [2535] 数组元素和与数字和的绝对差
 */

// @lc code=start
class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0, digitSum = 0;
        for (int num : nums) {
            elementSum += num;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        return elementSum - digitSum;
    }
}
// @lc code=end

