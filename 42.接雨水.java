/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start

class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < height.length; i++) {
            while (!queue.isEmpty() && height[i] > height[queue.peekLast()]) {
                // 新的墙高一点，形成水池了，需要计算这个池子的大小
                // 这里其实只是算了一轮池子，如果完整的池子左侧的墙不是
                // 一堵完整的墙，比如是阶梯下降的墙
                // 那么这里就是只计算最底部那一个阶梯形成的池子
                // 先取出当前的池子底部
                int bottomHeight = height[queue.pollLast()];
                // 如果剩下的栈空了，说明左边没有墙了，那么就没有水池，跳过
                if (queue.isEmpty()) {
                    break;
                }
                // 计算两堵墙之间的距离
                int distance = i - queue.peekLast() - 1;
                // 找到两边矮的那堵墙
                int minWall = Math.min(height[queue.peekLast()], height[i]);
                // 矮墙的高度减去池底的高度，再乘以距离就是这一轮池子的大小
                res += distance * (minWall - bottomHeight);
                // 下面会继续比对栈顶，直到栈顶更大或者为空为止
            }
            queue.addLast(i);
        }
        return res;
    }
}
// @lc code=end

