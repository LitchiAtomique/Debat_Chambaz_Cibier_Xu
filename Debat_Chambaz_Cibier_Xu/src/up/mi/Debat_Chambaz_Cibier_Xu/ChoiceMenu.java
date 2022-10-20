package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;
import java.util.ArrayList;

abstract public class ChoiceMenu extends Menu {
  boolean running; 

  ArrayList<String> choices;
  ArrayList<Runnable> functions;

  ChoiceMenu() {
    this.running = true;
    this.choices = new ArrayList<String>();
    this.functions = new ArrayList<Runnable>();
  }

  void addChoice(String choice, Runnable function) {
    this.choices.add(choice);
    this.functions.add(function);
  }

  void run() throws Exception {
    // error handling
    if (scanner == null)
      throw new Exception("Invalid scanner");
    if (prompt == null)
      throw new Exception("Invalid prompt");
    if (functions.size() == 0)
      throw new Exception("Invalid functions");

    System.out.println(this.prompt);
    while (this.running) {
      String[] choices_arr = new String[choices.size()];
      for (int i = 0; i < choices.size(); i++) {
        choices_arr[i] = choices.get(i);
      }
      int choice = IO.ioGetChoice(
          this.scanner,
          this.prompt,
          choices_arr);

      for (int i = 0; i < functions.size(); i++) {
        if (choice == i) {
          functions.get(i).run();
          break;
        }
      }
    }
  }

  void end() {
    this.running = false;
  }
}
