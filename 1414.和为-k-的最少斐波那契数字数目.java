/*
 * @lc app=leetcode.cn id=1414 lang=java
 *
 * [1414] 和为 K 的最少斐波那契数字数目
 */

// @lc code=start
class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        // 1. 初始化斐波那契数列
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        
        // 生成所有小于等于 k 的斐波那契数
        while (true) {
            int nextFib = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            if (nextFib > k) {
                break;
            }
            fib.add(nextFib);
        }
        
        // 2. 从大到小进行贪心选择
        int count = 0;
        int index = fib.size() - 1; // 从最大的斐波那契数开始找
        
        while (k > 0) {
            int currentFib = fib.get(index);
            if (k >= currentFib) {
                k -= currentFib; // 减去当前能选的最大数
                count++;         // 计数加 1
            }
            index--; // 无论选没选，都看前一个更小的数
        }
        
        return count;
    }
}
// @lc code=end

