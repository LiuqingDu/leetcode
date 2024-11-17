/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组是否存在循环
 */

// @lc code=start
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // 快慢指针
        // 需要从每一个点出发，进行一轮快慢指针
        // 注意题目中要求不能倒车，也就是环必须是同一个方向，
        // 环里的数字必须都为正数或者都为负数
        // 如果遇到了符号变更，说明当前路径不符合题目，
        // 需要把当前路径走过的点都标记下来，避免重复
        // 此题中因为不会出现 0，所以可以标记为 0，表示已经访问过，无需再次访问
        
        int n = nums.length;
        
        // 遍历每个位置作为起点
        for (int i = 0; i < n; i++) {
            // 已访问过的点跳过
            if (nums[i] == 0) {
                continue;
            }
            
            // 快慢指针
            int slow = i, fast = i;
            
            // 检查方向是否一致并移动指针
            while (true) {
                // 移动慢指针一步
                slow = getNextPos(nums, slow);
                if (slow == -1) {
                    break;
                }
                
                // 移动快指针两步
                fast = getNextPos(nums, fast);
                if (fast == -1) {
                    break;
                }
                fast = getNextPos(nums, fast);
                if (fast == -1) {
                    break;
                }
                
                // 找到循环
                if (slow == fast) {
                    // 检查循环长度是否为1
                    if (slow == getNextPos(nums, slow)) {
                        break;
                    }
                    return true;
                }
            }
            
            // 标记已访问路径
            int curr = i;
            while (curr != -1) {
                int next = getNextPos(nums, curr);
                nums[curr] = 0;
                curr = next;
            }
        }
        return false;
    }
    
    // 获取下一个位置，同时检查方向
    private int getNextPos(int[] nums, int curr) {
        int n = nums.length;
        int currDir = nums[curr] > 0 ? 1 : -1;
        // +n 是避免后退出现负数，后面再次 %n 是避免原本是正数，加上 n 之后超出范围
        int next = ((curr + nums[curr]) % n + n) % n;
        
        // 检查方向是否改变或已访问
        if (nums[next] == 0 || (nums[next] > 0 ? 1 : -1) != currDir) {
            return -1;
        }
        return next;
    }
}
// @lc code=end

