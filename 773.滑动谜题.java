/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @lc code=start
class Solution {
    // 看得出来是需要暴力求解，对于当前状况，我们可以进行的下一步操作实际上是
    // 把0跟它相邻的数字交换位置，这样可以形成一棵树，子树就是跟不同的数字交换的情况
    // 这道题就转变为求目标状态在树里的最浅的深度
    // 求深度就是求树的最小高度，那么就用BFS一行一行找，第n行就是走n步的状态，
    // 第一次找到目标状态时的n就是结果
    // 题目已经给出了是2x3的板子，那么对于每一个格子，可以与它交换的格子是已知的
    // 可以把这个对应关系提前写好，方便调用
    // 记录板子坐标为 [0, 1, 2]
    //               [3, 4, 5]
    // 格子0的邻居是1和3，依此类推
    // 至于板子上棋子的状态，可以使用字符串来表示，方便操作，这样才能使用Set存储
    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";

        // 把板子初始状态存储为string
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // 初始化每个格子的邻居，邻居表示这个格子可以和邻居交换位置
        int[][] neighbor = new int[][] {
            {1, 3},
            {0, 4, 2},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
        };

        // BFS
        // 队列里放每一行的节点
        Queue<String> queue = new LinkedList<String>();
        // Set记录已经遍历过的节点，防止重复计算
        HashSet<String> visited = new HashSet<String>();
        queue.offer(start);
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // 如果找到目标状态，返回深度
                if (target.equals(current)) {
                    return step;
                }
                // 查找字符0的位置
                int ind = 0;
                while (current.charAt(ind) != '0') {
                    ind++;
                }
                // 依次尝试把这个0跟它的邻居交换位置，并把交换后的状况放到队列里
                for (int nei: neighbor[ind]) {
                    String newBoard = swap(current, nei, ind);
                    // 如果新的状况没有遍历过则加入队列
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            // 一行节点遍历完了，层数加一
            step++;
        }

        // 所有节点都遍历完了，也没有找到目标状态，那么就是不可达
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
// @lc code=end

