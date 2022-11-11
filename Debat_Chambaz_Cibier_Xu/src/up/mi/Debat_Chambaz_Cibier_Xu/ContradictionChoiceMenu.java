package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the contradiction choice menu
 */
public class ContradictionChoiceMenu extends ChoiceMenu {
  /**
   * Adds a contradiction
   */
  public void contradictionAdd(Arguments arguments) {
    int args[] = IO.ioGetArgs(this.scanner, "Entrer la liste des arguments (An Am)", arguments.getNumberArguments());
    try {
    	arguments.addContradiction(args[0], new Contradiction(args[1]));
    }catch (Exception e) {
        System.out.println(e.getMessage());
        return;
    }
    System.out.print(arguments);
  }
}
