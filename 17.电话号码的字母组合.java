/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new LinkedList<String>();
    char[] digit, path;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        this.digit = digits.toCharArray();
        this.path = new char[digits.length()];
        dfs(0);

        return res;
    }

    private void dfs(int i) {
        if (i == this.digit.length) {
            res.add(new String(path));
            return;
        }

        for (char c: map[this.digit[i] - '0'].toCharArray()) {
            this.path[i] = c;
            dfs(i + 1);
        }

    }
}
// @lc code=end

