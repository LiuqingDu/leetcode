/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        // 容易看出可以用栈来分别记录次数和字符串
        // 遇到 ] 的时候进行一次运算，遇到 [ 的时候要把当前的字符串和次数都放到栈里
        // 遇到 [ 的时候必定会有次数，有可能会有字符串，比如 3[a2[b]] 就会有 a 和 2
        // 遇到 ] 的时候，用当前的字符串和次数栈的栈顶来重复，然后在前面拼接上字符串栈的栈顶
        // 比如 3[a2[b]] 在用 2 和 b 重复完之后，在前面拼接上 a

        LinkedList<Integer> times = new LinkedList<>();
        LinkedList<String> strs = new LinkedList<>();

        // 当前的字符串和次数
        StringBuilder res = new StringBuilder();
        int time = 0;

        for(Character c : s.toCharArray()) {
            // 存到栈里并重置
            if(c == '[') {
                times.addLast(time);
                strs.addLast(res.toString());
                time = 0;
                res = new StringBuilder();
            }
            // 当前字符串和次数栈顶进行重复，然后拼上字符串栈顶
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = times.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(strs.removeLast() + tmp);
            }
            // 累计次数
            else if(c >= '0' && c <= '9') time = time * 10 + Integer.parseInt(c + "");
            // 累计字符串
            else res.append(c);
        }
        return res.toString();
    }
}
// @lc code=end

