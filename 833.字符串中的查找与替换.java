/*
 * @lc app=leetcode.cn id=833 lang=java
 *
 * [833] 字符串中的查找与替换
 */

// @lc code=start
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // 维护一个真正需要进行的替换操作列表
        // replace[indices[i]]=(target[i],len(sources[i]))
        // 表示在s的indices[i]位置开始，长度为len(sources[i])的字符串需要被替换为target[i]
        // 然后遍历s，遇到replace[i]不为空的情况，就进行替换

        
        int n = s.length();
        var replaceStr = new String[n]; // 替换后的字符串
        var replaceLen = new int[n];    // 被替换的长度
        Arrays.fill(replaceLen, 1);     // 无需替换时 i+=1
        for (int i = 0; i < indices.length; i++) {
            // 如果s的indices[i]位置开始的字符串与sources[i]相同，则进行替换
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                // 需要替换
                replaceStr[idx] = targets[i];
                // 记录替换的长度
                // 这里的长度是sources[i]的长度
                replaceLen[idx] = sources[i].length();
            }
        }

        var ans = new StringBuilder();
        for (int i = 0; i < n; i += replaceLen[i]) { // 无需替换时 i+=1
            if (replaceStr[i] == null) {
                // 无需替换
                // 直接添加s[i]
                ans.append(s.charAt(i));
            } else {
                // 需要替换
                // 添加替换后的字符串
                ans.append(replaceStr[i]);
            }
        }
        return ans.toString();
    }
}
// @lc code=end

