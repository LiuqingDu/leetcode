/*
 * @lc app=leetcode.cn id=1380 lang=java
 *
 * [1380] 矩阵中的幸运数
 */

// @lc code=start
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        // 首先证明最多有一个幸运数字, 即要么没有要么一个
        // 反证法,假设有两个幸运数字记为 x, y, 且 x!=y, 表示如下
        // x  -- -- --
        // -- -- -- y
        // 那么 x 和 y 分别是对应行的最小值和对应列的最大值
        // 且所有元素都为正数,且互不相同
        // 那么下面两个数字可以记为 x+a 和 x-b, 其中 a 和 b 均为正数
        // x   -- -- x+a
        // x-b -- -- y
        // 则可以得出 x+a < y < x-b
        // 则 a < -b
        // 因为 a 和 b 均为正数,所以上面不等式不成立
        // 因此最多有一个幸运数字

        // 再证明: 如果存在幸运数记为 [i,j], 则它是所有行的最小值当中最大的
        // 即 mat[i,j] = minRow[i] = minRow[*] 最大值, 记为 rowMax
        // 同理也是所有列的最大值当中最小的
        // 即 mat[i,j] = maxCol[i] = maxCol[*] 最小值, 记为 colMin
        // 反证法
        // 对于幸运数 x = mat[i,j] 意味着对于行 i, 该行其他数字都大于等于它
        // 对于列 j, 该列其他元素都小于等于它
        // 反证:假设存在 y = mat[k,l], 它是比 x 还大的行最小值
        // 则说明对于 y 所在行,其他元素都大于等于 y, 也就是都大于 x
        // 那么这些大于 x 的同行元素当中必定有一个是跟 x 同列的, 
        // 这个元素又大于 x 又跟 x 同列, 使得 x 不是列最大, 因此不成立
        // 同理可以证明 x 是所有列最大值当中最小的

        // 由上述两个特性,说明如果存在幸运数,则只有一个,它就是行最小值当中最大的,
        // 且是列最大值当中最小的
        // 只需先找出行最小值当中最大的那个,记下它所在列,然后看它是不是列最大值即可

        List<Integer> ret = new ArrayList<Integer>();
        int m = matrix.length, n = matrix[0].length;
        // 记录行最小值当中的最大值,以及所在列的编号
        int rowMax = 0, k = 0;
        for (int i = 0; i < m; i++) {
            int curMin = matrix[i][0];
            int c = 0;
            for (int j = 1; j < n; j++) {
                // 记录当前行最小值
                if (curMin > matrix[i][j]) {
                    curMin = matrix[i][j];
                    c = j;
                }
            }
            // 如果当前最小值更大,则记录位置
            if (rowMax < curMin) {
                rowMax = curMin;
                k = c;
            }
        }
        // 如果不是当前列最大值,则不存在幸运数
        for (int i = 0; i < m; i++) {
            if (rowMax < matrix[i][k]) {
                return ret;
            }
        }
        ret.add(rowMax);
        return ret;
    }
}
// @lc code=end

