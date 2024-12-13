/*
 * @lc app=leetcode.cn id=497 lang=java
 *
 * [497] 非重叠矩形中的随机点
 */

// @lc code=start
class Solution {

    // 前缀和
    // 在一个矩形里随机一个整数点,可以看成是矩形的边以及内部的所有整数点当中抽取一个
    // 那么就是在 (m+1)(n+1) 个点中取一个
    // 坐标为 [ai + Random(xi - ai), bi + Random(yi - bi)]
    // 要从所有矩形当中随机一个矩形,就需要根据矩形的面积来分配概率
    // 可以用前缀和, 累加每一个矩形面积, 每个相邻前缀和之间的区间就是一个矩形的面积
    // 随机一个 0 到总面积之间的数, 落在哪个区间就选择哪个矩形
    // 然后从矩形当中再随机一个点

    private int[][] rectangles;  // 存储矩形的数组，每个矩形是一个四元组 [x1, y1, x2, y2]
    private int[] prefixSums;    // 前缀和数组，prefixSums[i] 存储第 i 个矩形之前所有矩形的面积总和
    private int totalArea;       // 所有矩形的总面积
    private Random random;       // 随机数生成器

    public Solution(int[][] rects) {
        this.rectangles = rects;
        this.totalArea = 0;
        this.random = new Random();
        
        // 初始化前缀和数组，大小为 rectangles.length + 1
        this.prefixSums = new int[rectangles.length + 1];
        
        // 计算每个矩形的面积并填充前缀和数组
        for (int i = 0; i < rectangles.length; i++) {
            int x1 = rectangles[i][0], y1 = rectangles[i][1], x2 = rectangles[i][2], y2 = rectangles[i][3];
            int area = (x2 - x1 + 1) * (y2 - y1 + 1);  // 当前矩形的面积
            totalArea += area;  // 累加总面积
            prefixSums[i + 1] = totalArea;  // 更新前缀和
        }
    }

    public int[] pick() {
        // 随机选择一个目标面积值
        int target = random.nextInt(totalArea) + 1;

        // 使用二分查找找到目标面积值所在的矩形
        int left = 0, right = rectangles.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid + 1] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 找到对应的矩形
        int[] selectedRect = rectangles[left];
        int x1 = selectedRect[0], y1 = selectedRect[1], x2 = selectedRect[2], y2 = selectedRect[3];

        // 在该矩形范围内随机生成一个点
        int x = random.nextInt(x2 - x1 + 1) + x1;
        int y = random.nextInt(y2 - y1 + 1) + y1;

        return new int[]{x, y};  // 返回随机选择的点
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
// @lc code=end

