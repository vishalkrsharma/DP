public class Longest_Common_Substring {
  public static int lcs(String x, String y, int n, int m) {
    int dp[][] = new int[n + 1][m + 1];
    int ans = Integer.MIN_VALUE;

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
          ans = Math.max(ans, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String x = "abcde";
    String y = "abfce";

    System.out.println(lcs(x, y, x.length(), y.length()));
  }
}
