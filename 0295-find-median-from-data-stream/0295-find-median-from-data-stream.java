
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class MedianFinder {

    Queue<Integer> minPq = new PriorityQueue<>();
    Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {

        // Insertion starategy
        if (maxPq.isEmpty() || num <= maxPq.peek()) {
            maxPq.add(num);
        } else {
            minPq.add(num);
        }

        // element transfer strategy
        if (maxPq.size() > minPq.size() + 1) {
            minPq.add(maxPq.poll());
        }

        if (minPq.size() > maxPq.size()) {
            maxPq.add(minPq.poll());
        }

    }

    public double findMedian() {

        //Meadian Finder Strategy
        if (maxPq.size() == minPq.size()) {
            return (double) (maxPq.peek() + minPq.peek()) / 2;
        }
        return (double) maxPq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */