public class Knapsack_01_TopDown {

  public static int knapSack(int W, int wt[], int val[], int N) {
    int dp[][] = new int[N + 1][W + 1];

    for (int i = 0; i < N + 1; i++) {
      for (int j = 0; j < W + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (wt[i - 1] <= j) {
          dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[N][W];
  }

  public static void main(String[] args) {
    int val[] = { 60, 100, 120 };
    int wt[] = { 10, 20, 30 };

    int W = 50;
    int N = val.length;

    System.out.println(knapSack(W, wt, val, N));
  }
}
