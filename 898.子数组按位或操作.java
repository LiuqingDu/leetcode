/*
 * @lc app=leetcode.cn id=898 lang=java
 *
 * [898] 子数组按位或操作
 */

// @lc code=start
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        
        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for (int y : cur) {
                next.add(y | x);
            }
            cur = next;
            ans.addAll(cur);
        }
        
        return ans.size();
    }
}
// @lc code=end

