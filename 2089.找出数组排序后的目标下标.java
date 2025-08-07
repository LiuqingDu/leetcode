/*
 * @lc app=leetcode.cn id=2089 lang=java
 *
 * [2089] 找出数组排序后的目标下标
 */

// @lc code=start
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 统计小于目标值的元素个数和等于目标值的元素个数
        // 然后生成结果列表
        // 小于目标值的元素个数决定了目标值在排序后的位置
        // 等于目标值的元素个数决定了目标值在排序后出现的次数
        Arrays.sort(nums);
        int lessCount = 0;
        int equalCount = 0;
        for (int num : nums) {
            if (num < target) {
                lessCount++;
            } else if (num == target) {
                equalCount++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < equalCount; i++) {
            result.add(lessCount + i);
        }
        return result;
    }
}
// @lc code=end

