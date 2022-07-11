class Minimum_Subset_Sum_Difference {

  public static int subsetSumDiff(int arr[], int n, int range) {
    boolean dp[][] = new boolean[n + 1][range + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < range + 1; j++) {
        if (i == 0) {
          dp[i][j] = false;
        }
        if (j == 0) {
          dp[i][j] = true;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < range + 1; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
        } else
          dp[i][j] = dp[i - 1][j];
      }
    }

    int diff = Integer.MAX_VALUE;

    for (int j = range / 2; j >= 0; j--) {
      if (dp[n][j] == true) {
        diff = range - 2 * j;
        break;
      }
    }

    return diff;

  }

  public static void main(String[] args) {
    int arr[] = { 20, 19, 18, 20, 16 };
    int n = arr.length;
    int sum = 0;

    for (int x : arr) {
      sum += x;
    }
    System.out.println(subsetSumDiff(arr, n, sum));
  }
}