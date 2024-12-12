/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // 看图其实就是要找一条线,使得最多的墙在这里刚好是缝隙
        // 缝隙就是砖块的长度和
        // 所以计算出每个墙的砖缝的位置,然后用 map 记录每个位置的出现次数
        // 出现次数最多的就是要找的那条线
        // 穿过的墙的数量就是墙总数减去该位置缝隙出现的次数

        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, sum = 0; i < n; i++, sum = 0) {
            for (int cur : wall.get(i)) {
                sum += cur;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            // 删除最右边那条缝隙,也就是整体的右边,不能从那里经过
            map.remove(sum);
        }
        int res = 0;
        for (int value : map.values()) {
            res = Math.max(res, value);
        }
        return n - res;
    }
}
// @lc code=end

