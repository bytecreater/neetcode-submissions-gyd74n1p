class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = 0;
        int low = 0;
        for(int high = 0; high < s.length(); high++){
            char c = s.charAt(high);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c) > 1){
                while(map.get(c) > 1){
                    map.put(s.charAt(low), map.getOrDefault(s.charAt(low), 0)-1);
                    low++;
                }
            }
            len = Math.max(len,high - low + 1);
        }
        return len;
    }
}
