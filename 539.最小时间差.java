/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        // 考虑到一天有 1440 分钟,可以把出现的时间在这个总时间表上记录下来
        // 然后依次比较相邻两个时间点的距离
        // 考虑到可以跨半夜,明显需要把这个时间表用两份拼接起来
        
        int n = timePoints.size();
        // 如果时间点超过 1440 个说明至少有两个相同
        if (n > 1440) {
            return 0;
        }

        int[] timeTable = new int[1440 * 2];
        for (String s : timePoints) {
            String[] ss = s.split(":");
            int h = Integer.parseInt(ss[0]);
            int m = Integer.parseInt(ss[1]);
            // 标记这个时间点是存在的
            // 这里记录个数而不是仅仅标记为存在
            // 是因为后续要查找是否有相同的时间点
            timeTable[h * 60 + m]++;
            timeTable[h * 60 + m + 1440]++;
        }

        // 因为至少有两个时间点,那么最大时间差就是 12 小时,720 分钟
        int res = 720, pre = -1;
        // res 最小为 0,如果已经是 0 了就不需要再继续了
        for (int i = 0; i < 1440 * 2 && res != 0; i++) {
            // 如果时间不存在则跳过
            if (timeTable[i] == 0) {
                continue;
            }
            // 如果有相同的时间则最小时间差为 0
            if (timeTable[i] > 1) {
                res = 0;
            } else if (pre != -1) {
                res = Math.min(res, i - pre);
            }
            pre = i;
        }
        return res;
    }
}
// @lc code=end

