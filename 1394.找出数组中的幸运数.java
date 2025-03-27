/*
 * @lc app=leetcode.cn id=1394 lang=java
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start

class Solution {
    public int findLucky(int[] arr) {
        // 总共 500 个数,用一个数组来记录次数
        // 从大到小找第一个满足条件的
        int[] map = new int[501];
        for (int num : arr) {
            map[num]++;
        }

        for (int i = 500; i > 0; i--) {
            if (i == map[i]) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

