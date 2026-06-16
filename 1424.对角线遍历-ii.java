/*
 * @lc app=leetcode.cn id=1424 lang=java
 *
 * [1424] 对角线遍历 II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        // map[k] 存储所有 i + j == k 的元素
        List<List<Integer>> map = new ArrayList<>();
        int totalElements = 0;

        // 1. 遍历 nums，按 i + j 分组
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int sum = i + j;
                // 如果当前对角线编号超出了 map 的大小，动态扩展 map
                while (map.size() <= sum) {
                    map.add(new ArrayList<>());
                }
                map.get(sum).add(row.get(j));
                totalElements++; // 记录总元素个数，用于初始化结果数组
            }
        }

        // 2. 收集结果
        int[] result = new int[totalElements];
        int index = 0;

        // 顺次遍历每一条对角线
        for (int k = 0; k < map.size(); k++) {
            List<Integer> diagonal = map.get(k);
            // 关键：逆序读取桶中的元素（从后往前），以满足从左下到右上的顺序
            for (int i = diagonal.size() - 1; i >= 0; i--) {
                result[index++] = diagonal.get(i);
            }
        }

        return result;
    }
}
// @lc code=end

