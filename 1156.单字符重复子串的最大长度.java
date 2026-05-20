/*
 * @lc app=leetcode.cn id=1156 lang=java
 *
 * [1156] 单字符重复子串的最大长度
 */

// @lc code=start
class Solution {
    public int maxRepOpt1(String text) {
        // 统计每个字符总出现次数
        int[] cnt = new int[26];

        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }

        int n = text.length();
        int ans = 0;

        // 枚举每一段连续字符
        for (int i = 0; i < n; ) {

            int j = i;

            // 找到连续相同字符的右边界
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }

            // 当前连续段长度
            int len = j - i;

            // 情况1：
            // 当前段后面如果还有相同字符
            // 可以交换一个进来
            ans = Math.max(ans,
                    Math.min(len + 1, cnt[text.charAt(i) - 'a'])
            );

            // 情况2：
            // aaa b aaa
            // 中间隔一个字符
            int k = j + 1;

            // 判断：
            // j 是中间那个不同字符
            // k开始是否还是相同字符
            if (j < n && k < n &&
                    text.charAt(k) == text.charAt(i)) {

                // 找右边连续段
                while (k < n &&
                        text.charAt(k) == text.charAt(i)) {
                    k++;
                }

                // 左段 + 右段
                int total = (j - i) + (k - j - 1);

                // 如果还有多余字符，可以再+1
                ans = Math.max(ans,
                        Math.min(total + 1,
                                cnt[text.charAt(i) - 'a']));
            }

            // 跳到下一段
            i = j;
        }

        return ans;
    }
}
// @lc code=end

