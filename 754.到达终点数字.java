/*
 * @lc app=leetcode.cn id=754 lang=java
 *
 * [754] 到达终点数字
 */

// @lc code=start
class Solution {
    public int reachNumber(int target) {
        // 先一直都选择向右走,
        // 1. 如果走了 1~n 刚好走到目标上,则最小次数为 n
        // 如果走了 1~n 刚好超过目标, 则有如下情况:
        // 2. 如果超出目标为偶数步, 则: 若超出 2 步,则第一步反向走, 若超出 4 步,则第二步反向走..., 答案依然是 n
        // 3. 如果超出目标为奇数步, 则多走一步, 若走一步之后相差偶数步,则转换为情况 2, 答案是 n+1
        // 4. 如果超出奇数,且多走一步后还是超出奇数,则再多走一步,必定变为超出偶数,此时转换为情况 2, 答案是 n+2

        // 为什么这样是最小步数:
        // 情况 1 不需要讨论,必定最小
        // 情况 2, 超出目标后选取其中一步走回头, 如果不走这 n 步则根本无法到达目标
        // 情况 3, 4, 回退步数只能让总距离减少偶数, 无法减少奇数, 如果需要处理奇数,则需要通过前进来变成偶数处理
        // 对于情况 4, 因为前进步数是奇偶相间的,所以如果走了一步后距离还是奇数,多走一步必定会让间距的奇偶性变化
        
        // 对于情况 3 和 4, 其实就是累加到步数是偶数为止, 然后当做情况 2 来处理
        // 情况 1 其实就是情况 2 的特殊情况

        target = Math.abs(target);
        int s = 0, n = 0;
        // 没有到达（越过）终点，或者相距奇数
        while (s < target || (s - target) % 2 == 1){
            // 先算出下一步的长度
            n++;
            s += n;
        }
        return n;
    }
}
// @lc code=end

