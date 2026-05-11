/*
 * @lc app=leetcode.cn id=1329 lang=java
 *
 * [1329] 将矩阵按对角线排序
 */

// @lc code=start
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // key: i-j
        // value: 对角线上的元素
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 1. 收集每条对角线元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int key = i - j;

                map.putIfAbsent(key, new ArrayList<>());

                map.get(key).add(mat[i][j]);
            }
        }

        // 2. 每条对角线排序（降序）
        // 为什么降序？
        // 因为后面方便从尾部取最小值
        for (List<Integer> list : map.values()) {
            list.sort(Collections.reverseOrder());
        }

        // 3. 放回矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int key = i - j;

                List<Integer> list = map.get(key);

                // 取最后一个（最小值）
                mat[i][j] = list.remove(list.size() - 1);
            }
        }

        return mat;
    }
}
// @lc code=end

