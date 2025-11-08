/*
 * @lc app=leetcode.cn id=2437 lang=java
 *
 * [2437] 有效时间的数目
 */

// @lc code=start
class Solution {
    public int countTime(String time) {
        // 检测所有符合当前字符串 time 匹配的小时 hh 的数目为 countHour，
        // 同时检测检测所有符合当前字符串 time 匹配的分钟 hh 的数目为 countMinute，
        // 则合法有效的时间数目为 countHour×countMinute。

        int countHour = 0;
        int countMinute = 0;
        for (int i = 0; i < 24; i++) {
            int hiHour = i / 10;
            int loHour = i % 10;
            if ((time.charAt(0) == '?' || time.charAt(0) == hiHour + '0') && 
                (time.charAt(1) == '?' || time.charAt(1) == loHour + '0')) {
                countHour++;
            }
        } 
        for (int i = 0; i < 60; i++) {
            int hiMinute = i / 10;
            int loMinute = i % 10;
            if ((time.charAt(3) == '?' || time.charAt(3) == hiMinute + '0') && 
                (time.charAt(4) == '?' || time.charAt(4) == loMinute + '0')) {
                countMinute++;
            }
        }
        return countHour * countMinute;
    }
}
// @lc code=end

