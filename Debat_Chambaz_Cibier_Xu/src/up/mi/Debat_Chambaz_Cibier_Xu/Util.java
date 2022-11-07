package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Collection of helper functions
 */
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

  /**
   * Parse an argument index
   * @param in The input string to be parse (format: A{N})
   * @return The parsed int
   */
  public static int parseArgIndex(String in) throws Exception {
    if (in.length() < 2) {
      throw new Exception("Invalid argument length");
    }
    if (in.charAt(0) != 'A') {
      throw new Exception("Invalid argument header");
    }
    int answer;
    try {
      answer = Integer.parseInt(in.substring(1));
    } catch (Exception e) {
      throw new Exception("Invalid argument, not a number");
    }
    return answer;
  }

  /**
   * Split argument around to array of string seperated by delimeter
   * @param in Input string
   * @param delimeter Delimeter to split around
   * @return A list of string - some can be null
   */
  public static String[] split(String in, char delimeter) {
    int count = 0;
    for (int i = 0; i < in.length(); i++) {
      if (in.charAt(i) == delimeter) {
        count++;
      }
    }
    String[] ret = new String[count + 1];
    count = 0;
    int start = 0;
    for (int i = 0; i <= in.length(); i++) {
      if (i == in.length() || in.charAt(i) == delimeter) {
        ret[count] = in.substring(start, i);
        start = i + 1;
        count++;
      }
    }
    return ret;
  }
}
