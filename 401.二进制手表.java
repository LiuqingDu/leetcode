xu/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        // 回溯，只不过这里涉及到两个数字做选择
        // 分别初始化两个数字所有可能性，为了统一位置，两个均扩为10个选项，其中前4个是小时
        // 后6个是分钟，相当于把所有选项前后排列
        // 分别用两个值记录当前已选择的累计和
        // 如果累计和超出范围直接返回，剪枝
        int[] hours   = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
        int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<String>();
        backtrack(turnedOn, 0, 0, 0, 0, hours, minutes, res);
        return res;
    }

    private void backtrack(int target, int current, int index, int hour, int minute, int[]hours, int[] minutes, List<String> res) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (target == current) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < 10; i++) {
            backtrack(target, current + 1, i + 1, hour + hours[i], minute + minutes[i], hours, minutes, res);
        }
    }
}
// @lc code=end

