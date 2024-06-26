/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        // 对于num，每有一个因子i，那么就有另一个因子num/i
        // 因此可以简化为计算从1开始到sqrt(num)之间的因子，然后对应地有另一个因子
        // 把所有因子加起来即可

        // 首先1不满足
        if (num == 1) {
            return false;
        }
        // 对于非1的num，至少有一个因子1，
        // 特殊处理因子1，然后从2开始找因子的原因是：因子1的对应的因子是num自己，不应当计算到总和里
        // 因此这里特殊处理，提前把因子1先算进去，然后从2开始
        int res = 1;
        for (int i = 2; i <= num / i; i++) {
            // 如果i是因子，则加进去
            if (num % i == 0) {
                res += i;
                // 看对应的因子是不是刚好等于i，如果不是，那么就是对称的因子，可以加进去
                // num如果刚好是平方数，那么平方根只能计算一次，不能重复计算
                if (num / i != i) {
                    res += num / i;
                }
            }
        }
        return res == num;

    }
}
// @lc code=end

