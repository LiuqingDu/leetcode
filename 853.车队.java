/*
 * @lc app=leetcode.cn id=853 lang=java
 *
 * [853] 车队
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 因为后面的车不能超过前面的车, 所以第一个车队肯定是第一辆车
        // 后续的车能否加入前面的车队,取决于后面的车能否在终点前赶上前车
        // 也就是后面的车到达终点的时间是否小于等于前面车到达终点的时间
        // 按照出发位置从大到小排序,也就是离终点近的车在前面
        // 然后依次考虑每辆车能否赶上前面的车来加入车队,还是赶不上然后自己形成新的车队
        
        int n = position.length;
        // 每辆车：[位置, 时间]（到达终点所需时间）
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // 计算每辆车到达终点的时间
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // 按照位置从大到小排序（靠近终点的排在前面）
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // 用 stack 保存每个车队的“最慢车到达时间”
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = cars[i][1];

            // 如果当前车比前面的车耗时更长，无法追上，就形成新车队
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);  // 新车队
            }
            // 否则，追上了前车，属于同一个车队，不入栈
        }

        return stack.size(); // 栈的大小即为车队数量
    }
}
// @lc code=end

