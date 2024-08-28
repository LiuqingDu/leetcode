/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果交换
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // 记 a 和 b 的总数的差值为 diff
        // 其实就是找两边是否各有一个数，它们差值 diff/2 这样交换之后
        // 一边多 diff/2 一边少 diff/2 , 两边总数就相等了

        Set<Integer> set = new HashSet<>();
        int diff = 0;

        for (int a: aliceSizes) {
            set.add(a);
            // diff 为正说明 alice 总数更大
            diff += a;
        }

        for (int b: bobSizes) {
            // diff 为负说明 bob 总数更大
            diff -= b;
        }

        diff = diff / 2;
        for (int b: bobSizes) {
            // 如果 diff 为正，说明 alice 更大，需要在 alice 里找一个比 b 大的数，
            // 这里正好用加号
            // 反之若 diff 为负数，这里加号也是正确的
            if (set.contains(b + diff)) {
                return new int[]{b + diff, b};
            }
        }

        return new int[2];
    }
}
// @lc code=end

