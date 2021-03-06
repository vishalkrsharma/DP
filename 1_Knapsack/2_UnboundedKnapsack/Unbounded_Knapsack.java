class Unbounded_Knapsack {

  public static int unboundedKnapsack(int W, int n, int val[], int wt[]) {
    int dp[][] = new int[n + 1][W + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < W + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (wt[i - 1] <= j) {
          dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][W];

  }

  public static void main(String[] args) {
    int W = 100;
    int val[] = { 10, 30, 20 };
    int wt[] = { 5, 10, 15 };
    int n = val.length;
    System.out.println(unboundedKnapsack(W, n, val, wt));
  }
}
