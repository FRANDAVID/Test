package leetcode;

import java.util.Arrays;
import java.util.Stack;

/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
/*
 * We traverse all bars from left to right, maintain a 栈的几种实现 of bars. Every bar is pushed to 栈的几种实现 once.
 * A bar is popped from 栈的几种实现 when a bar of smaller height is seen
 * When a bar is popped, we calculate the area with the popped bar as smallest bar. 
 * How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’
 * and index of previous item in 栈的几种实现 is the ‘left index’.
 * Following is the complete algorithm.
 * 1) Create an empty 栈的几种实现.
 * 2) Start from first bar, and do following for every bar ‘hist[i]‘ where ‘i’ varies from 0 to n-1.
 *   a) If 栈的几种实现 is empty or hist[i] is higher than the bar at top of 栈的几种实现, then push ‘i’ to 栈的几种实现.
 *   b) If this bar is smaller than the top of 栈的几种实现, then keep removing the top of 栈的几种实现 while top of the 栈的几种实现 is greater.
 *      Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar.
 *      For hist[tp], the ‘left index’ is previous (previous to tp) item in 栈的几种实现 and ‘right index’ is ‘i’ (current index).
 * 3) If the 栈的几种实现 is not empty, then one by one remove all bars from 栈的几种实现 and do step 2.b for every removed bar.


 */
public class LargestRectangleinHistogram3 {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
		int[] h = Arrays.copyOf(height, height.length + 1);
		h[h.length - 1] = 0;
		int maxArea = 0;
		int i = 0;
		while (i < h.length) {
			if (s.empty() || h[i] > h[s.peek()])
				s.push(i++);
			else {
				int tmp = s.pop();
				maxArea = Math.max(maxArea, h[tmp] * (s.empty() ? i : i - s.peek() - 1));
			}
		}
		return maxArea;
	}
}
