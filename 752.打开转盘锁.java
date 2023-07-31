/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start

import java.util.Set;

class Solution {

    // 本质是BFS的树，找最短路径
    // 从初始状态开始，总共有8种拨法，就是root有8个子节点，
    // 如果这8个节点命中了结果，则结果为1次，也就是最短路径1这个值
    // 如果没有命中，则它们分别又还有8种拨法（当然其中包含有已经处理过的方案）
    // 形成了8子节点的树，每下一层就是拨一次数字，本质是找目标数字的最短的层数
    // 由于有deadends存在，当创建子节点的时候要排除掉这些deadends，
    // 同时创建一个visited维护已经走过的路，避免创建重复的节点，
    // 这两个限制条件导致树不会一直都是8个子节点，最终会有尽头
    // 如果所有方案都遍历完了都没有能走到目标数字则返回-1
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<String>();
        for (String s : deadends) {
            dead.add(s);
        }
        Set<String> visited = new HashSet<String>();
        // 队列用于按层遍历
        Queue<String> queue = new LinkedList<String>();
        int res = 0;

        queue.offer("0000");
        visited.add("0000");

        while(!queue.isEmpty()) {
            // 一层一层遍历
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String s = queue.poll();
                // 如果是deadends里的则跳过，继续下一个
                // 这个判断必须要，因为有个测试用例把0000放到deadends里了，有可能一开始就不符合要求
                // 同时因为这里检查deadends了，那么下面 up 和 down 那里只需要检查visited就可以
                if (dead.contains(s)) {
                    continue;
                }
                if (target.equals(s)) {
                    return res;
                }

                // 依次把四位数字拨上拨下
                for (int j = 0; j < 4; j++) {
                    String up = up(s, j);
                    // 因为下一轮遍历的时候会检查deadends，所以这里可以不检查
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = down(s, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 这一层处理完了，层数+1，也就是步数+1
            res++;
        }
        return -1;

    }

    // 把第n个数字往上拨，返回新的数字
    private String up(String s, int n) {
        char[] c = s.toCharArray();
        if (c[n] == '9') {
            c[n] = '0';
        } else {
            c[n] += 1;
        }
        // 注意 char[] 转字符串应当是 new String()
        // 而不是 char[].toString(); 后者是把指针转为包含hashdode的字符串，类似 [C@0000]
        return new String(c);
    }

    // 把第n个数字往下拨，返回新的数字
    private String down(String s, int n) {
        char[] c = s.toCharArray();
        if (c[n] == '0') {
            c[n] = '9';
        } else {
            c[n] -= 1;
        }
        return new String(c);
    }
}
// @lc code=end

