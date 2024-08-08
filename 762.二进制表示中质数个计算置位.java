/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    public int countPrimeSetBits(int left, int right) {
        // 判断1的数量是不是质数，1的数量最多是32个
        // 先把32以内的质数标记出来
        // 然后统计每个数字的二进制有多少个1，这里可以参考 lc191
        // 另一种消除最后一个1的方法是先找到那个1所在位，然后原数减去这个位子上的1

        // 标记质数
        boolean[] hash = new boolean[32];
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int i : prime) {
            hash[i] = true;
        }

        int res = 0;
        for (int i = left; i <= right; i++) {
            int x = i;
            // 计算有多少个1
            int count = 0;
            while (x != 0) {
                // 等号右边是找出最后一个1所在位的数字
                // 比如1010计算后就是0010
                x -= x & (-x);
                count++;
            }
            if (hash[count]) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

