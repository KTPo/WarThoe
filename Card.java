import java.util.*;
import java.io.*;

public class Card {
  // Instance Var

  public static String values = "23456789TJKQA";
  public static String suits = "CDHS";
  private char value;
  private char suit;
  private int point;

  public static final String TEXT_RED = "\u001B[31m";
  public static final String TEXT_BRIGHTBLACK = "\u001b[30;1m";
  public static final String TEXT_RESET = "\u001B[0m";

  // Constructor
  public Card() { // random card
    Random random = new Random();
    int valueIndex = random.nextInt(0, 13);
    value = values.charAt(valueIndex); // gets char at specific index in string
    point = valueIndex + 2; // assigns ascending point value to each card

    int suitIndex = random.nextInt(0, 4);
    suit = suits.charAt(suitIndex);
  }

  public Card(int s, int v) { // known card --> deck class
    value = values.charAt(v); // gets char at specific index in string
    point = v + 2; // assigns ascending point value to each card

    suit = suits.charAt(s);
  }

  // Methods
  public int getPoint() {
    return point;
  }

  public String toString() {
    String c = "";
    if (suit == 'C') {
      c = "\u001b[30;1m";
    }

    if (suit == 'H') {
      c = "\u001b[31;1m";
    }

    if (suit == 'D') {
      c = "\u001b[31;1m";
    }

    else {
      c = "\u001b[30;1m";
    }
    return (c + value + suit + "\u001B[0m");
  }
}
