/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        // 从左上角依次把四个边循环一圈
        // 每次走过一个边就把边框缩小
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;

        List<Integer> res = new LinkedList<Integer>();

        // 跳出循环的条件是res里的元素总数等于m*n
        while (res.size() < m * n) {
            // 先走上边线
            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                // 上边线往下收缩
                top++;
            }
            // 同理右边线
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 下边线
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 左边线
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }

        return res;
    }
}
// @lc code=end

