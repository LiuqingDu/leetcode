/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {

        // 解析看js版
        int p2 = 0, p3 = 0, p5 = 0;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            int n2 = res[p2] * 2, n3 = res[p3] * 3, n5 = res[p5] * 5;
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) {
                p2++;
            }
            if (res[i] == n3) {
                p3++;
            }
            if (res[i] == n5) {
                p5++;
            }
        }

        return res[n - 1];

    }
}
// @lc code=end

