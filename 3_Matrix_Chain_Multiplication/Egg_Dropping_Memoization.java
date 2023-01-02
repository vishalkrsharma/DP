import java.util.Arrays;

public class Egg_Dropping_Memoization {

  static int dp[][] = new int[201][201];

  public static int mcm(int e, int f) {
    if (f == 0 || f == 1 || e == 1) {
      return f;
    }

    if (dp[e][f] != -1) {
      return dp[e][f];
    }

    int min = Integer.MAX_VALUE, low, high;

    for (int k = 1; k <= f; k++) {
      if (dp[e - 1][k - 1] != -1) {
        low = dp[e - 1][k - 1];
      } else {
        low = mcm(e - 1, k - 1);
      }
      if (dp[e][f - k] != -1) {
        high = dp[e][f - k];
      } else {
        high = mcm(e, f - k);
      }
      int temp = 1 + Math.max(low, high);
      min = Math.min(min, temp);
    }

    return dp[e][f] = min;
  }

  public static void main(String[] args) {
    int e = 2;
    int f = 10;

    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }

    System.out.println(mcm(e, f));
  }
}
