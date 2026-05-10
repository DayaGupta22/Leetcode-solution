class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,r =0,maxlen =0,len=0;
        int n = s.length();
        HashMap<Character,Integer> hash = new HashMap<>();
        while (r<n){
            char ch = s.charAt(r);
            if(hash.containsKey(ch)) {
                if(hash.get(ch) >= left){
                    left = hash.get(ch) +1;
                }
            }
            
            len= r -left+1;
            maxlen = Math.max(len,maxlen);
            hash.put(s.charAt(r),r);
            r ++;
        }
        return maxlen;

    }
}