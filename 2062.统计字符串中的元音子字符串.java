/*
 * @lc app=leetcode.cn id=2062 lang=java
 *
 * [2062] 统计字符串中的元音子字符串
 */

// @lc code=start
class Solution {
    public int countVowelSubstrings(String word) {
        int res = 0;
        int n = word.length();
        int left = 0;
        
        while (left < n) {
            // 跳过非元音字符
            if (!isVowel(word.charAt(left))) {
                left++;
                continue;
            }
            
            // 找到最长的全元音子串 [left, right)
            int right = left;
            while (right < n && isVowel(word.charAt(right))) {
                right++;
            }
            
            // 处理全元音子串 [left, right-1]
            if (right - left >= 5) {
                res += countValidSubstrings(word, left, right);
            }
            
            // 移动到下一个可能的窗口起点
            left = right;
        }
        
        return res;
    }
    
    // 判断字符是否为元音
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    // 计算全元音子串中符合条件的子串数量
    private int countValidSubstrings(String s, int left, int right) {
        int count = 0;
        int[] freq = new int[26]; // 记录元音频率
        int validCount = 0; // 已出现的不同元音数量
        int start = left;
        
        for (int end = left; end < right; end++) {
            char c = s.charAt(end);
            freq[c - 'a']++;
            
            // 如果是首次出现该元音，增加有效计数
            if (freq[c - 'a'] == 1) {
                validCount++;
            }
            
            // 尝试收缩窗口，找到最小有效窗口
            while (validCount == 5 && freq[s.charAt(start) - 'a'] > 1) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }
            
            // 如果窗口包含全部5个元音，计算贡献
            if (validCount == 5) {
                count += start - left + 1;
            }
        }
        
        return count;
    }
}
// @lc code=end

