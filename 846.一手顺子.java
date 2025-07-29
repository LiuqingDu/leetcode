/*
 * @lc app=leetcode.cn id=846 lang=java
 *
 * [846] 一手顺子
 */

// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // 如果手牌数量不能被分组大小整除，直接返回 false
        // 对手牌排序, 最小的牌x一定是其中一组的最小值,
        // 这一组的值是[x, x+1, ..., x+groupSize-1]
        // 如果这些值都在手牌中, 则可以组成一组
        // 然后从手牌中移除这些值, 继续寻找下一组
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        // 从最小的牌开始，尝试分组
        for (int card : hand) {
            if (!countMap.containsKey(card)) {
                continue; // 如果当前牌已经全都用掉了,则跳过
            }
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (!countMap.containsKey(currentCard) || countMap.get(currentCard) <= 0) {
                    return false; // 如果当前组的牌不完整，返回 false
                }
                countMap.put(currentCard, countMap.get(currentCard) - 1);
                if (countMap.get(currentCard) == 0) {
                    countMap.remove(currentCard); // 如果当前牌的数量为0，移除它
                }
            }
        }
        return true; // 如果所有牌都能被分组，返回 true
    }
}
// @lc code=end

