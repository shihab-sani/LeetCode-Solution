import java.util.PriorityQueue;

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : stones) {
            heap.add(-s);
        }

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            if (second > first) {
                heap.add(first - second);
            }
        }
        heap.add(0);
        return Math.abs(heap.peek());
    }
}