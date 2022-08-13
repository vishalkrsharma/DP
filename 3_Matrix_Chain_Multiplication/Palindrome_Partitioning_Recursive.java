public class Palindrome_Partitioning_Recursive {

  public static boolean isPalin(String s, int i, int j) {

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  public static int mcm(String s, int i, int j) {
    if (i > j) {
      return 0;
    }

    if (isPalin(s, i, j) == true) {
      return 0;
    }

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int t = mcm(s, i, k) + mcm(s, k + 1, j) + 1;

      min = Math.min(min, t);
    }

    return min;

  }

  public static void main(String[] args) {
    String s = "aacecae";
    int n = s.length();

    System.out.println(mcm(s, 0, n - 1));
  }
}
