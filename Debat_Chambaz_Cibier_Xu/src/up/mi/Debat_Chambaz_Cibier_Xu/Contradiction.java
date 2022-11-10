package up.mi.Debat_Chambaz_Cibier_Xu;

public class Contradiction {

  private int contradicts;

  /**
   * Initializes a contradiction
   * @param contradicts Index of argument contradicted by  the contradiction
   */
  public Contradiction(int contradicts) {
    this.contradicts = contradicts;
  }

  /**
   * Returns index that contradiction contradicts
   */
  public int getContradicts() {
    return this.contradicts;
  }

  public void print() {
    System.out.print(this.contradicts);
  }

}
