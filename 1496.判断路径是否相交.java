/*
 * @lc app=leetcode.cn id=1496 lang=java
 *
 * [1496] 判断路径是否相交
 */

// @lc code=start

class Solution {
    public boolean isPathCrossing(String path) {
        // 最多有 10000 个点,那么 x 和 y 可取范围都是 [-10000,10000]
        // 可以把 x 和 y 拼接在一起, 然后用 set 来找是否有重复的
        // 注意 x 和 y 拼接的时候要给 y 留够空位, 不能直接拼接.
        // 这里是 x 右边留 5 位给 y
        // 比如 x=1 y=1 不能拼接成 11
        Set<Integer> set = new HashSet<Integer>();
        int x = 0, y = 0;
        set.add(getHash(x, y));

        char[] cs = path.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case 'N':
                    x--;
                    break;
                case 'S':
                    x++;
                    break;
                case 'W':
                    y--;
                    break;
                case 'E':
                    y++;
                    break;
            }
            int hashValue = getHash(x, y);
            if (set.contains(hashValue)) {
                return true;
            }
            set.add(hashValue);
        }
        return false;
    }

    private int getHash(int x, int y) {
        return x * 10000 + y;
    }
}
// @lc code=end

