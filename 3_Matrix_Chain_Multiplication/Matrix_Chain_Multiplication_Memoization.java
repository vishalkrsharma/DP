import java.util.Arrays;

public class Matrix_Chain_Multiplication_Memoization {

  static int dp[][] = new int[1001][1001];

  public static int mcm(int arr[], int i, int j) {
    if (i >= j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int t = mcm(arr, i, k) + mcm(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

      min = Math.min(min, t);
    }

    return dp[i][j] = min;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4 };
    int i = 1, j = arr.length - 1;

    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }

    System.out.println(mcm(arr, i, j));
  }
}
