/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {

    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 新建一个数组存每个格子到(0,0)格子之间的矩形元素和
        // 因为计算这个和需要格子上方、左侧、和左上的矩形和，那么边缘的格子就需要特殊处理一下
        // 但另一方面，sumRegion里，又再次需要边缘外的格子，
        // 那么，我们可以多创建一层边缘格子，原先的坐标(i,j)对应新的(i+1,j+1)
        // 其中[i][0]和[0][i]作为多余的边缘格子，默认为0
        sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意这里sum的坐标对应到matrix里需要-1
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 注意这里row1和col1代表需要计算的矩阵的左上角格子，
        // 实际上我们是用右下角格子的值（右下角到原点的矩阵和）减去左侧、上侧再加上左上角的值来求结果的，
        // 那么这里的左侧、上侧、左上角的坐标应当在目标矩阵的外侧，所以这几个值需要-1，
        // 另一方面，所有的坐标值应当+1，因为有一层多余的边缘格子，
        // 所以下面的row1和col1实际上是row1+1-1和col1+1-1简化而来
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

