import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> min_que;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.min_que = new PriorityQueue<>();
        for (int i : nums) {
            min_que.add(i);
            if (min_que.size() > k) {
                min_que.poll();
            }
        }
    }
    
    public int add(int val) {
        min_que.add(val);
        if(min_que.size() > k) {
            min_que.poll();
        }
        return min_que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */