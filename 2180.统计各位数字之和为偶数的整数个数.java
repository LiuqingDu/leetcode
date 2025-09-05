/*
 * @lc app=leetcode.cn id=2180 lang=java
 *
 * [2180] 统计各位数字之和为偶数的整数个数
 */

// @lc code=start
class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 2 == 0;
    }
}
// @lc code=end

