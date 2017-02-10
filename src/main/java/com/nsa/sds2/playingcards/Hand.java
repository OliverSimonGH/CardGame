package com.nsa.sds2.playingcards;

import java.util.ArrayList;

/**
 * class to represent a Hand held by someone in a game.  At this point, the game is not relevant.
 */
public class Hand {

    private ArrayList<PlayingCard> cards;
    private int maximumSize;
    private String player;

    public Hand() {
        this(53);
    }

    public Hand(int aMaxSize) {
        maximumSize = aMaxSize;
        cards = new ArrayList<PlayingCard>();
    }

    public void addCard(PlayingCard aCard) {
        if (getSize() < maximumSize) {
            cards.add(aCard);
        }
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getSize() {
        return cards.size();
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public PlayingCard getCardAt(int index) {
        return cards.get(index);
    }

    public String toString() {
        StringBuffer out = new StringBuffer("| ");
        for (PlayingCard card : cards) {
            out.append(card.toString());
            out.append(" | ");
        }
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hand hand = (Hand) o;

        if (maximumSize != hand.maximumSize) return false;
        return cards != null ? cards.equals(hand.cards) : hand.cards == null;
    }

    @Override
    public int hashCode() {
        int result = cards != null ? cards.hashCode() : 0;
        result = 31 * result + maximumSize;
        return result;
    }
}
