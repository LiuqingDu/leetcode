/*
 * @lc app=leetcode.cn id=939 lang=java
 *
 * [939] 最小面积矩形
 */

// @lc code=start
class Solution {
    public int minAreaRect(int[][] points) {
        // 将这些点按照 x 轴（即列）排序，那么对于同一列的两个点 (x, y1) 和 (x, y2)，
        // 找出它作为右边界的最小的矩形。这
        // 可以通过记录下我们之前遇到的所有 (y1, y2) 点对来做到
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        List<Integer> xList = new ArrayList<>(map.keySet());
        Collections.sort(xList);

        for (int i = 0; i < xList.size(); i++) {
            for (int j = i + 1; j < xList.size(); j++) {
                int x1 = xList.get(i);
                int x2 = xList.get(j);
                Set<Integer> ySet1 = map.get(x1);
                Set<Integer> ySet2 = map.get(x2);

                // 找到两个列中共有的 y 值
                List<Integer> commonY = new ArrayList<>();
                for (int y : ySet1) {
                    if (ySet2.contains(y)) {
                        commonY.add(y);
                    }
                }

                // 如果有两个以上的 y 值，则可以形成矩形
                if (commonY.size() >= 2) {
                    for (int k = 0; k < commonY.size(); k++) {
                        for (int l = k + 1; l < commonY.size(); l++) {
                            int y1 = commonY.get(k);
                            int y2 = commonY.get(l);
                            int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
// @lc code=end

