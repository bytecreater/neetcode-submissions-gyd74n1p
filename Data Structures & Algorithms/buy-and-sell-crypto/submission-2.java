class Solution {
    public int maxProfit(int[] nums) {
        int left = 0;
        int right = 1;
        int profit = 0;
        while(right < nums.length){
            if(nums[left] < nums[right]){
                int maxp  =  nums[right] - nums[left];
                profit = Math.max(profit,maxp);
            }else{
                left = right;
            }
            right++;
        }
        return profit;
    }
}