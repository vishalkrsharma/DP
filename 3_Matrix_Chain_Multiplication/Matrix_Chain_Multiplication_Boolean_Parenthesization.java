public class Matrix_Chain_Multiplication_Boolean_Parenthesization {

  public static int mcm(String s, int i, int j, boolean isTrue) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue) {
        return s.charAt(i) == 'T' ? 1 : 0;
      } else {
        return s.charAt(i) == 'F' ? 1 : 0;
      }
    }

    int ans = 0;

    for (int k = i + 1; k < j; k++) {
      int leftTrue = mcm(s, i, k - 1, true);
      int leftFalse = mcm(s, i, k - 1, false);
      int rightTrue = mcm(s, k + 1, j, true);
      int rightFalse = mcm(s, k + 1, j, false);

      if (s.charAt(k) == '^') {
        if (isTrue) {
          ans += leftTrue * rightFalse + leftFalse * rightTrue;
        } else {
          ans += leftTrue * rightTrue + leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '&') {
        if (isTrue) {
          ans += leftTrue + rightTrue;
        } else {
          ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue) {
          ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
        } else {
          ans += leftTrue + rightTrue;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String s = "T|T&F^T";
    int n = s.length();

    System.out.println(mcm(s, 0, n - 1, true));
  }
}