/*
 * @lc app=leetcode.cn id=2367 lang=java
 *
 * [2367] 等差三元组的数目
 */

// @lc code=start
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 思路类似 two sum 或者 three sum
        // 依次放到set里,然后找set内有没有 num-diff 和 num-2*diff
        // 因为是严格递增的,每次放进去的都是set内最大值,
        // 因此只要找比当前放进去的数字小一个diff和两个diff的即可
        
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
            if (set.contains(num - diff) && set.contains(num - 2 * diff)) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

