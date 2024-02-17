/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start

class Solution {
    public String simplifyPath(String path) {

        List<String> queue = new ArrayList<String>();
        int n = path.length();

        for (int i = 0; i < n; i++) {
            while (i < n && path.charAt(i) == '/') {
                i++;
            }
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }

            // 如果i已经到末尾了，那么就不用继续了
            // 如果不加这一句，下面substring会超出索引
            if (i >= n) {
                break;
            }

            String p = path.substring(i, j);

            if (p.equals("..")) {
                if (queue.size() != 0) {
                    queue.remove(queue.size() - 1);
                }
            } else if (!p.equals(".") && !p.isEmpty()) {
                queue.add(p);
            }

            i = j;
        }

        StringBuilder sb = new StringBuilder();
        for (String s: queue) {
            sb.append("/").append(s);
        }

        return sb.length() == 0 ? "/" : sb.toString();

    }
}
// @lc code=end

