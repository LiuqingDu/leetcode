/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start

class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, new ArrayList<Long>());
    }

    private boolean dfs(String num, int ind, ArrayList<Long> path) {
        if (ind == num.length()) {
            return path.size() >= 3;
        }

        int max = num.charAt(ind) == '0' ? ind + 1 : num.length();
        long cur = 0;
        for (int i = ind; i < max; i++) {
            cur = cur * 10 + (num.charAt(i) - '0');
            if (path.size() >= 2 && cur > path.get(path.size() - 2) + path.get(path.size() - 1)) {
                break;
            }
            if (path.size() < 2 || cur == path.get(path.size() - 2) + path.get(path.size() - 1)) {
                path.add(cur);
                if (dfs(num, i + 1, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
// @lc code=end

