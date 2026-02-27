/*
 * @lc app=leetcode.cn id=2900 lang=java
 *
 * [2900] 最长相邻不相等子序列 I
 */

// @lc code=start
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        
        // 先选第一个
        result.add(words[0]);
        int lastGroup = groups[0];
        
        // 从第二个开始遍历
        for(int i = 1; i < words.length; i++){
            
            // 如果group不同就加入
            if(groups[i] != lastGroup){
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }
        
        return result;
    }
}
// @lc code=end

