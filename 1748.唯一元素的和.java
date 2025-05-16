/*
 * @lc app=leetcode.cn id=1748 lang=java
 *
 * [1748] 唯一元素的和
 */

// @lc code=start
class Solution {
    public int sumOfUnique(int[] nums) {
        // 容易想到先遍历放到 map 里,然后遍历 map 求和
        // 这样需要遍历两次
        // 可以在第一次遍历时记录该数字是否已经出现过,如果出现过一次(现在是第二次)
        // 则从总和当中减去并记录,如果出现不止两次(现在至少是第三次),则跳过

        int ans = 0;
        Map<Integer, Integer> state = new HashMap<Integer, Integer>();
        for (int num : nums) {
            // 第一次出现,记入总和
            if (!state.containsKey(num)) {
                ans += num;
                state.put(num, 1);
            } else if (state.get(num) == 1) {
                // 第二次出现,从总和中减去
                ans -= num;
                state.put(num, 2);
            }
            // 其他情况就是出现过三次以上,不处理
        }
        return ans;
    }
}
// @lc code=end

