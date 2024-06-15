/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // 假设s由一个字串重复多次组成，记字串为s'，长度为n'
        // 那么s = s'+s'+s'...
        // 如果把s左侧的字符一个一个依次挪到末尾，直到挪了一个s',
        // 挪动之后的字符串依然等于原先的字符串
        // 可以直接把s复制一份拼在后面，然后用一个固定长度的窗口，从第二个字符开始看，
        // 窗口内的字符串就是挪动每一个字符后的结果
        // 直到窗口挪动了一个n'后，窗口内就等于原字符串
        // 因为不考虑不挪动的情况，所以n'不等于0也不等于s的长度n。
        // 我们可以直接把拼接后的字符串里第一个字符跟最后一个字符去掉
        // 这样窗口内就不会出现n'=0和n'=n的情况了
        // 然后直接在剩下的字符串里找原字符串就可以了
        String str = s + s;
        return str.substring(1, str.length() - 1).indexOf(s) != -1;

    }
}
// @lc code=end

