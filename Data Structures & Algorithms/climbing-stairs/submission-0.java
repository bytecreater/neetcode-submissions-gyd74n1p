class Solution {
    HashMap<Integer,Integer> dp = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n > n || n < 0){
            return 0;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int ans = climbStairs(n - 1) + climbStairs(n-2);
        dp.put(n , ans);
        return ans;
    }
}
