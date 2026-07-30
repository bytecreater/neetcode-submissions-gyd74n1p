class Solution {
    class Pair {
        int capital;
        int profit;
        Pair(int capital,int profit){
            this.profit = profit;
            this.capital = capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        int n = profits.length;
        Pair[] list = new Pair[n];
        for(int i = 0; i < n; i++){
            list[i] = new Pair(capital[i],profits[i]);
        }
        Arrays.sort(list,(a,b) -> a.capital - b.capital);
        int count = 0;
        while(k > 0){
            for(int i = count; i < n; i++){
                if(list[i].capital > w){
                    break;
                }else{
                    pq.offer(list[i]);
                    count++;
                }
            }
            if(!pq.isEmpty()){
                w = w + pq.peek().profit;
                pq.poll();
            }
            k--;
        }
        return w == 0 ? 0 : w;
    }
}