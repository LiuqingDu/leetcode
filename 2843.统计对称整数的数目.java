/*
 * @lc app=leetcode.cn id=2843 lang=java
 *
 * [2843] 统计对称整数的数目
 */

// @lc code=start
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int a = low; a <= high; ++a) {
            if (a < 100 && a % 11 == 0) {
                res++;
            } else if (1000 <= a && a < 10000) {
                int left = a / 1000 + (a % 1000) / 100;
                int right = (a % 100) / 10 + a % 10;
                if (left == right) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

