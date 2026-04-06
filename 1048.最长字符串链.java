/*
 * @lc app=leetcode.cn id=1048 lang=java
 *
 * [1048] 最长字符串链
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        
        // 1 按长度排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        int res = 1;
        
        for (String word : words) {
            int max = 1;
            
            // 2 枚举删除一个字符
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                
                if (dp.containsKey(prev)) {
                    max = Math.max(max, dp.get(prev) + 1);
                }
            }
            
            dp.put(word, max);
            res = Math.max(res, max);
        }
        
        return res;
    }
}
// @lc code=end

