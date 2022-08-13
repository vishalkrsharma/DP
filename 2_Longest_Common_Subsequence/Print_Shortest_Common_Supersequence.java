class Print_Shortest_Common_Supersequence {

  public static String printSupSeq(String x, String y, int n, int m) {
    int dp[][] = new int[n + 1][m + 1];
    String s = "";
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

    int i = n, j = m;

    while (i > 0 || j > 0) {
      if (x.charAt(i - 1) == y.charAt(j - 1)) {
        s = x.charAt(i - 1) + s;
        i--;
        j--;
      } else {
        if (dp[i][j - 1] > dp[i - 1][j]) {
          s = y.charAt(j - 1) + s;
          j--;
        } else {
          s = x.charAt(i - 1) + s;
          i--;
        }
      }
    }

    while (i > 0) {
      s = x.charAt(i - 1) + s;
    }

    while (j > 0) {
      s = y.charAt(j - 1) + s;
    }

    return s;
  }

  public static void main(String[] args) {
    String x = "abcdaf";
    String y = "acbcf";

    int n = x.length();
    int m = y.length();

    System.out.println(printSupSeq(x, y, n, m));
  }
}