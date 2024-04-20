/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {

        // c = a ^ b 求得是不需要进位的结果
        // d = (a & b) << 1 求得是需要进位的结果
        // 所以原问题转换成 由 a + b => c + d 而 c + d 问题性质和a + b一模一样，
        // 所以递归或者循环计算即可

        while (b != 0) {
            int c = a ^ b;
            int d = (a & b) << 1;
            a = c;
            b = d;
        }

        return a;

    }
}
// @lc code=end

