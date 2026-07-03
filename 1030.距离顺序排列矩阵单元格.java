/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        // 1. 初始化结果数组，矩阵一共有 rows * cols 个单元格
        int[][] result = new int[rows * cols][2];
        int index = 0;
        
        // 2. 遍历矩阵，把所有单元格的坐标 (i, j) 存入数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }
        
        // 3. 核心：按照到 (rCenter, cCenter) 的距离进行升序排序
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] cell1, int[] cell2) {
                // 计算第一个点到中心点的曼哈顿距离
                int dist1 = Math.abs(cell1[0] - rCenter) + Math.abs(cell1[1] - cCenter);
                // 计算第二个点到中心点的曼哈顿距离
                int dist2 = Math.abs(cell2[0] - rCenter) + Math.abs(cell2[1] - cCenter);
                
                // 升序排列：如果 dist1 小于 dist2，返回负数，dist1 排在前面
                return dist1 - dist2;
            }
        });
        
        // 4. 返回排序后的结果
        return result;
    }
}
// @lc code=end

