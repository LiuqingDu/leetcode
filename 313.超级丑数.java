/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 在 lc264 基础上升级的题
        // 第一个丑数是 1，后续的丑数都是如下生成的：
        // 取出队列里最小的丑数，依次与 primes 的质数相乘放入队列
        // 这里会出现重复的问题，比如现在最小的丑数是 (m*p1)*(n*p2)
        // 现在先跟 p1 相乘得到 ((m+1)*p)*(n*p2) 记为 p’
        // 如果还有一个丑数是 ((m+1)*p)*((n-1)*p2)
        // 这个丑数跟 p2 再次计算的时候会得到同样的丑数 p'
        // 可以在加入新的丑数以后判断一下
        // 如果当前取出的丑数（本轮生成新丑数的基础丑数）与质数求余等于 0
        // 那么就提前结束本轮，
        // 比如 p' 生成出来后，如果继续与p2算，得出(m*p1*(n+1)*p2)
        // 我们如果此时提前结束，那么这个没算出来的丑数可以通过((m-1)*p1*(n+1)*p2)与p1来得出
        // 另外我们知道丑数在整数范围内，可以防止无限生成丑数
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);

        while (n > 0) {
            n--;
            int x = queue.poll();
            if (n == 0) {
                return x;
            }

            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) {
                    queue.add(k * x);
                }

                // 如果 x 包含因子 k，那么不需要继续了
                // 因为会存在一个数乘以一个当前的 k 来得到后续没有 break 的丑数
                // 比如记质数为k1~kn
                // 当前为k1
                // 那么跳过的 x*k2, x*k3...
                // 都可以通过未来的 y*k1, z*k1等来得到
                if (x % k == 0) {
                    break;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

