/*
 * @lc app=leetcode.cn id=1333 lang=java
 *
 * [1333] 餐厅过滤器
 */

// @lc code=start
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();

        // 1. 过滤
        for (int[] r : restaurants) {

            // 素食过滤
            if (veganFriendly == 1 && r[2] != 1) {
                continue;
            }

            // 价格过滤
            if (r[3] > maxPrice) {
                continue;
            }

            // 距离过滤
            if (r[4] > maxDistance) {
                continue;
            }

            list.add(r);
        }

        // 2. 排序
        Collections.sort(list, (a, b) -> {

            // rating 降序
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }

            // id 降序
            return b[0] - a[0];
        });

        // 3. 提取 id
        List<Integer> ans = new ArrayList<>();

        for (int[] r : list) {
            ans.add(r[0]);
        }

        return ans;
    }
}
// @lc code=end

