/*
 * @lc app=leetcode.cn id=2899 lang=java
 *
 * [2899] 上一个遍历的整数
 */

// @lc code=start
class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        // seen 用链表，方便从头部加
        LinkedList<Integer> seen = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int k = 0; // 当前连续 -1 的数量

        for (int num : nums) {
            if (num != -1) {
                // 遇到正整数
                seen.addFirst(num);
                k = 0; // 重置连续 -1
            } else {
                // 遇到 -1
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

