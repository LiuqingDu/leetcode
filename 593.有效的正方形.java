/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 如果以正方形中心点为坐标原点，则正方形的任意顶点绕原点旋转 90° 后仍属于四个顶点之一。
        // 因此只需要检查每个点旋转 90° 后，是否还存在于四个点组成的集合中即可。
        // 而二维平面旋转 90° 很容易表示： (x,y) 逆时针旋转 90° 后为 (−y,x)

        // 计算中心点，缩放 4 倍避免除法
        // 本来中心应该是相加后除以四,这里不除了,相当于是距离原点变得更远了,远了 4 倍
        int cenX = p1[0] + p2[0] + p3[0] + p4[0];
        int cenY = p1[1] + p2[1] + p3[1] + p4[1];
        
        // 将中心点移动到坐标原点，并缩放到新坐标
        int[][] pts = {
            cenToOrigin(p1, cenX, cenY),
            cenToOrigin(p2, cenX, cenY),
            cenToOrigin(p3, cenX, cenY),
            cenToOrigin(p4, cenX, cenY)
        };

        // 使用 HashSet 存储点，直接以字符串表示点
        Set<String> pointSet = new HashSet<>();
        for (int[] pt : pts) {
            pointSet.add(pointToString(pt));
        }
        
        // 如果有重复点，肯定不是正方形
        if (pointSet.size() < 4) {
            return false;
        }

        // 检查每个点旋转 90° 是否在集合中
        for (int[] pt : pts) {
            int[] rotated = rotate90(pt);
            if (!pointSet.contains(pointToString(rotated))) {
                return false;
            }
        }

        return true;
    }
    
    // 计算点移动到以中心点为原点后的坐标，并缩放
    private int[] cenToOrigin(int[] p, int cenX, int cenY) {
        return new int[]{p[0] * 4 - cenX, p[1] * 4 - cenY};
    }

    // 逆时针旋转 90°
    private int[] rotate90(int[] p) {
        return new int[]{-p[1], p[0]};
    }

    // 将点表示为字符串，方便存入 HashSet
    private String pointToString(int[] p) {
        return p[0] + "," + p[1];
    }
}
// @lc code=end

