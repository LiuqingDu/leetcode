/*
 * @lc app=leetcode.cn id=1318 lang=java
 *
 * [1318] 或运算的最小翻转次数
 */

// @lc code=start
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) {
                    ans += 1;
                }
            } else {
                if (bitA == 1 && bitB == 1) {
                    ans += 2;
                } else if (bitA == 1 || bitB == 1) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

