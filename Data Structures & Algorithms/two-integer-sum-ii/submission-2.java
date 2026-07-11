class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int[] ans = new int[2];
        int right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum > target){
                right--;
            }
            else if(sum < target){
                left++;
            }else{
                while(left < right && numbers[right - 1] == numbers[right]){
                    right--;
                }
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }
        }
        return ans;
    }
}
