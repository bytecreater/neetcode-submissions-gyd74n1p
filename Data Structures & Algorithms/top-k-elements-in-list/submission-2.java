class Solution {
    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        for(int num : map.keySet()){
            pq.offer(new Pair(num,map.get(num)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++){
            ans[i] = pq.peek().num;
            pq.poll();
        }
        return ans;
        
    }
}
