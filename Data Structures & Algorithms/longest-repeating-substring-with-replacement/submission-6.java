class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        int maxfreq = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxfreq = Math.max(maxfreq , map.get(c));

            while((right - left + 1 - maxfreq) > k){
                char ch = s.charAt(left);
                map.put(ch, map.get(ch)-1);
                left++;
            }
            ans = Math.max(ans , right - left + 1);
        }
        return ans;
    }
}
