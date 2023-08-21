/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

class Solution {
    // 长度不固定的滑动窗口
    public String minWindow(String s, String t) {
        // 存储目标字符串和窗口内匹配的字符串
        Map<Character, Integer> target = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();

        // 初始化目标字符串
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        // 左右窗口，窗口左闭右开
        int left = 0, right = 0;
        // 记录几个字母已经完全匹配上
        int valid = 0;
        // 记录最终结果，起始索引和最小长度
        int start = 0, len = Integer.MAX_VALUE;

        // 不停往右移动窗口右边界
        // 注意这里右边界虽然是开区间，按理来说这里应该允许right=s.len，
        // 但循环体内一上来就会把窗口往右移动
        // 这里的条件实际上是：当还可以把窗口往右移动的时候进入循环
        // 进入循环后先把开区间的值取出来，再移动窗口，所以实际上只要开区间的位置是索引范围内就符合
        while(right < s.length()) {
            // 取出右窗口开区间的字符，也就是窗口右移一位
            char c = s.charAt(right);
            // 移动窗口
            right++;

            // 进行窗口内数据的一系列更新
            // 如果新进来的字符是目标字符，也就是属于t里面
            if (target.containsKey(c)) {
                // 更新窗口内字符
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果刚好满足了目标字符的数量，则更新valid
                if (window.get(c).equals(target.get(c)))
                    valid++;
            }

            // valid记录已经满足数量的字符种类
            // 当valid跟target.size相同，表示所有字符都已经满足了最小数量
            while(valid == target.size()) {
                // 开始移动左窗口
                // 如果当前长度更小，则更新结果
                // 这里右窗口是开区间，所以长度就是right-left，不用再+1
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // 取出左窗口的值
                char d = s.charAt(left);
                // 左窗口往右移动
                left++;

                // 如果左窗口的字符在目标串里，则需要同步更新字符数量
                if (target.containsKey(d)) {
                    // 如果去掉这个字符之前，目标值相同，则说明去掉这个字符之后，这个字符就不够多了
                    // 那么valid也就需要-1
                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    // 更新窗口内字符数量
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
// @lc code=end

