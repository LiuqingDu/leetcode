/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        // 一个数有多少个 0 取决于乘数里有多少个 10
        // 10 又由质数 2 和 5 组成
        // 所以将原阶乘每个数都分解质因数，统计总共有多少个 2 和 5
        // 取它们当中数量较少的，就是最终有多少个 10，也就是有多少个 0
        // 很明显分解后 5 较少。每两个数字中就有一个数字可以分解出 2，且分解的个数增长快

        // 尝试递归分解为 5 的质因数，将个数累加起来
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
// @lc code=end

