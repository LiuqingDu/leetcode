/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {

        // 所有数字异或之后相当于这两个数字它们的异或
        // xorsum = x1 ^ x2
        // 找到xorsum二进制里最右边的那个1所在的位置
        // 明显,x1和x2在这个位置上必定一个是1一个是0
        // 把所有数字根据在这个位置上是1还是0分为两类
        // 那么part1就是一堆两次的数字跟x1的异或
        // part2是另一堆两次的数字跟x2的异或
        // 那么part1和part2就是最终答案

        int xorsum = 0;
        for (int num: nums) {
            xorsum ^= num;
        }

        int lastIndexOfOne = xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum);

        int part1 = 0;
        int part2 = 0;
        for (int num: nums) {
            if ((num & lastIndexOfOne) != 0) {
                part1 ^= num;
            } else {
                part2 ^= num;
            }
        }

        return new int[]{part1, part2};
    }
}
// @lc code=end

