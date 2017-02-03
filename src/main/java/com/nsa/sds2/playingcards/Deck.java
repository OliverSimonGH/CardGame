package com.nsa.sds2.playingcards;

import java.util.ArrayList;

/**
 * Class to represent a Deck of Playing Cards
 */

public class Deck {
    /**
     * a deck consists of a collection of PlayingCards.
     * What type of Collection is best?
     * A Set would ensure no duplication, but what about sorting and shuffling?
     * An ArrayList offers the opportunity to control the order.  We can control duplication manually.
     */
    private ArrayList<PlayingCard> cards;  //declare the field.  This does NOT initialise it.

    /**
     * In this case, there is a default constructor because there is a clear standard for a deck of cards.
     */
    public Deck() {

        cards = new ArrayList<PlayingCard>(); //initialise the ArrayList using its constructor.

        /*
        Rank and Suit are enums so we can ask an enum for its values() and we can iterate over them.
        Nest the loops and we can create the full deck.

        We will get a sorted deck.
         */
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
    }

    /**
     * We need the ability to shuffle the deck.
     * Algorithm is to pick two random cards and swap them for the provided number of times.
     */
    public void shuffle(int numberOfSwaps) {
        //shuffle deck by swapping random pairs of cards n times

        for (int swap = 0; swap < numberOfSwaps; swap++) {
            this.swap((int) Math.round(Math.random() * 51), (int) Math.round(Math.random() * 51));
        }
    }

    /**
     * private method to support the shuffle
     */
    private void swap(int aPlace, int anotherPlace) {
        PlayingCard temp = cards.get(aPlace);
        cards.set(aPlace, cards.get(anotherPlace));
        cards.set(anotherPlace, temp);
    }

    /**
     If we have shuffle, do we need sort?
     Would we ever sort a deck that is 'in-play'?
     Assume not, so no sort method in public interface.
     Client will just ask for a new deck.

     */

    /**
     * When the deck is dealt, we need to know how many cards are left ... or do we?
     * TO DO: reconsider this method.  Maybe just have isEmpty() and isFull() methods?
     */

    public int size() {

        return cards.size();
    }

    /**
     * Get direct access to a particular card.
     * TO DO: reconsider this method.  Would a client ever need to get a random card.  Magician?
     */

    public PlayingCard getCardAtIndex(int n) {
        return cards.get(n);
    }

    /**
     * we will need to deal cards, but how many and to whom may be better
     * placed in another class.
     * <p>
     * So, we will allow a client to take the top card from the pack.
     * <p>
     * TO DO: do we need to audit the dealing?
     */
    public PlayingCard deal() {
        return cards.remove(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck deck = (Deck) o;

        return cards.equals(deck.cards);
    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }
}
