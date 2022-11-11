package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.ArrayList;

/**
 * An argument is a logical argument and the list of all arguments
 * that it contradicts
 * It represents a single index of an adjency list
 */
public class Argument {
  int id;
  private ArrayList<Contradiction> contradictions;

  /**
   * Initializes an argument
   */
  public Argument(int id) {
    this.id = id;
    this.contradictions = new ArrayList<Contradiction>();
  }

  /**
   * Initalizes an argument from an already existing one
   * @param argument The argument to initialize from
   */
  public Argument(Argument argument) {
    this.id = argument.getId();
    this.contradictions = argument.getContradictions();
  }

  /**
   * Adds a contradiction between two arguements
   */
  public void addContradiction(Contradiction contradiction) {
    this.contradictions.add(contradiction);
  }
  /**
   * Get all contradictions of the argument
   */
  public ArrayList<Contradiction> getContradictions() {
    return this.contradictions;
  }
   
  /**
   * Get the contradiction of the index i
   */
  public Contradiction getContradiction(int i) {
    return this.contradictions.get(i);
  }
  /**
   * Get the number of contradiction of the argument
   */
  public int getNumberContradictions() {
    return this.contradictions.size();
  }
  /**
   * Get the id (index of the argument in the graph).
   */
  public int getId() {
    return this.id;
  }
  /**
   * Get the String of an argument Ai (1<=i<=n).
   */
  public String toString() {
    return "A" + (this.id + 1);
  }
  /**
   * Checks if this.argument contradicts with the argument arg.
   */
  public boolean contradicts(Argument arg) {
    for (Contradiction cont : this.getContradictions()) {
      if (cont.getContradicts() == arg.getId()) {
        return true;
      }
    }
    return false;
  }
}
