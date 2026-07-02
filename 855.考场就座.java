/*
 * @lc app=leetcode.cn id=855 lang=java
 *
 * [855] 考场就座
 */

// @lc code=start
class ExamRoom {
    private int n;
    private TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
    }
    
    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int maxDist = 0;
        int studentSeat = 0;

        // 1. 考虑最左边 0 号座位到第一个有人座位之间的距离
        int first = seats.first();
        if (first > 0) {
            maxDist = first;
            studentSeat = 0;
        }

        // 2. 遍历所有相邻的座位，寻找中间可以获得最大距离的位置
        int prev = -1;
        for (int seat : seats) {
            if (prev != -1) {
                int dist = (seat - prev) / 2;
                // 如果发现更大的距离，更新位置
                // 注意题目要求：距离相同时取编号最小的座位，这里用 > 而不是 >= 自动保证了取小编号
                if (dist > maxDist) {
                    maxDist = dist;
                    studentSeat = prev + dist;
                }
            }
            prev = seat;
        }

        // 3. 考虑最后一个有人座位到最右边 n-1 号座位之间的距离
        int last = seats.last();
        if (n - 1 - last > maxDist) {
            studentSeat = n - 1;
        }

        seats.add(studentSeat);
        return studentSeat;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
// @lc code=end

