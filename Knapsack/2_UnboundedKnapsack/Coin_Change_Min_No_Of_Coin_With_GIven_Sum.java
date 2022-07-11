public class Coin_Change_Min_No_Of_Coin_With_GIven_Sum {

  public static int minCoins(int coin[], int n, int sum) {
    int dp[][] = new int[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          dp[i][j] = Integer.MAX_VALUE - 1;
        }
        if (j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1, j = 1; j < sum + 1; j++) {
      if (j % coin[0] == 0) {
        dp[i][j] = j / coin[0];
      } else {
        dp[i][j] = Integer.MAX_VALUE - 1;
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coin[i - 1] <= j) {
          dp[i][j] = Math.min(dp[i][j - coin[i - 1]] + 1, dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
  }

  public static void main(String[] args) {
    int coin[] = { 15, 1 };
    int n = coin.length;
    int sum = 4;
    System.out.println(minCoins(coin, n, sum));
  }
}
