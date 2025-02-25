/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
class MyCalendar {

    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (endTime > l && startTime < r) {
                return false;
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
// @lc code=end

