/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        // x和y取或，只要大于0就说明剩下的部分不是0，还有数字需要处理
        while ((x | y) > 0) {
            // 每次处理最后一位
            // 跟1进行与运算，取出最后一位数字
            int a = x & 1, b = y & 1;
            // 两个最后一位数字比较，异或就是看这两位是不是不同
            res += a ^ b;
            // 两个数往右挪一位，继续处理
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
}
// @lc code=end

