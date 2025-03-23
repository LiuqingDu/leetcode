/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start
class Solution {
    public String destCity(List<List<String>> paths) {
        // 比较容易想到的方法是循环两次,第一次把每个线路的起点放入 set 中
        // 第二次循环查看线路的终点是否在 set 中,不存在则说明该站点只到达不出发

        // 另一种只循环一次的方法
        // 需要再用一个 set b 来表示目前有可能成为最终答案的站点
        // 对于一个站点 [ai,bi], ai 肯定不是最终答案,则把它从 set b 删除
        // 并且把 ai 记入 set a
        // 同时如果 bi 不在 set a 当中,说明到目前为止, bi 还不是出发站,它有可能是最终答案
        // 把 bi 加入 set b
        // 一次遍历结束后,所有一开始满足但最终不满足的站点都会从 set b 删除
        // 所有一开始就不满足的站点不会加入 set b
        // 最终 set b 只有一个答案

        Set<String> setA = new HashSet<>(paths.size());
        Set<String> setB = new HashSet<>();

        for (List<String> p : paths) {
            String a = p.get(0);
            String b = p.get(1);
            setB.remove(a); // a 一定不是答案
            if (!setA.contains(b)) { // b 有可能是答案
                setB.add(b);
            }
            setA.add(a);
        }
        return setB.iterator().next();
    }
}
// @lc code=end

