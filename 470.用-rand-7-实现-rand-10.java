/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    // https://leetcode.cn/problems/implement-rand10-using-rand7/solutions/167850/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/?source=vscode
    // 链接中的题解有如下结论
    // (randX() - 1) * Y + randY() = randXY() 可以实现[1,x*y]的随机数
    // 那么 rand7 就可以实现 rand49
    // 对于 1~40 的值可以对 10 取余直接输出
    // 对于 41~49 可以忽略并重新进行一次随机
    public int rand10() {
        while(true) {
            int a = rand7();
            int b = rand7();
            int num = (a-1)*7 + b; // rand 49
            // 抛弃 41~49 的值
            if(num <= 40) {
                return num % 10 + 1;
            }

            // 到这里其实就可以了,下面的可以不用继续写了
            // 相当于把 41~49 的值抛弃掉然后重新开始一轮随机
            
            // 也可以继续随机, 提高 41~49 这 9 个数字的利用率,减少抛弃的比例
            a = num - 40; // rand 9
            b = rand7();
            num = (a-1)*7 + b; // rand 63
            if(num <= 60) return num % 10 + 1;
            
            a = num - 60; // rand 3
            b = rand7();
            num = (a-1)*7 + b; // rand 21
            if(num <= 20) return num % 10 + 1;
            // 到这里可以了,只剩下一个值被抛弃
        }
    }
}
// @lc code=end

