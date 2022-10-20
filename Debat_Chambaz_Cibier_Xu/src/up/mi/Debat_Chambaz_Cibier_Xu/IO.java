package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

/**
 * Collection of io helper functions
 */
public class IO {
  /**
   * Queries io for an int
   * @param scanner Initialized scanner
   * @param prompt Message to display to io
   * @return An int
   */
  public static int ioGetInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt + ": ");
      String answerStr = scanner.nextLine();
      answerStr = Util.trim(answerStr);
      int answer;
      try {
        answer = Integer.parseInt(answerStr);
      } catch (Exception e) {
        System.out.println("Erreur, entrée invalide");
        continue;
      }
      return answer;
    }
  }

  /**
   * Queries io for a choice between a list
   * @param scanner Initialized scanner
   * @param prompt Message to display to io
   * @param choices Varargs of choices to display to io
   * @return An int between 0 and choices.length -1
   */
public static int ioGetChoice(Scanner scanner, String prompt, String ... choices) {
    while (true) {
      for (int i = 0; i < choices.length; i++) {
        System.out.println((i + 1) + ". " + choices[i]);
      }
      int choice = ioGetInt(scanner, prompt + " (1-" + choices.length + ")");
      if (choice >= 1 && choice <= choices.length) {
        return choice - 1;
      }
      System.out.println("Erreur, entrez un nombre entre 1 et " + choices.length);
    }
  }
}
