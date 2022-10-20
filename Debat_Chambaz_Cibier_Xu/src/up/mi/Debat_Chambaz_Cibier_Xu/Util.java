package up.mi.Debat_Chambaz_Cibier_Xu;

public class Util {
  /**
   * Trims whitespace before and after a string
   * @param in The input string to trim
   * @return Trimed String
   */
  public static String trim(String in) {
    int start = 0, end = in.length() - 1;
    for (int i = start; i < in.length(); i++) {
      if (in.charAt(i) != ' ') {
        start = i;
        break;
      }
    }
    for (int i = end; i >= 0; i--) {
      if (in.charAt(i) != ' ') {
        end = i;
        break;
      }
    }
    return in.substring(start, end + 1);
  }

}
