class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0 , right = n-1; 
        int rightMax = 0 ,leftMax = 0;
        int water = 0;
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            
            if(leftMax > rightMax){
                water += rightMax - height[right];
                right--;
            }else{
                water += leftMax - height[left];
                left++;
            }
        }
        return water;
    }
}
