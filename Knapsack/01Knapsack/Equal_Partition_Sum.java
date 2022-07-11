public class Equal_Partition_Sum {

  public static boolean partitionSum(int arr[], int n) {
    int sum = 0;
    for (int x : arr) {
      sum += x;
    }

    if (sum % 2 != 0) {
      return false;
    }

    sum /= 2;
    boolean dp[][] = new boolean[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          dp[i][j] = false;
        }
        if (j == 0) {
          dp[i][j] = true;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][sum];
  }

  public static void main(String[] args) {
    int arr[] = { 3, 1, 5, 9, 12 };
    int n = arr.length;

    System.out.println(partitionSum(arr, n));
  }
}
