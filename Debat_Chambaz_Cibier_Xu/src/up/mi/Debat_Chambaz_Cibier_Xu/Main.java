package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberArguments = IO.ioGetInt(
        scanner,
        "Entrer le nombre d'argument");
    System.out.println("Number arguments: " + numberArguments);

    boolean firstMenu = true;
    while (firstMenu) {
      int firstMenuChoice = IO.ioGetChoice(
          scanner,
          "Sélectionner choix",
          "Ajouter une contradiction",
          "Fin");

      switch (firstMenuChoice) {
        case 0:
          System.out.println("Ajout de contradiction");
          break;
        case 1:
          firstMenu = false;
          break;
      }
    }
	}
}
