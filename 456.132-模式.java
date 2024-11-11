/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132 模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        // 题目要求找到符合 132 模式的序列
        // 倒着从末尾开始处理
        // 首先维护一个单调递减的栈
        // 栈里面是可能存在的 3
        // 每当遇到新的元素比栈顶还大的时候，就依次弹出栈顶
        // 直到新元素比栈顶小，可以入栈
        // 那么出栈的元素就是比新栈顶还要小的数字
        // 出栈的就是备选的2
        // 栈顶就是备选的3
        // 那么只要未来出现了新的元素比3小，那么就满足题目
        // 否则就继续尝试入栈

        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        // k就是记录满足的3当中最大的那一个
        // 取最大的3，使得有最大的可能性找出符合题目的1
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            // 如果新元素比3小，那么就找到了符合题目的
            // 因为3是由于被较大的2给顶出来的
            // 所以当3存在的时候，已经有符合题目的2了
            // 此时新元素nums[i]就相当于1
            if (nums[i] < k) {
                return true;
            }
            // 把栈顶所有比新元素小的都弹出来，并更新k
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                k = Math.max(k, d.pollLast());
            }
            // 新元素入栈
            d.addLast(nums[i]);
        }
        return false;
    }
}
// @lc code=end

