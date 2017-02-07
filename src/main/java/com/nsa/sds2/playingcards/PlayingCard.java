package com.nsa.sds2.playingcards;

/**
 * Class to represent a single, standard playing card (not including the Jokers)
 */
public class PlayingCard {

    /*
    fields encapsulated from external use.
     */
    private final Rank rank;
    private final Suit suit;

    /*
    constructor for a Playing Card.
    No default constructor supplied.  What would be the default values?
    NOTE: in future, you will come across frameworks that insist on a default constructor!
     */

    public PlayingCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /*
    Provide access methods for fields.  No equivalent setters are provided.  Cards can only be constructed.
     */

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    /*
    implement standard functions; equals, hashcode and toString
    IDEs will often provide defaults for this.
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (rank != that.rank) return false;
        return suit == that.suit;

    }

    @Override
    public int hashCode() {
        int result = rank != null ? rank.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return rank +
                " OF " + suit;
    }

}
