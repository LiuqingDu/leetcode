/*
 * @lc app=leetcode.cn id=1700 lang=java
 *
 * [1700] 无法吃午餐的学生数量
 */

// @lc code=start
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // 学生可以一直循环,那么顶部的三明治最差也可以让所有学生都试着挑一下
        // 只要剩余学生中有一个喜欢吃顶部的,那么顶部的就一定可以被拿走
        // 直到顶部的三明治不再被任何一个学生喜欢为止,那么后续所有三明治无论什么款式都不会被拿走
        // 统计两种学生数量,依次匹配三明治顶部
        // 直到有一种学生数量为 0 为止

        int a = 0, b = 0;
        for (int stu : students) {
            if (stu == 0) {
                a++;
            } else {
                b++;
            }
        }

        for (int sand : sandwiches) {
            if (sand == 0) {
                a--;
                // 为 -1 说明当前三明治是不能被取走的,那么剩下的都不能被取走
                // 注意这里不能判断 == 0, 因为=0 只能表示当前最后一个恰好被取走
                // 但有可能剩下的三明治恰好全是另一种的,正好可以被剩下学生取完
                // 所以必须在当前三明治肯定不能被取走的时候再跳出
                if (a == -1) {
                    break;
                }
            } else {
                b--;
                if (b == -1) {
                    break;
                }
            }
        }
        return Math.max(a, b);

    }
}
// @lc code=end

