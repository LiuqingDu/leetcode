/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<List<Integer>>();

        for (int first = 0; first<n;first++) {
            // 如果第一个数大于零，后两个数又大于第一个数，则不可能相加等于 0
            if (nums[first] > 0) {
                break;
            }
            // 从索引为2的数开始，如果跟上一个数相等，则跳过，可以避免重复结果
            if (first>0&&nums[first]==nums[first-1]) {
                continue;
            }
            // 第二个数和第三个数形成双指针，因为在已经找到一对答案的情况下，第二个数向右移动（增加），第三个数只能向左移动（减少）才有可能满足答案。
            // 第三个数从末尾向前
            int third = n-1;
            // 目标答案，也就是第二个数和第三个数之和应当等于第一个数取负数
            int target = -nums[first];
            // 从第一个数的下一个数开始，因为第一个数的左边是已经算过的答案组合了
            for (int second = first+1; second< n; second++) {
                if (second>first+1&&nums[second]==nums[second-1]) {
                    continue;
                }
                // 确保双指针不能相交，也就是第二个数要小于第三个数
                // 如果两数之和大于目标值，则把右置针向左移动
                while(second<third && nums[second]+nums[third]>target) {
                    third--;
                }
                // 如果指针相遇，则已经不满足要求，因为要求元素不能重复使用
                // 并且不再需要循环，因为再往后就是指针相交了
                if (second== third) {
                    break;
                }
                if (nums[second]+nums[third]==target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
// @lc code=end

