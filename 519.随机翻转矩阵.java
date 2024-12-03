/*
 * @lc app=leetcode.cn id=519 lang=java
 *
 * [519] 随机翻转矩阵
 */

// @lc code=start
class Solution {

    // 把矩阵拉平形成 m*n 的直线
    // 在 [0, m*n) 区间内随机一个数作为结果
    // 如果这个数已经被选取过,那么可以从这个数往两边寻找一个最近的数作为结果
    // 但这样的随机概率并不平均
    // 上面的方法可以看作是在数组里选择一个数,当被选择的数比较多的时候
    // 未被选择的数就不连续了,被切成了多个数组
    // 如果能把这些数组连起来,只保留还未被选择的,那么就可以每次只从其中随机,并保持均等概率了
    // 当选取一个数字后,把整个数组的最右边那个数字移动过来填充这个位置
    // 然后把数组的长度-1,就可以形成连续的未选择数组了
    // 比如 [0,1,2,3], 每个数字表示在 m*n 的矩阵里对应编号的格子
    // 选择 1
    // 形成 [0,3,2]
    // 首先把编号 3 的格子复制到编号 1 的位置上,然后数组长度-1,相当于再把末尾的格子删除了
    // 可以初始化数组来做这件事
    // 同时我们也注意到,如果索引等于格子编号,那么我们可以不用记录,只需要记录不相等的
    // 比如 [ , , , ]
    // 选择编号 1
    // 形成 [ ,3, ]
    // 这样我们可以更简单地用 map 来记录那些不相等的

    int m, n, cnt;
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.cnt = m * n - 1;
    }
    
    public int[] flip() {
        // 随机一个数字
        // 可用的范围上限是 cnt
        // nextInt 不包括给定的数字, 所以这里要 +1, 使得生成范围上限是 cnt
        int x = random.nextInt(cnt + 1);
        // 获取索引对应的格子编号
        // map 里是不相等的格子,也就是被移动过的格子
        // 如果没有找到,说明这个位置是没有挪动过的,那么默认编号就是索引本身
        // 这个 ind 才是真正的随机结果
        // x 只是所有待选择的格子连接成一串后的索引位置,不表示每个格子的编号
        int ind = map.getOrDefault(x, x);
        // 取出最右边的那个格子,也就是索引为 cnt 的, 然后放到 x 这个位置上
        // 这个格子有可能是移动过来的格子,所以要从 map 里取
        // 如果没取到,说明不是移动过来的,那么默认就是索引
        map.put(x, map.getOrDefault(cnt, cnt));
        // 把最右边的格子去掉
        cnt--;
        return new int[]{ind / n, ind % n};
    }
    
    public void reset() {
        this.cnt = this.m * this.n - 1;
        map.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
// @lc code=end

