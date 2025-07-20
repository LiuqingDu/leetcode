/*
 * @lc app=leetcode.cn id=1144 lang=java
 *
 * [1144] 递减元素使数组呈锯齿状
 */

// @lc code=start
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        // 要么波峰在奇数位,要么波峰在偶数位
        // 因为只能减不能加,所以如果减了波峰,那么相应的波谷也得减,从而总操作数肯定会增加
        // 所以波峰不能操作,只操作波谷
        // 使得波谷刚好比相邻的波峰小1
        // 比较波峰在奇数位和偶数位的情况,取最小值
        // help在原数组上修改了,所以要clone
        return Math.min(help(nums.clone(), 0), help(nums.clone(), 1));
    }

    // pos是第一个波谷的位置
    // 处理nums[pos]开始的波谷需要减多少
    public int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            // 如果比左边大, 那么当前位置需要减少到波谷
            // 操作数是差值+1
            if (i > 0 && nums[i] >= nums[i - 1]) {
                res += nums[i] - nums[i - 1] + 1;
                nums[i] = nums[i - 1] - 1; // 更新当前波谷的值
            }
            // 右边同理
            if (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                res += nums[i] - nums[i + 1] + 1;
                nums[i] = nums[i + 1] - 1; // 更新当前波谷的值
            }
        }
        return res;
    }
}
// @lc code=end

