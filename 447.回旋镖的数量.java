/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 暴力计算每个点到其他点的距离,用 Map 记录每个距离有多少个
        // 再统计 Map 里总共多少个

        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                // 计算每个点到当前点的距离
                // 统计当前距离有多少个
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                // 对于当前点的每种不同距离, 同距离的有 m 个
                // 那么总共可以形成 m*(m-1) 个组合, 这里是考虑顺序的, 不同顺序算不同的组合
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}
// @lc code=end

