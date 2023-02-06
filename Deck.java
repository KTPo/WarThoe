import java.util.*;

public class Deck{
  
  //Instance Var
  Card[] card = new Card[52];

  //Constructor
  public Deck(){
    int index = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 13; j++) {
        card[index] = new Card(i,j);
        index++;
      }
    } 
  }
  
  //Methods 
  public void shuffleDeck(){
    Card placeHolder = new Card();
    
    for(int i = 0; i < 52; i++){
      Random random = new Random(); 
      int newIndex = random.nextInt(0, 52);
      placeHolder = card[newIndex];
      card[newIndex] = card[i];
      card[i] = placeHolder; 
    }
  }

  public void printEntireDeck(){
    for(int i = 0; i < 52; i++){
      System.out.println(card[i]);
    }
  }
}
