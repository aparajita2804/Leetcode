class Solution {
  
    public boolean isInterleave(String s1, String s2, String s3) {
        return ((s1.length()+s2.length()==s3.length())&& solve(s1,s1.length(),s2,s2.length(),s3,new int[s1.length()+1][s2.length()+1]));
    }
    private boolean solve(String s1, int i, String s2, int j, String s3, int[][] dp) {
        int k = i+j;
        if (k == 0) {
         
            return true;
        }
        if (dp[i][j] != 0) {
            
            return dp[i][j] == 1;
        }
        boolean res = (i-1 >= 0 && s1.charAt(i-1) == s3.charAt(k-1) && solve(s1, i-1, s2, j, s3, dp)) ||
                      (j-1 >= 0 && s2.charAt(j-1) == s3.charAt(k-1) && solve(s1, i, s2, j-1, s3, dp));
        dp[i][j] = res ? 1: 2;
        return res;
    }
}
