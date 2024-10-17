/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        // i 控制最终结果的数量
        // j 是放入结果的数字
        // 优先把有 0 的添加进去
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            ans.add(j);
            // 优先末尾加 0 放入结果
            if (j * 10 <= n) {
                j *= 10;
            } else {
                // 依次把剩下的结果放入
                // 如果末尾是 9，那么说明需要尝试进位后从 0 再继续
                // 但需要先添加一个进位后不带 0 的，
                // 再下一轮才是进位后不带 0，然后*10 形成进位带 0 的
                while (j % 10 == 9 || j + 1 > n) {
                    j /= 10;
                }
                j++;
            }
        }
        return ans;
    }
}
// @lc code=end

