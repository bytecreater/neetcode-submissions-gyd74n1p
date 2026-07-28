class Solution {
    public boolean helper(int[] weights,int n, int mid,int days){
        int load = 0;
        int day = 0;
        for(int i = 0; i < n; i++){
            if(load + weights[i] <= mid){
                load = load + weights[i];
            }else{
                day++;
                load = weights[i];
                if(day >= days){
                    return false;
                }
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = 0;
        int res = -1;
        for(int weight : weights){
            low = Math.max(low,weight);
            high += weight;
        }
        while(low <= high){
            int mid = (low + high) / 2;
            if(helper(weights,n,mid,days)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
}