class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                List<Integer> ans = new ArrayList<>();
                int sum = nums[left] + nums[right];
                if(sum == -target){
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    ans.add(nums[i]);
                    res.add(ans);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(sum < -target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
