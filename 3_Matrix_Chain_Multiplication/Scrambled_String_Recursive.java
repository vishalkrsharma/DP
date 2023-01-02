public class Scrambled_String_Recursive {

  public static boolean mcm(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    if (a.length() == 0 && b.length() == 0) {
      return false;
    }

    if (a.compareTo(b) == 0) {
      return true;
    }

    if (a.length() <= 1) {
      return false;
    }

    int n = a.length();
    boolean flag = false;

    for (int i = 1; i < n; i++) {
      if (mcm(a.substring(0, i), b.substring(0, i)) && mcm(a.substring(i, n), b.substring(i, n))) {
        flag = true;
        break;
      }
      if (mcm(a.substring(0, i), b.substring(n - i, n)) && mcm(a.substring(i, n), b.substring(0, n - i))) {
        flag = true;
        break;
      }
    }
    return flag;
  }

  public static void main(String[] args) {
    String a = "abbbcbaaccacaacc";
    String b = "acaaaccabcabcbcb";

    System.out.println(mcm(a, b));
  }
}