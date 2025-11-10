/*
 * @lc app=leetcode.cn id=2446 lang=java
 *
 * [2446] 判断两个事件是否存在冲突
 */

// @lc code=start
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
// @lc code=end

