/*
 * @lc app=leetcode.cn id=3019 lang=java
 *
 * [3019] 按键变更的次数
 */

// @lc code=start
class Solution {
    public int countKeyChanges(String s) {
        
        int count = 0;
        
        // 转成小写，忽略大小写影响
        s = s.toLowerCase();
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count++;
            }
        }
        
        return count;
    }
}
// @lc code=end

