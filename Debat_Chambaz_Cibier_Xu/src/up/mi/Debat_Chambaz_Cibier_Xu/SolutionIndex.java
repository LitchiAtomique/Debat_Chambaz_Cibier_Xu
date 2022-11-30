package up.mi.Debat_Chambaz_Cibier_Xu;

public class SolutionIndex {
  private int index;

  public SolutionIndex() {
    this.index = -1;
  }

  public void increment() {
    this.index++;
  }

  public void loop(int n) {
    this.index %= n;
  }

  public int getIndex() {
    return this.index;
  }
}
