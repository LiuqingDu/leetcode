/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // 排序：将房子 (houses) 和暖气 (heaters) 的数组分别排序，便于后续查找最近的暖气。
        // 双指针：使用两个指针，一个遍历房子，另一个遍历暖气，找到每个房子到最近暖气的距离。
        // 半径计算：对每个房子取到暖气的最小距离，然后在所有房子中取最大值作为结果。
        // 对 houses 和 heaters 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;
        int heaterIndex = 0;

        for (int house : houses) {
            // 找到离当前 house 最近的 heater
            // 绝对值那里是判断如果下一个heater到房子的距离更近，那么就选择下一个heater
            // 否则保持当前heater
            while (heaterIndex < heaters.length - 1
                    && Math.abs(heaters[heaterIndex + 1] - house) <= Math.abs(heaters[heaterIndex] - house)) {
                heaterIndex++;
            }
            // 计算当前房子到最近暖气的距离
            radius = Math.max(radius, Math.abs(heaters[heaterIndex] - house));
        }

        return radius;
    }
}
// @lc code=end

