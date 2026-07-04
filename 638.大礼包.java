/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
class Solution {
    // 记忆化 Map，Key 为当前的 needs 状态，Value 为该状态下的最低花费
    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds) {
        // 查缓存
        if (memo.containsKey(curNeeds)) {
            return memo.get(curNeeds);
        }

        // 1. 基础方案：全按单价买
        int minPrice = 0;
        for (int i = 0; i < curNeeds.size(); i++) {
            minPrice += curNeeds.get(i) * price.get(i);
        }

        // 2. 尝试每一种大礼包
        for (List<Integer> sp : special) {
            List<Integer> nextNeeds = new ArrayList<>();
            boolean valid = true;
            
            // 检查大礼包是否超出了当前 needs
            for (int i = 0; i < curNeeds.size(); i++) {
                if (sp.get(i) > curNeeds.get(i)) {
                    valid = false;
                    break;
                }
                nextNeeds.add(curNeeds.get(i) - sp.get(i));
            }

            // 如果该大礼包合法（没有买超），进入下一层递归
            if (valid) {
                minPrice = Math.min(minPrice, sp.get(curNeeds.size()) + dfs(price, special, nextNeeds));
            }
        }

        // 存入缓存
        memo.put(curNeeds, minPrice);
        return minPrice;
    }
}
// @lc code=end

