class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder("");
        int n = word1.length();
        int m = word2.length();
        int i = 0, j = 0;
        while(i < n || j < m){
            if(i < n)s.append(word1.charAt(i++));
            if(j < m)s.append(word2.charAt(j++));
        }

        return s.toString();

    }
}