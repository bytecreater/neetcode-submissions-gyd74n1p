class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int T0 = 0;
        int T1 = 1;
        int T2 = 1;
        if(map.containsKey(n)){
            return map.get(n);
        }
        int ans = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        map.put(n, ans);

        return ans;
    }
}