/*
 * @lc app=leetcode.cn id=2103 lang=java
 *
 * [2103] 环和杆
 */

// @lc code=start
class Solution {
    public int countPoints(String rings) {
        // 使用 Set 来存储每根杆上的颜色
        // 每根杆的索引从 0 到 9
        // 如果一根杆上有红色、绿色和蓝色的环，则计数加 1
        // 最终返回满足条件的杆的数量
        int n = 10;
        Set<Character>[] rods = new Set[n];
        for (int i = 0; i < n; i++) {
            rods[i] = new HashSet<>();
        }

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rodIndex = rings.charAt(i + 1) - '0';
            rods[rodIndex].add(color);
        }

        int count = 0;
        for (Set<Character> rod : rods) {
            if (rod.size() == 3) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

