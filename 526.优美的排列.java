/*
 * @lc app=leetcode.cn id=526 lang=java
 *
 * [526] 优美的排列
 */

// @lc code=start
class Solution {
    public int countArrangement(int n) {
        // 假设现在给当前位置选好了一个数字,那么问题就转变为在剩下的数字当中为剩下的位置选数字
        // 可以用 dfs 来解决,为了避免重复,用 memo 记录
        // 比如当前已经选择了 1,2,4 这样的,那么接下来要进行的下一轮选择
        // 如果已经选择了 2,1,4 这种, 接下来要选择的跟上一种情况是一样的,完全重复的
        // 这种就可以用 memo 避免重复计算
        // 另外用二进制表示已经计算过的情况,因为 n不大于 15, 每一位二进制表示这个数字有没有被选择
        // memo 数组用于记忆化，记录每个状态 s 的美丽排列数，初始化为 -1 表示没有计算过
        int[] memo = new int[1 << n];  
        Arrays.fill(memo, -1);  // 设置 memo 数组初始值为 -1
        return dfs(0, n, memo);  // 从状态 0 开始，递归计算美丽排列数
    }

    // dfs 函数用于递归计算从当前状态 s 开始的美丽排列数
    private int dfs(int state, int n, int[] memo) {
        // 如果当前状态 s 中所有数字都被选择了（即 s == (1 << n) - 1），返回 1，表示一种有效的排列
        if (state == (1 << n) - 1) {
            return 1;
        }

        // 如果当前状态已经计算过，直接返回结果
        if (memo[state] != -1) {
            return memo[state];
        }

        int result = 0;
        // 计算当前状态已经选了多少个数字（即 position）
        int position = Integer.bitCount(state) + 1;  // position 从 1 到 n

        // 遍历每一个数字 j，检查是否可以放在当前的位置
        for (int num = 1; num <= n; num++) {
            // 判断数字 num 是否未被选择（通过检查 state 中对应位置是否为 0）
            if ((state >> (num - 1) & 1) == 0) {
                // 如果可以放置该数字（满足美丽排列的条件）
                if (position % num == 0 || num % position == 0) {
                    // 递归计算选择 num 后的结果，并累加
                    result += dfs(state | (1 << (num - 1)), n, memo);
                }
            }
        }

        // 将当前状态的结果存入 memo 数组，以便后续直接使用
        memo[state] = result;

        return result;
    }
}
// @lc code=end

