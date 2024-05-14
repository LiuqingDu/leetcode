/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // 多数元素是数量超过一半的元素，也就是它的数量比其他元素的数量之和都大
        // 可以把每个元素看作是不同阵营的士兵，同数字的是一个阵营的
        // 先让第一个数字占领地盘，然后依次遍历后续的元素
        // 如果新来的元素与地盘上的士兵是同一个阵营的，那么士兵数量count+1
        // 如果新来的不是一个阵营的，那么派出一个地盘上的士兵与新来的同归于尽，count-1
        // 如果对拼之后地盘上阵营没有士兵了，count==0，这时也不用变更地盘上的阵营标记
        // 因为说明目前至少有两个阵营人数一样多，未来肯定会有一个更多，但目前大家都是同等势力
        // 选哪个当作临时的胜者都不影响，所以可以不改
        // 如果对拼之前，当前地盘上已经没有士兵了，说明当前阵营目前不是多数，那就把新来的标记为底盘上的势力

        // 标记第一个胜者阵营
        int winner = nums[0];
        // 记录当前阵营超额的人数，这个数字为负数的时候就需要更换winner
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            // 如果新来的跟当前阵营相同，则加入队伍
            if (nums[i] == winner) {
                count++;
            } else {
                // 如果新来的是不同阵营的

                // 如果当前阵营还有人，那么就派出一个同归于尽
                if (count > 0) {
                    count--;
                } else {
                    // 这里实际上count也就只能是0了，不会是负数
                    // 如果当前阵营没人了，那么新来的阵营作为新的winner
                    winner = nums[i];
                    count = 1;
                }
            }
        }

        return winner;

    }
}
// @lc code=end

