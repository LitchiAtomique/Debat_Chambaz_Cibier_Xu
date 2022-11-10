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

  public ArrayList<Contradiction> getContradictions() {
    return this.contradictions;
  }

  public Contradiction getContradiction(int i) {
    return this.contradictions.get(i);
  }

  public int getNumberContradictions() {
    return this.contradictions.size();
  }

  public int getId() {
    return this.id;
  }

  public void print() {
    System.out.print(this.id);
  }
}
