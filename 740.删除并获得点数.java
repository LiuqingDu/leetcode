/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        // 类似 198 题打家劫舍
        // 那道题如果偷了一家那么相邻两家就不能偷
        // 这道题是选择一个数字那么相邻的数字不能再选择
        // 当选择一个数字后,因为相邻的数字已经被删掉了
        // 那么可以无后果地把剩下与当前数字相同的都选择了
        // 这样其实跟打家劫舍题目是一样的了
        // 把同一个数字当做是同一家,这家的金额是这个数字的总和
        // 就可以用那道题的解法来做了
        // 注意 198 这道题虽然用了常规的动态规划
        // 但还有可以优化的地方
        // 实际上只需要最近的两个屋子的选择结果即可

        // 先把题目的数组转化成打家劫舍的数据的结构
        // 就是索引表示可选的数字, 每一家的价值表示选择了这个数字可以获得的点数
        // 需要知道可选的最大值,用于初始化街道上的房子数量
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        // 形成街道上房屋的财产数组
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            // 把每个数字累加到它的房屋里
            sum[val] += val;
        }
        // 现在相当于形成了打家劫舍的街道
        // 比如原数组是 [1,2,1,1]
        // 新街道数组就是 [0, 3, 2]
        // 表示选择数字(索引) 1 的话最终可以获得 3 分
        return rob(sum);
    }

    // 这里是 198 题的优化版,只保留最近的两家房屋的选择结果
    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
// @lc code=end

