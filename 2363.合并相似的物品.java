/*
 * @lc app=leetcode.cn id=2363 lang=java
 *
 * [2363] 合并相似的物品
 */

// @lc code=start
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();

        // 合并 items1
        for (int[] item : items1) {
            int value = item[0];
            int weight = item[1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }

        // 合并 items2
        for (int[] item : items2) {
            int value = item[0];
            int weight = item[1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }

        // 转为 List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        // 按 value 升序排序
        result.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        return result;
    }
}
// @lc code=end

