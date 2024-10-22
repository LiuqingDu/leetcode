/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        // 猛一看应该是滑动窗口，但仔细想一下好像不是常规的滑动窗口
        // 滑动窗口要求明确什么时候滑动右边，什么时候停止右边，
        // 什么时候滑动左边，什么时候停止左边，
        // 这个条件一般是跟窗口内状态相关的
        // 这道题的问题是，窗口内的状态不确定
        // 比如右边进来一个新的字符，那么右边能不能继续滑？
        // 这取决于后面还有没有相同的字符使得它的次数至少为 k
        // 这样除非右边一直滑动到底，否则无法判断这个新字符能否进入窗口

        // 注意到这道题规定了出现的只能是小写字母，那么最多有 26 种字母
        // 可以规定窗口内可以有多少种字符，来限定窗口
        // 这样需要在最外面循环 26 次，代表走 26 轮滑动窗口
        // 每轮规定窗口内字符的种类为 i
        // 滑动过程：
        // 统计窗口内有多少种字符，记为 m，
        // 统计有多少种字符的次数满足 k，记为 n
        // 每次从右边滑入一个字符，并对这个字符的出现次数+1
        // 如果这个字符次数 == 1，表示是个新字符，那么 m+1
        // 当这个字符次数 == k 时，表示它第一次满足，那么 n+1
        // 此时如果 m > i，说明窗口内字符种类多了，需要减少
        // 移动左窗口来减少，直到 m = i
        // 此时，窗口内刚好有 m == i 种字符，比较 n 和 k
        // 如果 n == k，说明窗口内是一个符合条件的子串，比较记录最大长度
        // 完成一次窗口滑动

        // int ans = 0;
        // int n = s.length();
        // char[] cs = s.toCharArray();
        // int[] cnt = new int[26];
        // for (int p = 1; p <= 26; p++) {
        //     Arrays.fill(cnt, 0);
        //     // tot 代表 [j, i] 区间所有的字符种类数量；sum 代表满足「出现次数不少于 k」的字符种类数量
        //     for (int i = 0, j = 0, tot = 0, sum = 0; i < n; i++) {
        //         int u = cs[i] - 'a';
        //         cnt[u]++;
        //         // 如果添加到 cnt 之后为 1，说明字符总数 +1
        //         if (cnt[u] == 1) tot++;
        //         // 如果添加到 cnt 之后等于 k，说明该字符从不达标变为达标，达标数量 + 1
        //         if (cnt[u] == k) sum++;
        //         // 当区间所包含的字符种类数量 tot 超过了当前限定的数量 p，那么我们要删除掉一些字母，即「左指针」右移
        //         while (tot > p) {
        //             int t = cs[j++] - 'a';
        //             cnt[t]--;
        //             // 如果添加到 cnt 之后为 0，说明字符总数-1
        //             if (cnt[t] == 0) tot--;
        //             // 如果添加到 cnt 之后等于 k - 1，说明该字符从达标变为不达标，达标数量 - 1
        //             if (cnt[t] == k - 1) sum--;
        //         }
        //         // 当所有字符都符合要求，更新答案
        //         if (tot == sum) ans = Math.max(ans, i - j + 1);
        //     }
        // }
        // return ans;


        // 还有一种方法更容易理解一些，分治的思想
        // 使用递归，对于一个字符串，先记录下当前串每个字符出现的次数
        // 如果有一个字符的次数小于 k，说明这个字符不能出现在最终子串当中
        // 那么也就是最终子串不能在父串种跨越这个字符
        // 那么可以用这个字符把父串切割成多个子串，最终的子串必定在其中一个子串的内部
        // 而不会跨越子串
        // 此时形成递归，可以递归每一个子串继续找

        if (s.length() < k) {
            return 0;
        }
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();

    }
}
// @lc code=end

