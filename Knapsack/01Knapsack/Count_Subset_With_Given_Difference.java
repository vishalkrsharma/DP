class Count_Subset_With_Given_Difference {

  public static int subsetDiff(int arr[], int n, int diff, int range) {

    int s1 = (range + diff) / 2;

    int dp[][] = new int[n + 1][s1 + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < s1 + 1; j++) {
        if (i == 0) {
          dp[i][j] = 0;
        }
        if (j == 0) {
          dp[i][j] = 1;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < s1 + 1; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][s1];
  }

  public static void main(String[] args) {
    int arr[] = { 1, 1, 2, 3 };
    int diff = 1;
    int n = arr.length;

    int sum = 0;
    for (int x : arr) {
      sum += x;
    }

    System.out.println(subsetDiff(arr, n, diff, sum));
  }
}