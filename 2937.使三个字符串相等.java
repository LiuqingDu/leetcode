/*
 * @lc app=leetcode.cn id=2937 lang=java
 *
 * [2937] 使三个字符串相等
 */

// @lc code=start
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        // 找最短长度
        int minLen = Math.min(s1.length(), 
                      Math.min(s2.length(), s3.length()));
        
        int prefixLen = 0;
        
        // 计算最长公共前缀
        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s3.charAt(i);
            
            if (c1 == c2 && c2 == c3) {
                prefixLen++;
            } else {
                break;
            }
        }
        
        // 如果没有公共前缀
        if (prefixLen == 0) {
            return -1;
        }
        
        // 计算删除次数
        return (s1.length() - prefixLen)
             + (s2.length() - prefixLen)
             + (s3.length() - prefixLen);
    }
}
// @lc code=end

