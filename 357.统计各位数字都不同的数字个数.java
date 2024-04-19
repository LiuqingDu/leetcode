/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 统计各位数字都不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        // n=0的时候特殊处理，为1
        // n=1时，特殊处理，为10
        // 剩下的情况，比如n=2，那么此时满足条件的数字可以是一位数，可以是两位数，
        // 其中一位数的情况就是n=1的情况，
        // n=2的情况下，第一位可选9种数字（不能为0），第二位可选9种（去掉不能跟第一位重复的情况）
        // n>2的情况后续每一位可选数量依次递减
        // 两位数的选择可能有9*9，三位数可选的有9*9*8，以此类推
        // 把一位数的情况和两位数情况加起来，就是n=2的情况总和，
        // n>2的情况也类似叠加

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 10;
        }

        int res = 10;
        int cur = 9;

        for (int i = 2; i <= n; i++) {
            cur *= 10 - i + 1;
            res += cur;
        }

        return res;

    }
}
// @lc code=end

