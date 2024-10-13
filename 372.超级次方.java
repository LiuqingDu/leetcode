/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        // 比如计算 99^2345，可以如下拆分：
        // = 99^(234*10 + 5)
        // = 99^(234*10) * 99^5
        // = (99^234)^10 * 99^5
        // ...
        // 可以看出，可以拆分为每个指数都为 10 以内的指数运算
        // 指数正好对应 b 的每一位

        return dfs(a, b, b.length - 1);
    }

    int dfs(int a, int[] b, int u) {
        if (u == -1) {
            return 1;
        }
        return pow(dfs(a, b, u - 1), 10) * pow(a, b[u]) % MOD;
    }

    int pow(int a, int b) {
        int res = 1;
        a %= MOD;
        while (b > 0) {
            res = res * a % MOD;
            b--;
        }
        return res;
    }
}
// @lc code=end

