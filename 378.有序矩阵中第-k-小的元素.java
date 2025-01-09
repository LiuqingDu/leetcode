/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 对于矩阵,取其中一个数记为 mid, 可以看出比 mid 大的数在它右下角区域
        // 小于等于 mid 的数在剩下的区域
        // a a a a b b
        // a a a a b b
        // a a a m c c
        // b b b c c c
        // b b b c c c
        // b b b c c c
        // 如上矩阵, 可知 a 是必定小于 m 的, c 是必定大于 m 的, 剩下的 b 可能小于可能等于也可能大于 m
        // 我们最终可以找到一条线, 它是经过 b 区域的一条折线, 把矩阵分割为两份
        // 左上方的一半是小于等于 m 的,右下方的一半是大于 m 的
        // 从矩阵的左下角或者右上角出发,可以找到这条线, 从而算出小于等于 m 的数量
        // 那么就可以用二分法,其中初始时 l 是矩阵左上角, r 是矩阵右下角
        // 逐步缩小范围找到第 k 个

        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 如果返回 true,表示左上方的数量大于等于 k,表示目标在左上方,需要缩小右边界
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 注意在上面循环的过程中, l 和 r 所表示的具体的数字可能不不是矩阵中存在的数字
        // 但最终终止循环的时候, l==r, 且此时它们就是存在于矩阵中的数字
        // 原因是, 即使 l 和 r 本身可能不在矩阵中,但[l,r]区间内肯定包含至少一个元素是矩阵中的
        // 当 l==r 时,区间只有一个元素,那么它就肯定是矩阵的元素了
        return left;

    }

    // 大于等于 mid 的数量是否至少为 k
    public boolean check(int[][] matrix, int mid, int k, int n) {
        // 从左下角 (n-1, 0) 开始寻找边界
        int i = n - 1;
        int j = 0;
        int num = 0;
        // 思路是从左下角开始检查每一列
        // 如果当前元素小于等于 mid, 则在当前列中, 当前元素及上方的都是小于等于 mid 的
        // 如果当前元素大于 mid, 则向上移动,直到找到小于等于的
        // 因为右边列里小于等于 mid 的元素不会多余当前列,所以在当前列向上移动不影响后续的统计
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                // 如果当前元素小于等于 mid
                // 把这些数量加进去
                num += i + 1;
                // 向右移动
                j++;
            } else {
                // 向上移动, 
                i--;
            }
        }
        return num >= k;
    }
}
// @lc code=end

