/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 窥视迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iter;
    Integer next;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        if (iter.hasNext()) {
			next = iter.next();
		}
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer ans = next;
        next = iter.hasNext() ? iter.next() : null;
	    return ans;
	}
	
	@Override
	public boolean hasNext() {
        return next != null;
	}
}
// @lc code=end

