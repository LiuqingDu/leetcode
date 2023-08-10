/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {

    // 对于给定的一组数字，可以任意选取一个数字作为根节点，
    // 该数字左边的数可以组成左子树，右边的数字可以组成右节点，
    // 那么这个选定的根节点可以形成的所有搜索树的可能性就是左右可能性的积
    // 把每个根节点的可能性加起来就是最终结果
    // 至于左右子树怎么计算，可以继续递归
    // 用备忘录可以避免重复计算

    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return backtrack(1, n);
    }

    // 定义在给定的[min, max]的数字中，有多少种搜索树的可能
    private int backtrack(int min, int max) {
        // 如果超出范围，则只有一种可能，就是空树
        if (min > max) {
            return 1;
        }

        if (memo[min][max] != 0) {
            return memo[min][max];
        }

        // 记录多少种可能性
        int r = 0;

        // 每一个数字都可以当作根节点
        for (int i = min; i <= max; i++) {
            // 左子树的可能性
            int left = backtrack(min, i - 1);
            // 右子树的可能性
            int right = backtrack(i + 1, max);
            // 当前根节点的可能性是左右子树可能性的乘积
            r += left * right;
        }

        // 存入备忘录
        memo[min][max] = r;
        
        return r;

    }
}
// @lc code=end

