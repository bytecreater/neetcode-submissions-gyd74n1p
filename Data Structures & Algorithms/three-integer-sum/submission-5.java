class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1*nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                List<Integer> triplet = new ArrayList<>();
                if(nums[left] + nums[right] == target){
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplet.add(nums[i]);
                    result.add(triplet);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(nums[left] + nums[right]  > target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }
}
