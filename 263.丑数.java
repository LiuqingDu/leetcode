/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        // 如果一个数n可以不断地被质数m整除，一直除到商为1
        // 说明这个数n仅仅有m这一个质因数
        // 否则一旦不能整除，那么它一定还有别的质因数
        // 这样可以先后连续除以2,3,5，假如2除不尽但是剩下的可以继续被3除尽，
        // 说明它最多只有2和3这两个质因数

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        // 除完之后如果是1，说明它刚好可以被2，3，5通过一定方式除尽，那么就是丑数
        return n == 1;

    }
}
// @lc code=end

