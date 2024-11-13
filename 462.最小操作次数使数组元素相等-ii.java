/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最小操作次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        // 将数组排序
        // 给出一个已经排好序的测试样例 [0, 1, 2, 6, 8]
        // 通过对数据的观察，可以得知，对首尾的两个数 0,8 最小的移动次数就是在 [0, 8] 之间任意找一个数，他们的固定移动次数都是 8；如果尝试在这个区间外找一个数来计算移动次数，如找 -1，则 0和8 的移动次数则为 10
        // 同理，我们对 1和6 进行最小次数移动的话， [1, 6] 中的任意数，他们固定移动 5次
        // 最后剩下一个中间的数 2，不移动的话，最小次数为 0
        // 由此看出本题是找中位数
        // 另外如果数组内元素数量为偶数个，那么取最中间两个数的任意一个都行

        Arrays.sort(nums);
        
        // 找到中位数
        int median = nums[nums.length / 2];
        
        // 计算总移动次数
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}
// @lc code=end

