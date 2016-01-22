import java.util.*;
public class MedianFinder {
    PriorityQueue<Integer> minque = new PriorityQueue();
    PriorityQueue<Integer> maxque = new PriorityQueue(10,Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minque.isEmpty()) minque.offer(num);
        else if(num > minque.peek()){
            minque.offer(num);
        }
        else maxque.offer(num);
        while(minque.size() - maxque.size() > 1)
            maxque.offer(minque.poll());
        while(maxque.size() - minque.size() > 1)
            minque.offer(maxque.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
		System.out.println(minque);
		System.out.println(maxque);
        if(minque.size() == maxque.size())
            return (double)((double)((double)minque.peek() + (double)maxque.peek()) / 2);
        else return minque.size() > maxque.size() ? minque.peek() : maxque.peek();
    }
	public static void main(String args[]){
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();