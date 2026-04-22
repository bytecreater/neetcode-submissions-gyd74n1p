class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
        }

        if (min < 0){
            min = 0;
        }

        int i = 1;
        while(i <= set.size()){
            if(!set.contains(1)){
                return 1;
            }
            else if(!set.contains(min+i)){
                return min + i;
            }
            else{
                i++;
            }
        }
        return min+1+i;

    }
}