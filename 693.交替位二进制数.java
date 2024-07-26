/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        // 比较容易想到的是按位向右移动一位，判断最后一位是否交替
        // 另一种简便的方法是，假设是交替的数字，把原数字 n 向右移动一位记为 n'
        // n + n' 形成右边全是1的数字比如00001111，然后再+1，形成只有一个1，且这个1在
        // 原数字n左边一位的数字n''，比如00010000
        // 参考 lc191 可以去掉最右边的一个1，
        // 去掉之后结果就是0
        int x = n + (n >> 1);  // n'
        // x + 1 就是 n''
        // 去掉最右边的 1 是：n & (n - 1)
        // 这里代入x+1
        return ((x + 1) & x) == 0;
    }
}
// @lc code=end

