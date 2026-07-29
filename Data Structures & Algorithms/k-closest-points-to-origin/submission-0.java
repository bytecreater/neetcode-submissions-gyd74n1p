class Solution {
    class Pair {
        double dist;
        int[] point = new int[2];

        Pair(double dist , int[] point){
            this.dist = dist;
            this.point = point;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        for(int i = 0; i < points.length; i++){
            double dist = Math.sqrt((points[i][0]*points[i][0]) + (points[i][1]*points[i][1]));
            pq.offer(new Pair(dist , points[i]));
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++){
            ans[i] = pq.peek().point;
            pq.poll();
        }
        return ans;
    }
}
