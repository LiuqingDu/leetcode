/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的 N 个不同整数
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        // 从 -n/2 到 n/2 之间的非 0 的整数刚好满足
        // 如果 n 是偶数,则正好不需要 0,
        // 如果 n 是奇数,则加一个 0 即可
        // 实际上填满偶数个数字后,最后一个不处理就是 0
        int[] res = new int[n];
        int ind = 0;
        for (int i = 1; i <= n/2; i++) {
            res[ind++] = i;
            res[ind++] = -i;
        }
        return res;
    }
}
// @lc code=end

