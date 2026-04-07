class Solution {
    // public String makeSmallestPalindrome(String s) {
    //     // if the two position elemnt are not same then change the samllest character of them/
    //     // g and f f is the smallest character by lexographically then chanege the g by f
    //     // and perfrom operation again and aagian
    //    String result = makeSmallestPalindrome(s);
    //    return result;
    // }
  public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();

        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            char left = sb.charAt(i);
            char right = sb.charAt(j);
            if (left != right) {
                char smaller = left < right ? left : right;
                sb.setCharAt(i, smaller);
                sb.setCharAt(j, smaller);
            }
        }

        return sb.toString();
    }
}