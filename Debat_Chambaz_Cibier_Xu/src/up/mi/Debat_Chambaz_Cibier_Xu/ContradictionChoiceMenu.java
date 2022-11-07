package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the contradiction choice menu
 */
public class ContradictionChoiceMenu extends ChoiceMenu {
  /**
   * Adds a contradiction
   */
  public void contradictionAdd(int size) {
    int args[] = IO.ioGetArgs(this.scanner, "Entrer la liste des arguments (A{n1} A{n2})", size);
  }
}
