/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // 类似第15题，双指针，数组先排好序，
        // 外层依次遍历每一个元素，作为第一个数字
        // 第一个指针从第一个数字右边一个开始向右移动，
        // 第二个指针从右边往左移动，
        // 根据三数之和与target的大小关系，决定移动左指针还是右指针

        Arrays.sort(nums);
        // 初始化一个和
        int res = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length; first++) {
            // 左右指针
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                // 比较和是不是更小
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                // 根据大小关系移动指针
                if (sum > target) {
                    third--;
                } else if (sum < target) {
                    second++;
                } else if (sum == target) {
                    return sum;
                }
            }
        }
        return res;
    }
}
// @lc code=end

