/*
 * @lc app=leetcode.cn id=2942 lang=java
 *
 * [2942] 查找包含给定字符的单词
 */

// @lc code=start
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

