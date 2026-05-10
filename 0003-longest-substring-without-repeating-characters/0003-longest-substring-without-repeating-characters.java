class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int maxlength=0;
        HashSet<Character>charset = new HashSet<>();
        for (int right=0;right<s.length();right++){
            while(charset.contains(s.charAt(right))){
                charset.remove(s.charAt(left));
                left++;
            }
            charset.add(s.charAt(right));
            maxlength = Math.max(maxlength ,right-left+1);
        }
        return maxlength;
    }
}