/*
 * @lc app=leetcode.cn id=3042 lang=java
 *
 * [3042] 统计前后缀下标对 I
 */

// @lc code=start
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;

        // 遍历所有可能的下标对 (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 调用判定函数
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        // str1 必须同时是 str2 的前缀和后缀
        // startsWith 和 endsWith 会自动处理长度不足的情况（返回 false）
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
// @lc code=end

