public class Longest_Common_Palindromic_Subsquence {

  public static int subseq(String x, String y, int n, int m) {
    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][m];
  }

  public static String reverse(String s) {
    String ans = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      ans += s.charAt(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    String x = "agbcba";
    String y = reverse(x);

    int n = x.length();
    int m = y.length();
    System.out.println(subseq(x, y, n, m));
  }
}
