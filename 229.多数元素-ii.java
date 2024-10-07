/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 摩尔投票法，大致思路是先取一个候选人，依次跟后续的票来对抗抵消
        // 如果下一张票跟当前候选人相同，则累加票数
        // 如果不同，则抵消一张当前候选人的票，如果抵消之前，当前候选人的票数已经是 0
        // 则替换候选人为新的票的持有人
        // 最后剩下的那个人，如果他剩下的票大于 0，则说明这个人可能是会超过一半的票数
        // 这里还需要再遍历一遍确认是否超过一半，之前的步骤只是选出可能的那个人

        // 题中可知，超过1/3的数字最多只会有两个，最少可能一个都没有
        // 那么记录两位候选人，最终会记录两个潜在的候选人，再遍历验证一下
        List<Integer> res = new ArrayList<Integer>();
        int card1 = nums[0], count1 = 0;
        int card2 = nums[0], count2 = 0;
        // 理解 count 表示的是，它相对于最少的那一个候选者（第三名），当前候选者多出来几张票
        // 所以当 count1 == 0 的时候，只需要替换 card1 即可，不需要操作 card2
        // 具体看下面注释

        for (int num : nums) {
            if (card1 == num) {
                count1++;
                continue;
            }

            if (card2 == num) {
                count2++;
                continue;
            }

            // 这里说明新的票跟这两位候选者都不同

            if (count1 == 0) {
                // 这里说明在新的票之前，card1 已经跟新票候选者的票数相同了，
                // 那么这张新票来了以后，原先的 card1 就是最少的，需要被替换
                // 新票候选者就是比原先 card1 多 1 张
                // count2 不需要改，因为它也等于比原先 card1 多的票，也就是比最少的候选人多的票
                card1 = num;
                count1 = 1;
                continue;
            }

            if (count2 == 0) {
                card2 = num;
                count2 = 1;
                continue;
            }

            count1--;
            count2--;
        }

        // 验证票数是不是大于 1/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (card1 == num) {
                count1++;
            } else if (card2 == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            res.add(card1);
        }
        if (count2 > nums.length / 3) {
            res.add(card2);
        }

        return res;
    }
}
// @lc code=end

