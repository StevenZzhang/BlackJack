import java.util.*;
public class BlackJack {
    public static void main(String[] args) {
        Scanner pencil = new Scanner(System.in);
        ArrayList<Card> deck = new ArrayList<>();
        deck.add(new Card("Hearts", 1, "Ace"));
        deck.add(new Card("Hearts", 2, "Two"));
        deck.add(new Card("Hearts", 3, "Three"));
        deck.add(new Card("Hearts", 4, "Four"));
        deck.add(new Card("Hearts", 5, "Five"));
        deck.add(new Card("Hearts", 6, "Six"));
        deck.add(new Card("Hearts", 7, "Seven"));
        deck.add(new Card("Hearts", 8, "Eight"));
        deck.add(new Card("Hearts", 9, "Nine"));
        deck.add(new Card("Hearts", 10, "Ten"));
        deck.add(new Card("Hearts", 10, "Jack"));
        deck.add(new Card("Hearts", 10, "Queen"));
        deck.add(new Card("Hearts", 10, "King"));
        deck.add(new Card("Diamonds", 1, "Ace"));
        deck.add(new Card("Diamonds", 2, "Two"));
        deck.add(new Card("Diamonds", 3, "Three"));
        deck.add(new Card("Diamonds", 4, "Four"));
        deck.add(new Card("Diamonds", 5, "Five"));
        deck.add(new Card("Diamonds", 6, "Six"));
        deck.add(new Card("Diamonds", 7, "Seven"));
        deck.add(new Card("Diamonds", 8, "Eight"));
        deck.add(new Card("Diamonds", 9, "Nine"));
        deck.add(new Card("Diamonds", 10, "Ten"));
        deck.add(new Card("Diamonds", 10, "Jack"));
        deck.add(new Card("Diamonds", 10, "Queen"));
        deck.add(new Card("Diamonds", 10, "King"));
        deck.add(new Card("Clubs", 1, "Ace"));
        deck.add(new Card("Clubs", 2, "Two"));
        deck.add(new Card("Clubs", 3, "Three"));
        deck.add(new Card("Clubs", 4, "Four"));
        deck.add(new Card("Clubs", 5, "Five"));
        deck.add(new Card("Clubs", 6, "Six"));
        deck.add(new Card("Clubs", 7, "Seven"));
        deck.add(new Card("Clubs", 8, "Eight"));
        deck.add(new Card("Clubs", 9, "Nine"));
        deck.add(new Card("Clubs", 10, "Ten"));
        deck.add(new Card("Clubs", 10, "Jack"));
        deck.add(new Card("Clubs", 10, "Queen"));
        deck.add(new Card("Clubs", 10, "King"));
        deck.add(new Card("Spades", 1, "Ace"));
        deck.add(new Card("Spades", 2, "Two"));
        deck.add(new Card("Spades", 3, "Three"));
        deck.add(new Card("Spades", 4, "Four"));
        deck.add(new Card("Spades", 5, "Five"));
        deck.add(new Card("Spades", 6, "Six"));
        deck.add(new Card("Spades", 7, "Seven"));
        deck.add(new Card("Spades", 8, "Eight"));
        deck.add(new Card("Spades", 9, "Nine"));
        deck.add(new Card("Spades", 10, "Ten"));
        deck.add(new Card("Spades", 10, "Jack"));
        deck.add(new Card("Spades", 10, "Queen"));
        deck.add(new Card("Spades", 10, "King"));
        System.out.println("Welcome to BlackJack! \n You have $1000.");
        int playerbalance = 1000;
        boolean win = true;
        boolean playagain = true;
        while (playagain) {
            while (win) {
                boolean betrerun = true;
                int bet = 0;
                int playergametotal = 0;
                int dealergametotal = 0;
                boolean aceorno = false;
                int acecount = 0;
                while (betrerun) {
                    System.out.println("How much would you like to bet?");
                    bet = pencil.nextInt();
                    pencil.nextLine();
                    if (bet > playerbalance) {
                        System.out.println("You don't have enough, please enter your bet again");
                        betrerun = true;
                    } else {
                        betrerun = false;
                    }
                }
                deck = shuffle(deck);
                System.out.println("You have " + deck.get(0));
                playergametotal += deck.get(0).getvalue();
                if (deck.get(0).getvalue() == 1) {
                    aceorno = true;
                    acecount++;
                }
                System.out.println("You have " + deck.get(1));
                playergametotal += deck.get(1).getvalue();
                if (deck.get(1).getvalue() == 1) {
                    aceorno = true;
                    acecount++;
                }
                System.out.println("The dealer has " + deck.get(2));
                dealergametotal += deck.get(2).getvalue();
                boolean draw = true;
                boolean bust = false;
                while (draw) {
                    for (int i = 15; i < 52; i++) {
                        System.out.println("You have a total of " + playergametotal + " right now. Would you like to draw another? (y/n)");
                        String yesorno = pencil.nextLine();
                        if (yesorno.equals("y")) {
                            System.out.println("You have " + deck.get(i));
                            playergametotal += deck.get(i).getvalue();
                            if (deck.get(i).getvalue() == 1) {
                                aceorno = true;
                                acecount++;
                            }
                            System.out.println("You now have a total of " + playergametotal + " now.");
                            if (playergametotal > 21) {
                                draw = false;
                                System.out.println("You have busted!");
                                win = false;
                                break;
                            }
                        } else {
                            draw = false;
                            break;
                        }
                    }
                }
                if (!win) {
                    System.out.println("The dealer has won!");
                    playerbalance -= bet;
                    System.out.println("Your new balance is " + playerbalance);
                    break;
                }
                for (int i = 3; i < 15; i++) {
                    System.out.println("The dealer has " + deck.get(i));
                    dealergametotal += deck.get(i).getvalue();
                    if (dealergametotal >= 17)
                        break;
                }
                if (dealergametotal > 21) {
                    win = false;
                    System.out.println("You has won!");
                    playerbalance += bet;
                    System.out.println("Your new balance is " + playerbalance);
                    break;
                }
                if (aceorno) {
                    for (int i = 0; i < acecount; i++) {
                        if (playergametotal + 10 <= 21) {
                            playergametotal++;
                        }
                    }
                }
                if (dealergametotal > playergametotal) {
                    win = false;
                    System.out.println("The dealer has won!");
                    playerbalance -= bet;
                    System.out.println("Your new balance is " + playerbalance);
                }
                else if (dealergametotal == playergametotal) {
                    win = false;
                    System.out.println("You have tied!");
                    System.out.println("Your balance is still" + playerbalance);
                }
                else {
                    win = false;
                    System.out.println("You have won!");
                    playerbalance += bet;
                    System.out.println("Your new balance is: " + playerbalance);
                }
            }
            if (playerbalance > 0) {
                System.out.println("Would you like to keep betting? (y/n)");
                String yesorno = pencil.nextLine();
                if (yesorno.equals("n")) {
                    playagain = false;
                } else {
                    win = true;
                }
            }
            else {
                System.out.println("You are out of money! \nThanks for playing!");
                playagain = false;
            }
        }
    }
    public static ArrayList<Card> shuffle(ArrayList<Card> deck) {
        ArrayList<Card> tempdeck = deck;
        int random;
        int[] taken = new int[52];
        for (int i = 0; i < 52; i++) {
            random = (int) (Math.random() * 52) + 1;
            for (int j = 0; j < 52; j++) {
                while (taken[j] == random) {
                    random = (int) (Math.random() * 52) + 1;
                }
            }
            taken[i] = random;
            deck.set(i, tempdeck.get(random - 1));
        }
        return deck;
    }
}