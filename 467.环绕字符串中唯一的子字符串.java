/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String s) {
        // 可以看出用dp解决
        // dp[i] 表示以第 i 个字符结尾的字符串，有多少个非空子串在 base 里
        // 那么 dp[i] 会依赖 dp[i - 1]
        // 如果新字符与前一个字符相连，那么 dp[i] = dp[i-1] + 1
        // 否则 dp[i] = dp[i-1]
        // 看上去只要把 dp 求和就可以了
        // 但这里有一个问题，比如 cac，求和的话两个 c 都被算了一次
        // 得出答案为 3，但实际答案应该为 2
        // 所以需要把同字符结尾的去重
        // 可以记录每一个字符结尾的最大长度
        // 比如 cac，对于 c 就记录为 1
        // 比如 bab，对于 b 就记录为 2
        // 表示以 b 结尾的子串最长长度为 2
        // 这里第一个 b 它可以形成的子串实际上会被后面的 ab 包含
        // 实际上只需要记录同字符结尾的最长的那一个就可以了
        // 另外，对于dp实际上也不需要全部存下来，每次只用到了上一轮的dp
        // 可以用一个变量代替整个dp


        int n = s.length();
        if (n == 0) {
            return 0;
        }
        // 每个字符的最大连续子字符串长度
        int[] arr = new int[26];
        // 当前连续子字符串的长度
        int currLength = 0;

        for (int i = 0; i < n; i++) {
            // 如果当前新字符连续，那么当前字符结尾的子串长度+1
            if (i > 0 && 
                (s.charAt(i) - s.charAt(i - 1) == 1 || 
                 (s.charAt(i) == 'a' && s.charAt(i - 1) == 'z'))) {
                currLength++;
            } else {
                // 否则重置为 1
                currLength = 1;
            }
            // 更新当前字符结尾的最长子串长度
            int index = s.charAt(i) - 'a';
            arr[index] = Math.max(arr[index], currLength);
        }

        int result = 0;
        for (int val : arr) {
            result += val;
        }
        return result;
    }
}
// @lc code=end

