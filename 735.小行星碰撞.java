/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 小行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 看得出来用栈解决
        // 每次把栈顶跟新的比较决定消除哪个

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            // 标记新来的小行星是否还能存活, 初始为可以存活
            boolean alive = true;
            // 新的还存活, 且新的是向左移动,表明它可能跟栈顶碰撞
            // 当栈顶存在,且是向右移动, 那么它们就会碰撞
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        // 栈转为数组
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
// @lc code=end

