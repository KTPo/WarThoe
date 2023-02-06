import java.util.*;

class Main {
  public static Card c = new Card(); 
  public static Deck d = new Deck(); 
  public static ArrayList<Card> playerHand = new ArrayList<Card>();
  public static ArrayList<Card> computerHand = new ArrayList<Card>(); 
  public static ArrayList<Card> playerDiscard = new ArrayList<Card>();
  public static ArrayList<Card> computerDiscard = new ArrayList<Card>();
  
  public static boolean hitting = true;

  public static void main(String[] args) {
    d.shuffleDeck();
    dealPlayerHand();
    dealComputerHand(); 
    if(playerHand.size() + playerDiscard.size() == 0 || computerHand.size() + computerDiscard.size() == 0){
      hitting = false;
      System.out.print("END");
    }
    
    while(hitting){
      if(playerHand.size() != 0 && computerHand.size() != 0){
        versus(0);
        hit();
      } else if(playerHand.size() == 0){
          addBackPlayerDiscard();
          if(computerHand.size() == 0){
            addBackComputerDiscard(); 
          }
      } else if(computerHand.size() == 0){
          addBackComputerDiscard(); 
          if(playerHand.size() == 0){
            addBackPlayerDiscard(); 
          }
      }
    }
    
    if(!hitting){
      System.out.println("Thanks for playing!");
    }
  }

  public static void dealPlayerHand(){
    for(int i = 0; i < 26; i++){
      playerHand.add(d.card[i]);
    }
  }

  public static void dealComputerHand(){
    for(int i = 26; i < 52; i++){
      computerHand.add(d.card[i]);
    }
  }

  public static void versus(int ind){
    System.out.println("Player:       Computer:      \n" + "------        ------\n" + "| " + playerHand.get(ind) + " |        | " + computerHand.get(ind) + " |\n" + "|   " + " |        | " + "   |\n" + "|   " + " |        | " + "   |\n" + "------        ------");
    decideWinner(ind);
  }
  
  public static void decideWinner(int ind){
    if(playerHand.get(ind).getPoint() > computerHand.get(ind).getPoint()){
      System.out.println("\nPlayer wins!");
      for(int i = -1; i < ind; i++){
        playerDiscard.add(playerHand.get(i+1));
        playerDiscard.add(computerHand.get(i+1));
        playerHand.remove(i+1);
        computerHand.remove(i+1);
      }
    } else if(playerHand.get(ind).getPoint() < computerHand.get(ind).getPoint()){
      System.out.println("\nComputer wins!");
      for(int i = -1; i < ind; i++){
        computerDiscard.add(playerHand.get(i+1));
        computerDiscard.add(computerHand.get(i+1));
        playerHand.remove(i+1);
        computerHand.remove(i+1);
      }
    } else if(playerHand.get(ind).getPoint() == computerHand.get(ind).getPoint()){
      declareWar();
    }
  }

  public static void hit(){
    if(playerHand.size() != 0 && computerHand.size() != 0){
      replay();
    } else if(playerHand.size() == 0){
      addBackPlayerDiscard();
    } else if(computerHand.size() == 0){
      addBackComputerDiscard(); 
    }
  }
  
  public static void replay(){
    
    System.out.println("Player current number of cards: " + (playerHand.size() + playerDiscard.size()));
    System.out.println("Computer current number of cards: " + (computerHand.size() + computerDiscard.size()));
    System.out.println("Play Again?");
    Scanner playAgain = new Scanner(System.in);
    String ask = playAgain.nextLine();
    
    if(ask.equals("y")){
      System.out.print("\033[H\033[2J");
      versus(0); 
      hit();
    } else if(ask.equals("n")){
      hitting = false;
    } else{
      System.out.println("\nSorry, I don't understand. Play Again? ");
      replay();
    }
  }
  
  public static void addBackPlayerDiscard(){
    playerHand.addAll(playerDiscard);
    playerDiscard.clear();
    System.out.println("Player Hand Size: " + playerHand.size());
  }

  public static void addBackComputerDiscard(){
    computerHand.addAll(computerDiscard);
    computerDiscard.clear();
    System.out.println("Computer Hand Size: " + computerHand.size());
  }

 
  
  public static void declareWar(){
    System.out.println("         I!");
    System.out.println("------        ------\n" + "|    |        |    |\n" + "|   " + " |        |    |\n" + "|   " + " |        | " + "   |\n" + "------        ------");
    System.out.println("      DECLARE!");
    System.out.println("------        ------\n" + "|    |        |    |\n" + "|   " + " |        |    |\n" + "|   " + " |        | " + "   |\n" + "------        ------");
    System.out.println("       WAR!!!");
    System.out.println("------        ------\n" + "|    |        |    |\n" + "|   " + " |        |    |\n" + "|   " + " |        | " + "   |\n" + "------        ------");

    if(playerHand.size() >= 5){
      if(computerHand.size() >= 5){
        versus(4); 
      } else{
        addBackComputerDiscard(); 
        versus(4); 
      }
    } else{
      addBackPlayerDiscard(); 
      if(computerHand.size() >= 5){
        versus(4); 
      } else{
        addBackComputerDiscard(); 
        versus(4); 
      }
    }
  }
}
