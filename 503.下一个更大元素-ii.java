/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    // 在496的基础上的题
    // 循环的情况可以用“把数组重复两次”来模拟
    // 直接把数组在尾部复制一遍，这样遍历前半部分就可以找到循环的下一个大元素了
    // 但实际上还可以不用真的复制一份，只需要遍历的时候从两倍大的索引开始就行
    // 在访问数组元素的时候，使用i%n来对应到一份数组的索引上

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // 最终结果
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<Integer>();

        // 从两倍数组的尾部索引开始，就是2*n-1
        for (int i = 2*n - 1; i >= 0; i--) {
            // 当栈里有元素，且元素不大于当前元素时，弹出
            // 保证栈里只剩下比当前元素大的
            while(!stack.empty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            // 最终结果的当前位置(i%n)的值，是栈顶的值，也就是比当前大的第一个元素
            res[i % n] = stack.empty() ? -1 : stack.peek();
            // 把当前元素入栈，当前元素的索引应当是i%n
            stack.push(nums[i % n]);
        }

        return res;
    }
}
// @lc code=end

