/*
 * @lc app=leetcode.cn id=957 lang=java
 *
 * [957] N 天后的牢房
 */

// @lc code=start
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {

        Map<String, Integer> seen = new HashMap<>();

        while (n > 0) {
            String state = Arrays.toString(cells);

            // 发现重复状态，说明进入循环
            if (seen.containsKey(state)) {
                int cycle = seen.get(state) - n;
                n %= cycle;
            }

            // 记录当前状态还剩多少天
            seen.put(state, n);

            if (n > 0) {
                n--;
                int[] next = new int[8];
                for (int i = 1; i < 7; i++) {
                    next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
                }
                cells = next;
            }
        }

        return cells;
    }
}
// @lc code=end

