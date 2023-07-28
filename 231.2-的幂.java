/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // n&(n-1) 是把二进制最后一个1变为0，
        // 如果一个数是2的n次方，则它的二进制只有一个1
        // 还需要判断一下这个数需要大于0
        return (n > 0) && ((n &= (n-1)) == 0);
    }
}
// @lc code=end

