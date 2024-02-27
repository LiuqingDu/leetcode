/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start

class Solution {

    private List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {

        backtrack(s, 0, new ArrayList<String>());
        return res;
    }

    private void backtrack(String s, int i, ArrayList<String> cur) {
        if (cur.size() == 4) {
            if (i == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }
        for (int j = 1; j <= 3 && i + j <= s.length(); j++) {
            String sub = s.substring(i, i + j);
            if (j > 1 && sub.charAt(0) == '0') {
                return;
            }
            if (Integer.parseInt(sub) > 255) {
                return;
            }
            cur.add(sub);
            backtrack(s, i + j, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

