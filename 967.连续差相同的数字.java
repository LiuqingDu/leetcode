/*
 * @lc app=leetcode.cn id=967 lang=java
 *
 * [967] 连续差相同的数字
 */

// @lc code=start
class Solution {
    /*
    思路：
    我们要生成所有长度为 n 的整数，使每一对相邻数字的差的绝对值为 k。
    做法：
    1. 如果 n == 1，直接返回 0～9。
    2. 对首位数字从 1 到 9 进行递归，逐位拼接。
    3. 每次取当前数字的最后一位 last，尝试加上 last + k 和 last - k。
    4. 递归结束时加入结果。
    5. 注意当 k == 0 时不要重复添加相同分支。
    */
    public int[] numsSameConsecDiff(int n, int k) {
        
        if (n == 1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, k, i, res);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private static void dfs(int n, int k, int num, List<Integer> res) {
        if (n == 0) {
            res.add(num);
            return;
        }

        int last = num % 10;

        if (last + k < 10) {
            dfs(n - 1, k, num * 10 + last + k, res);
        }

        if (k != 0 && last - k >= 0) {
            dfs(n - 1, k, num * 10 + last - k, res);
        }
    }
}
// @lc code=end

