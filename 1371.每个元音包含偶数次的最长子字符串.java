/*
 * @lc app=leetcode.cn id=1371 lang=java
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 */

// @lc code=start
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> first = new HashMap<>();
        
        int state = 0;
        first.put(0, -1); // 初始状态
        
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 更新状态（只处理元音）
            if (c == 'a') state ^= (1 << 0);
            else if (c == 'e') state ^= (1 << 1);
            else if (c == 'i') state ^= (1 << 2);
            else if (c == 'o') state ^= (1 << 3);
            else if (c == 'u') state ^= (1 << 4);

            // 如果这个状态见过
            if (first.containsKey(state)) {
                res = Math.max(res, i - first.get(state));
            } else {
                first.put(state, i);
            }
        }

        return res;
    }
}
// @lc code=end

