/*
 * @lc app=leetcode.cn id=2273 lang=java
 *
 * [2273] 移除字母异位词后的结果数组
 */

// @lc code=start
class Solution {
    public List<String> removeAnagrams(String[] words) {
        // 如果 words[i] 和 words[i-1] 是异位词，那么保留哪一个都没区别，最后一定会只剩一个。
        // 所以我们可以“线性扫描”一遍，用一个 栈 或者直接用结果数组来模拟：
        // 1.遍历 words，逐个加入结果数组；
        // 2.如果当前单词和结果数组最后一个单词是异位词，就删除当前单词（即不加入结果数组）。

        List<String> res = new ArrayList<>();
        res.add(words[0]);   // 结果数组
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (!compare(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res;
    }
    
    // 判断两个单词是否为字母异位词
    private boolean compare(String word1, String word2) {
        int[] freq = new int[26];
        for (char ch : word1.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            freq[ch - 'a']--;
        }
        for (int x : freq) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

