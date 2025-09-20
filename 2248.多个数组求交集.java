/*
 * @lc app=leetcode.cn id=2248 lang=java
 *
 * [2248] 多个数组求交集
 */

// @lc code=start
class Solution {
    public List<Integer> intersection(int[][] nums) {
        // 统计每个数字出现的次数,如果次数等于nums.length则说明在所有数组中都出现过
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for (int[] arr : nums) {
            for (int num : arr) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
// @lc code=end

