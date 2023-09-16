/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    // 动态规划
    // 类似题目139，在它的基础上，找到组成的方案后记录下来

    HashSet<String> wordSet;
    // 备忘录，表示从s的第i个字符开始往后的字符串，能拆分的所有单词方案
    List<String>[] memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<String>(wordDict);
        // 这里尺寸只需要等于s长度即可，也就是索引为s.length()-1
        // 不需要尺寸+1，因为当索引等于s.length()的时候，canBreak方法直接返回了，不会操作memo
        memo = new List[s.length()];

        return canBreak(s, 0);
    }

    // 表示从s的第i个字符往后的字符串，所有能拆分的单词方案
    private List<String> canBreak(String s, int i) {
        // 记录从i开始的所有单词拆分方案
        LinkedList<String> res = new LinkedList<String>();
        // 如果已经到头了，直接返回，给一个空方案
        if (i == s.length()) {
            res.add("");
            return res;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        // 从长度为1的单词开始匹配
        for (int len = 1; i + len <= s.length(); len++) {
            String prefix = s.substring(i, i + len);
            // 看前len个字符组成的单词是否在字典里
            if (wordSet.contains(prefix)) {
                // 如果在字典里，那么就继续把剩下的字符拼出来
                List<String> sub = canBreak(s, i + len);
                // 遍历剩下的字符的方案
                for (String su: sub) {
                    // 如果哦是空方案，则说明剩下的字符没有单词，也就是到头了
                    // 那么直接把当前单词加入，避免多余空格
                    if (su.length() == 0) {
                        res.add(prefix);
                    } else {
                        // 否则把当前单词和剩下的方案拼起来，用空格隔开
                        res.add(prefix + " " + su);
                    }
                }
            }
        }

        // 记录当前方案并返回
        memo[i] = res;
        return res;
    }
}
// @lc code=end

