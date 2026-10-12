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
}
