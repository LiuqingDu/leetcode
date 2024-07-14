/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 可以种花的位置是当前位置和前后一个位置均为空的才可以
        // 对于每一个可以种花的位置都种上同时n-1，最终判断 n 是否小于等于0即可
        // 注意当前位置种花以后，下一个位置肯定不能种，可以直接从下下个位置判断
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && (i == m - 1 || flowerbed[i + 1] == 0)) {
                n--;
                // 下一个位置肯定不能种，直接跳过
                i++;
            }
        }
        return n <= 0;
    }
}
// @lc code=end

