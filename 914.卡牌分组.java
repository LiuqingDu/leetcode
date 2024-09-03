/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // 可以看出实际上是在找每个数字的次数的公约数
        // 如果这个公约数大于等于 2，那么就是满足条件的 x

        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        int g = -1;
        // 遍历去找所有次数的最大公约数
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }

        return g >= 2;
    }

    // 求公约数
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
// @lc code=end

