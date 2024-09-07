/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // 双指针分别指向 name 和 typed
        // 如果两个指针的字符相同，则两个指针均向后移动
        // 如果字符不同，那么有可能是重复输入的字符，
        // 此时 typed 指针字符必须要等于前一个字符
        // 这样的话只需要移动 typed 指针
        // 另一种可能就是 false，不符合要求了
        // 最后，当 typed 指针走完了，判断一下 name 是不是也走完了

        int n = name.length(), m = typed.length();
        int i = 0, j = 0;

        while (j < m) {
            // 如果字符相同则两个指针均移动
            if (i < n && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // 两个字符不同，但 typed 是重复字符，移动 typed 指针
                j++;
            } else {
                // 不符合
                return false;
            }
        }

        // 此时 typed 走完了，看看 name 走完没
        return i == n;
    }
}
// @lc code=end

