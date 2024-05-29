/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        // 动态规划
        // 一个数字要么是奇数要么是偶数
        // 奇数的1的个数，等于比它小的那个偶数的1的个数再+1
        // 其实就是把那个偶数的最后一位0变为1
        // 偶数的1的个数，等于它除以2的那个数字的1的个数
        // 其实就是把偶数二进制向右移动一位，最后一位是0，所以移动之后不影响1的个数，还是相等
        // 特殊的是0，它的1的个数为0

        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;

    }
}
// @lc code=end

