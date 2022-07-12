public class Rod_Cutting {

  public static int cutRod(int price[], int n) {
    int dp[] = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {

        if (i <= j) {
          dp[j] = Math.max(dp[j], dp[j - i] + price[i - 1]);
        }

      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
    int n = price.length;
    System.out.println(cutRod(price, n));
  }
}
