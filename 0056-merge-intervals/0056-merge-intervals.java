/*
Appproach: Sorting + 2 Pointer (Like a greedy)
    1. merge if elements are overlapping 
    2. compare current[end] with next[start] => if overlapping 
    3. merge like { current[start], next[end]}
    4. if elements are not overlapping then keep as it is.

TC: O(N)
SC: 0(1)   
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        int [] currentIntervals = intervals[0];
        list.add(currentIntervals);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentIntervals[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                currentIntervals[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentIntervals = intervals[i];
                list.add(currentIntervals);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}