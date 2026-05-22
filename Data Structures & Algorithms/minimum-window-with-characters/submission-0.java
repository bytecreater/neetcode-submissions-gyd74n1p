class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        int[] freq = new int[128];

        // store frequency of characters of t
        for(char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // useful character found
            if(freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            // valid window found
            while(count == 0) {

                // update minimum window
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                // window becomes invalid
                if(freq[leftChar] > 0) {
                    count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}