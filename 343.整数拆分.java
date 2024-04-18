/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {

        // 本题实质是个数学题
        // https://leetcode.cn/problems/integer-break/solutions/29098/343-zheng-shu-chai-fen-tan-xin-by-jyd/
        // 尽量使用3作为拆分的数字，可以获得最大的乘积
        // 那么这个数字n尽量使用3来拆分的话，最后一个数字可能是3，2，1中的一个
        // 如果是3，那么所有拆分的数字都是3
        // 如果是2，那么就把前面的所有3跟这个2相乘
        // 如果是1，那么就需要从前面取一个3出来跟这个1组成2+2的形式，那么乘积就是剩下的3跟这两个2相乘

        // 小于等于3的，因为至少要拆分为两个数，那么就拆分为1和n-1可以形成最大乘积
        if (n <= 3) {
            return n-1;
        }

        int a = n / 3, b = n % 3;
        //根据余数b判断最后一个数的情况
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            // 最后一个数字是1, 需要取出一个3，然后和这个1一起改为【2和2】
            return (int) Math.pow(3, a - 1) * 2 * 2;
        } else {
            // 最后一个数字是2
            return (int) Math.pow(3, a) * 2;
        }

    }
}
// @lc code=end

