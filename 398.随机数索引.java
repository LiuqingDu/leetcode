/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {

    // 这题类似382，需要用蓄水池算法，
    // 对于数量未知的一堆数字，如何等概率选择其中一个？
    // 对于第i个数字，有1/i的概率选择这个数字，1-1/i的概率保留原先的选择

    // 这道题与382不同之处就在于，不是所有的数字都应当被抽取，
    // 这里只有与target相同的数字才能被抽取，在这些相同的数字当中等概率抽取一个
    // 因此需要每次先把相同的数字挑出来

    int[] nums;
    Random rand;
    public Solution(int[] nums) {

        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {

        // 记录最终抽中的那个数字的坐标
        int res = -1;
        // 记录当前是第几个可抽取的数字，也就是待抽取数字的序号i
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // 如果不是待抽取数字则跳过
            if (nums[i] != target) {
                continue;
            }
            // 遇到一个待抽取数字，计数+1
            count++;
            // nextInt是生成一个[0, count)之间的整数，它等于0的概率是1/count
            // 当它等于0时更换为当前数字，更新索引，否则保留之前抽取的数字
            if (rand.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

