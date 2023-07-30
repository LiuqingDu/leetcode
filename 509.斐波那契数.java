/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        // 计算斐波那契数列只需要前两个数字，不需要数组，节约空间
        int a = 0;
        int b = 1;

        // c 用来计算当前数
        int c = 0;
        if (n <= 1) {
            return n;
        }
        // 从2开始直到n，依次用前两位数计算出当前的斐波那契数，并更新前两位数用于下次计算
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
// @lc code=end

