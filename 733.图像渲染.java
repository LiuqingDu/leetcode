/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    int[][] image;
    int ori;
    int color;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    
        // 保存需改变的原始颜色
        ori = image[sr][sc];
        // 测试用例有一个坑，如果原来的颜色和新的颜色一样，则会陷入死循环，这里要判断一下
        if (ori == color) {
            return image;
        }
        this.image = image;
        this.color = color;
        color(sr, sc);
        return image;
    }

    private void color(int sr, int sc) {
        // 超过图案边界的直接返回
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        // 如果当前颜色跟最初颜色相同则变色，且继续检查四个方向的点
        if (image[sr][sc] == ori) {
            image[sr][sc] = color;
            color(sr - 1, sc);
            color(sr + 1, sc);
            color(sr, sc - 1);
            color(sr, sc + 1);
        }
    }
}
// @lc code=end

