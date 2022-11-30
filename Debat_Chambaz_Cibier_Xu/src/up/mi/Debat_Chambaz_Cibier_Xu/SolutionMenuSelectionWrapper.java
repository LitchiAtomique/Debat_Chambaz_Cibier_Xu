package up.mi.Debat_Chambaz_Cibier_Xu;

public class SolutionMenuSelectionWrapper {

  private SolutionMenuSelection solutionMenuSelection;

  public SolutionMenuSelectionWrapper() {
    this.solutionMenuSelection = SolutionMenuSelection.DEFAULT_MENU;
  }

  public SolutionMenuSelection getSolutionMenuSelection() {
    return this.solutionMenuSelection;
  }

  public void setSolutionMenuSelection(SolutionMenuSelection solutionMenuSelection) {
    // cant set to default menu
    if (solutionMenuSelection == SolutionMenuSelection.DEFAULT_MENU) {
      return;
    }
    this.solutionMenuSelection = solutionMenuSelection;
  }
}
