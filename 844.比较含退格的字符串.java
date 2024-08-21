/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // 从前往后拼字符串复杂度很高
        // 一个字符是否保留取决于后面有没有删除符号
        // 可以从后往前遍历，记录还有多少个删除符号没有用过
        // 遇到字符先看还有没有删除操作，有就跳过这个字符
        // 没有就说明这个字符是在最终结果里的
        // 依次取出两串字符的一个最终字符进行比较
        // 另外，如果有一个到头了另一个还没到头，说明也不匹配
        int i = s.length() - 1;
        int j = t.length() - 1;
        // 记录有多少个删除符号没用过，也就是还要跳过多少个字符
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                // 记录删除个数
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    // 消耗一个删除操作，跳过一个字符
                    skipS--;
                    i--;
                } else {
                    // 此时 i 指向一个最终字符
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                // 这里是有且仅有一个到左边界了，说明两个不一样
                return false;
            }

            i--;
            j--;
        }
        // 这里是两个指针都指向了最左侧，比完了
        return true;
    }
}
// @lc code=end

