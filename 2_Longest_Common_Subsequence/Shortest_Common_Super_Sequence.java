public class Shortest_Common_Super_Sequence {
  public static int superSequence(String x, String y, int n, int m) {
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
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return n + m - dp[n][m];
  }

  public static void main(String[] args) {
    String x = "abcd";
    String y = "xycd";

    int n = x.length();
    int m = y.length();

    System.out.println(superSequence(x, y, n, m));
  }
}
