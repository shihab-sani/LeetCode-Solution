import java.util.Comparator;
import java.util.PriorityQueue;

class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int[][] res = new int[k][2];

        for (int[] i : points) {
            int dist = (i[0] * i[0]) + (i[1] * i[1]);
            heap.add(new int[]{dist, i[0], i[1]});
        }

        for (int j = 0; j < k; j++) {
            int[] point = heap.poll();
            res[j] = new int[]{point[1], point[2]}; 
        }

        return res;
    }
}