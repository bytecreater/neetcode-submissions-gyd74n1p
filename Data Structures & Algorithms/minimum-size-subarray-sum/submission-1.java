class Solution {
    public int minSubArrayLen(int target, int[] arr){
        int min =  Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while(right < arr.length){
            sum = sum + arr[right];
            while(sum >= target){
                min = Math.min(min,right - left + 1);
                sum = sum - arr[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}