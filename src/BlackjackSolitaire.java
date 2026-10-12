import java.util.Scanner;
public class BlackjackSolitaire {
    private Deck deck = new Deck();
    private Card[] roundEnter = new Card[20];
    private Scanner scanner = new Scanner(System.in);

    public void displayGrid(){
        for (int i = 0; i <= 4; i++) {
            if (roundEnter[i] == null) {
                System.out.print((i + 1) + "\t");
            } else {
                System.out.print(roundEnter[i] + "\t");
            }
        }
        System.out.println();
        for (int i = 5; i <= 9; i++) {
            if (roundEnter[i] == null) {
                System.out.print((i + 1) + "\t");
            } else {
                System.out.print(roundEnter[i] + "\t");
            }
        }
        System.out.println();
        for (int i = 10; i <= 12; i++) {
            if (roundEnter[i] == null) {
                System.out.print((i + 1) + "\t");
            } else {
                System.out.print(roundEnter[i] + "\t");
            }
        }
        System.out.println();
        for (int i = 13; i <= 15; i++) {
            if (roundEnter[i] == null) {
                System.out.print((i + 1) + "\t");
            } else {
                System.out.print(roundEnter[i] + "\t");
            }
        }
        System.out.println();
        System.out.println("Discards remaining: " + discardRemaining());

    }
    public int discardRemaining(){
        int remaining = 0;
        for (int i = 16; i < 19; i++) {
            if (roundEnter[i] == null) {
                remaining++;
            }
        }
        return remaining;
    }
    public int positionChoice() {
        int position = 0;
        boolean found = false;
        while (!found) {
            System.out.println("Please enter which position you would like to place this card.");
            position = scanner.nextInt();
            if (position > 20 || position < 1 || roundEnter[position - 1] != null) {
                System.out.println("You have entered an invalid position.");
                System.out.println("Please pick another position.");
            } else {
                found = true;
            }
        }
        return position;
    }
    public void placeCard(Card card, int position) {
        roundEnter[position-1] = card;
        System.out.println("You have placed " + card+ " at position " + position);
    }
    public boolean gameOver() {
        for (int i = 0; i < 16; i++) {
            if (roundEnter[i] == null) {
                return false;
            }
        }
        return true;
    }
    private int scoreHand(Card[] hand) {
        int sum = 0;
        boolean hasAce = false;
        for (int i = 0; i < hand.length; i++) {
            sum += hand[i].getValue();
            if (hand[i].isAce()) {
                hasAce = true;
            }
        }
        if (hasAce && sum + 10 <= 21) {
            sum += 10;
        }
        if (sum == 21 && hand.length == 2) {
            return 10;
        } else if (sum == 21) {
            return 7;
        } else if (sum == 20) {
            return 5;
        } else if (sum == 19) {
            return 4;
        } else if (sum == 18) {
            return 3;
        } else if (sum == 17) {
            return 2;
        } else if (sum <= 16) {
            return 1;
        } else {
            return 0;
        }
    }
    public int calculateScore() {
        Card[] column1 = {roundEnter[0], roundEnter[5]};
        Card[] column2 = {roundEnter[1], roundEnter[6], roundEnter[10], roundEnter[13]};
        Card[] column3 = {roundEnter[2], roundEnter[7], roundEnter[11], roundEnter[14]};
        Card[] column4 = {roundEnter[3], roundEnter[8], roundEnter[12], roundEnter[15]};
        Card[] column5 = {roundEnter[4], roundEnter[9]};
        Card[] row1 = {roundEnter[0], roundEnter[1], roundEnter[2], roundEnter[3],roundEnter[4]};
        Card[] row2 = {roundEnter[5], roundEnter[6], roundEnter[7], roundEnter[8],roundEnter[9]};
        Card[] row3 = {roundEnter[10], roundEnter[11], roundEnter[12]};
        Card[] row4 = {roundEnter[13], roundEnter[14],roundEnter[15]};
        int total = 0;
        total = scoreHand(row1) + scoreHand(row2) + scoreHand(row3) + scoreHand(row4) + scoreHand(column1) + scoreHand(column2) + scoreHand(column3) + scoreHand(column4) + scoreHand(column5);
        return total;
    }

}
