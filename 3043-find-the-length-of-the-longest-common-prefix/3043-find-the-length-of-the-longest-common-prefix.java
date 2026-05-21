class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
         HashSet<String>set = new HashSet<>();
         // add all prefix of arr1 in hashset
         for(int num :arr1){
            String s = String.valueOf(num);
            for(int i=1;i<=s.length();i++){
                set.add(s.substring(0,i));
            }
         }
         int ans =0;
         // compare if num prefix present on arr1 then returnn ans
         for(int num :arr2){
            String s = String.valueOf(num);
            for(int i=1;i<=s.length();i++){
                String prefix = s.substring(0,i);
                if(set.contains(prefix)){
                    ans = Math.max(ans,i);
                }

            }
         }
         return ans;
    }
}