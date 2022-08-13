import java.util.Arrays;

public class Palindrome_Partitioning_Memoization {

  static int dp[][] = new int[1001][1001];

  public static boolean isPalin(String s, int i, int j) {

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  public static int mcm(String s, int i, int j) {
    if (i > j) {
      return 0;
    }

    if (isPalin(s, i, j)) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE, left, right;

    for (int k = i; k < j; k++) {
      if (dp[i][k] != -1) {
        left = dp[i][k];
      } else {
        left = mcm(s, i, k);
      }

      if (dp[k + 1][j] != -1) {
        right = dp[k + 1][j];
      } else {
        right = mcm(s, k + 1, j);
      }

      int t = left + right + 1;

      min = Math.min(min, t);
    }

    return dp[i][j] = min;

  }

  public static void main(String[] args) {
    String s = "aacecae";
    int n = s.length();

    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }

    System.out.println(mcm(s, 0, n - 1));
  }
}
