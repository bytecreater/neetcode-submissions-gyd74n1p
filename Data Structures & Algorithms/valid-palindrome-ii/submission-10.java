class Solution {
    public boolean checkPalindrome(String s, int left,int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return checkPalindrome(s,left,right-1) || checkPalindrome(s,left+1,right);
            }
            left++;
            right--;
        }
        return true;
    }
}