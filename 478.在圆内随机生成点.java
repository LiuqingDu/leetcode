/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {
    // 拒绝采样
    // 在边长 2r 的正方形里随机一个点
    // 如果该点不在圆内则抛弃,重新随机
    Random random;
    double xc, yc, r;

    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }
    
    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xc + x, yc + y};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

