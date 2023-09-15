/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    // 动态规划，严格讲不是很明显的动态规划而是带备忘录的递归
    // 从s的第一个字符开始，长度依次增加，看前i个字符是否是wordDict里的一个单词，
    // 如果是，那么整个s能否拼出来取决于【s的剩下后部分的能否被拼出来】，
    // 如果遍历到结尾都没有找到是wordDict的单词，那么就不能拼出来，
    // 定义dp[i]表示s的从第i个字符开始往后的字符是否能拼出来

    HashSet<String> wordSet;
    // dp的值：-1表示还没有遍历，0表示不能拼出来，1表示可以拼出来
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {

        wordSet = new HashSet<String>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return canBreak(s, 0);
    }

    private boolean canBreak(String s, int i) {
        // 如果已经到尾部了，则返回true
        if (i == s.length()) {
            return true;
        }

        // 如果已经计算出来值了则直接返回
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }

        // 寻找前len位字符是否是存在的单词
        // 长度至少为1，注意substring第二个参数指向的位置是不被包含的，所以这里len可以指向最后一个字符的下一位
        // 也就是len可以超出最大索引1位
        for (int len = 1; i + len <= s.length(); len++) {
            String word = s.substring(i, i + len);
            if (wordSet.contains(word)) {
                // 如果存在，则i之后的字符串能否拼出，取决于除了当前单词，剩下的后部分字符是否能拼出来
                boolean sub = canBreak(s, i + len);
                // 如果能拼出，则记录下来并返回
                if (sub) {
                    memo[i] = 1;
                    return true;
                }
                // 如果不能拼出，进入下一个循环继续尝试
            }
        }
        // 尝试到s的尽头了都没拼出来，记录下来并返回
        memo[i] = 0;
        return false;
    }
}
// @lc code=end

