/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
class Solution {
    //记忆化的hashMap,用来记录选择了哪些树的情况，当前玩家的胜负；用以减少时间复杂度
    Map<Integer, Boolean> memory = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // dfs 深度优先去寻找当前选择数字的方案能否赢
        // 选择过的数字最多有20个，可以用二进制表示
        // 每一位二进制表示第几个数字是否用过
        // 把每次选择的结果存起来，减少重复
        // 关键点在于，题目要求我先手赢
        // 如果我现在这一手无法赢，那么我这一轮之后，就相当于对手是先手
        // 那么就需要保证对手在先手的情况下输，对应的就是我这一轮可以赢
        // 只要可以赢，那么就是存在稳赢的方法，就是当前的路径

        //如果加起来都不能超过的话，都不可能赢，return false
        if ((1+maxChoosableInteger)*maxChoosableInteger*0.5<desiredTotal){
            return false;
        }
        //否则的话递归判断，判断先手能不能赢，需要注意的是，先手从0开始
        return dfs(maxChoosableInteger,0,desiredTotal,0);
    }


    /**
     *
     * @param maxChoosableInteger 供选择的数
     * @param userNumbers  被选择的数，注意用二进制表示，可能比较难以理解。如0100则表示3已经被选择，0001则表示1已被选择
     * @param desiredTotal  累计整数合需要超过的目标值
     * @param currentTotals  当前累计整数合
     * @return
     */
    private boolean dfs(int maxChoosableInteger, int userNumbers, int desiredTotal, int currentTotals) {
        // 如果未曾玩过这种场景，则做下列工作找出这种场景的答案
         if (!memory.containsKey(userNumbers)){
             boolean res = false;
             // 循环遍历选择每个数的情况，如果循环完所有的情况，都赢不了，那么就输了，因此初始res是输
             for (int i = 0; i < maxChoosableInteger; i++) {
                 // 若这个数还没被选择，才往下做逻辑，否则进入下一轮循环(注意这里i是从0开始，所以判断的是第i+1个数的情况)
                 if (((userNumbers >> i) & 1) == 0) {
                     // 如果选完能直接胜利，那么结果自然为true
                     if (i + 1 + currentTotals >= desiredTotal) {
                         res = true;
                         break;
                     }
                     // 否则的话，递归判断，我选完后，对方选完是不是就输了；对方输了，我自然就赢了，有点绕
                     if (!dfs(maxChoosableInteger, userNumbers | (1 << i), desiredTotal, currentTotals + i + 1)) {
                         res = true;
                         break;
                     }
                 }
             }
             // 把结果放入记忆化
             memory.put(userNumbers,res);
         }
        return memory.get(userNumbers);
    }
    // 解释一下这题移位法两个操作：（userNumbers >> i) & 1 ：判断i+1是否已经被访问； userNumbers | (1 << i)：把i+1标记为访问
}
// @lc code=end

