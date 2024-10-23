/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        // 题目顺时针旋转是把第一个元素放到最后
        // 题目要计算最大值，那么逆时针旋转也不影响结果，反正所有结果都会被计算到
        // 逆时针是把末尾的元素放到第一个位置
        // 这里我们逆时针考虑，当然顺时针也是同样的思路，倒着循环就可以，
        // 或者正着循环用 [n - 1 - i] 来获取末尾的元素

        // 观察倒着的顺序 F(0), F(3), F(2), F(1)
        // 可以看到每一个 F 之间是在前一个基础上，每个元素的乘数-1
        // 唯一特殊的就是第一个元素，前一个 F 的第一个元素放到下一个 F 的末尾了
        // 它的乘数是增加的，乘数从 0 增加为 n - 1
        // 其余的元素的乘数都是-1
        // 记第一个 F 的总和为 sumF，记 nums 的元素之和为 sum
        // 可以看出下一个 F 的值应当是在上一个 sumF 的基础上 - sum，然后加上 (n*第一个元素)
        // 注意这里，因为减去 sum 的时候，实际上是也减去了一个第一个元素，所以后面加上的时候要加回来
        // 所以不是加上 (n-1)*(首元素) 而是加上 n*(首元素)
        
        int n = nums.length;
        int sumF = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sumF += i * nums[i];
            sum += nums[i];
        }

        int res = sumF;
        // 依次计算下一个 F
        for (int i = 0; i < n; i++) {
            sumF -= sum;
            // nums[i] 就是这一轮的首元素
            sumF += n * nums[i];
            res = Math.max(res, sumF);
        }

        return res;
        
    }
}
// @lc code=end

