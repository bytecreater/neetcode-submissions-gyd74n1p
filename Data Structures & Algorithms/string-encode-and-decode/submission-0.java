class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for(String s : strs){
            encoded_string.append(s.length()).append("#").append(s);
        }
        return encoded_string.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded_string = new ArrayList<>();
        int i = 0;
         while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j+1,j+1+len);
            decoded_string.add(word);

            i = j+1+len;
         }
        return decoded_string;
    }
}
