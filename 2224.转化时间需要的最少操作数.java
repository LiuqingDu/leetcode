/*
 * @lc app=leetcode.cn id=2224 lang=java
 *
 * [2224] 转化时间需要的最少操作数
 */

// @lc code=start
class Solution {
    public int convertTime(String current, String correct) {
        // 已知correct时间一定大于current时间, 所以直接相减, 不用考虑跨天问题
        int[] ops = new int[]{60, 15, 5, 1};
        String[] cur = current.split(":");
        String[] cor = correct.split(":");
        int curTime = Integer.parseInt(cur[0]) * 60 + Integer.parseInt(cur[1]);
        int corTime = Integer.parseInt(cor[0]) * 60 + Integer.parseInt(cor[1]);
        int diff = corTime - curTime;
        int ans = 0;
        for (int op : ops) {
            // 依次使用最大操作数, 计算需要的操作数
            ans += diff / op;
            diff %= op;
        }
        return ans;
    }
}
// @lc code=end

