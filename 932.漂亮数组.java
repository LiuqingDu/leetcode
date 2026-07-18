/*
 * @lc app=leetcode.cn id=932 lang=java
 *
 * [932] 漂亮数组
 */

// @lc code=start
class Solution {

    // 使用 HashMap 记录已经计算过的漂亮数组，避免重复计算
    private Map<Integer, int[]> memo = new HashMap<>();

    public int[] beautifulArray(int n) {

        // 如果已经计算过，直接返回
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int[] res = new int[n];
        
        // 基础情况：n = 1 时，直接返回 [1]
        if (n == 1) {
            res[0] = 1;
        } else {
            int idx = 0;
            
            // 1. 生成左半部分的奇数：来自长度为 (n + 1) / 2 的漂亮数组
            for (int x : beautifulArray((n + 1) / 2)) {
                res[idx++] = 2 * x - 1;
            }
            
            // 2. 生成右半部分的偶数：来自长度为 n / 2 的漂亮数组
            for (int x : beautifulArray(n / 2)) {
                res[idx++] = 2 * x;
            }
        }

        // 存入缓存并返回
        memo.put(n, res);
        return res;
    }
}
// @lc code=end

