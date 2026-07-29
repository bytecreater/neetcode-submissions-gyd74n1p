class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++){
            if(i == k - 1){
                return pq.peek();
            }
        }
        return 0;
    }
}
