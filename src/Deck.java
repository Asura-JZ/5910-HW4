import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private String[] RANKS = {"A", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "J", "Q", "K"};
    private String[] SUITS = {"S", "H", "D", "C"};
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                Card c = new Card(RANKS[i], SUITS[j]);
                cards.add(c);
            }
        }
    }

    public void shuffle() {
        Random r = new Random();
        ArrayList<Card> shuffled = new ArrayList<>();
        while (cards.size() > 0) {
            int j = r.nextInt(cards.size());
            shuffled.add(cards.remove(j));
        }
        cards = shuffled;
    }

    public Card dealCard() {
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
