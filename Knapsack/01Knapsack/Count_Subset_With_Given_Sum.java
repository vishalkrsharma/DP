class Count_Subset_With_Given_Sum {

  public static int subsetSum(int arr[], int n, int sum) {
    int dp[][] = new int[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          dp[i][j] = 0;
        }
        if (j == 0) {
          dp[i][j] = 1;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][sum];
  }

  public static void main(String[] args) {
    int n = 4;
    int a[] = { 3, 3, 3, 3 };
    int sum = 6;

    System.out.println(subsetSum(a, n, sum));
  }
}