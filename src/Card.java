public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        int value = 0;
        if (rank.equals("10") || rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            value = 10;
        } else if (rank.equals("A")) {
            value = 1; // An ace counting as 11 is handled when a hand is scored.
        } else if (rank.equals("9")) {
            value = 9;
        } else if (rank.equals("8")) {
            value = 8;
        } else if (rank.equals("7")) {
            value = 7;
        } else if (rank.equals("6")) {
            value = 6;
        } else if (rank.equals("5")) {
            value = 5;
        } else if (rank.equals("4")) {
            value = 4;
        } else if (rank.equals("3")) {
            value = 3;
        } else if (rank.equals("2")) {
            value = 2;
        }
        return value;
    }

    public boolean isAce() {
        return rank.equals("A");
    }

    public String toString() {
        return rank + suit;
    }
}