/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        // dfs
        
        List<String> ans = new ArrayList<String>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    private void dfs(char[] arr, int pos, List<String> res) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        // 大小写字母的二进制编码正好是在右数第 6 位不同
        // 那么用 100000 跟字母编码异或,就可以转换第 6 位的 0 和 1
        // 实现 0 变 1, 1 变 0
        // 也就是跟 32 异或
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
    }
}
// @lc code=end

