public class Egg_Dropping_Recursive {

  public static int mcm(int e, int f) {
    if (f == 0 || f == 1 || e == 1) {
      return f;
    }

    int min = Integer.MAX_VALUE;

    for (int k = 1; k <= f; k++) {
      int temp = 1 + Math.max(mcm(e - 1, k - 1), mcm(e, f - k));
      min = Math.min(min, temp);
    }

    return min;
  }

  public static void main(String[] args) {
    int e = 2;
    int f = 10;

    System.out.println(mcm(e, f));
  }
}
