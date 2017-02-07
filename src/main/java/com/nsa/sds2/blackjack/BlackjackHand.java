package com.nsa.sds2.blackjack;

import com.nsa.sds2.playingcards.Hand;
import com.nsa.sds2.playingcards.PlayingCard;
import com.nsa.sds2.playingcards.Rank;

/**
 * Represents a Blackjack hand
 */
public class BlackjackHand {

    private Hand hand;


    public BlackjackHand(Hand aHand) {
        hand = aHand;

    }

    private int getTotal() {
        int total = 0;
        for (PlayingCard card : hand.getCards()) {
            total += this.getBlackjackValue(card.getRank());
        }
        return total;
    }

    private int getAceCount() {
        int count = 0;
        for (PlayingCard card : hand.getCards()) {
            if (card.getRank().equals(Rank.ACE)) {
                count++;
            }
        }
        return count;
    }

    public int getBestValue() {

        int total = getTotal();
        int aces = getAceCount();

        int over = total - 21;
        int numberOfAcesToSave = Math.floorDiv(over, 10); //how many aces do I play as 1 rather than 11 in order to stay in the game?

        if (total > 21) {
            if (aces < numberOfAcesToSave) {
                return 0;
            } else return total - (numberOfAcesToSave * 10);
        }
        return total;

    }

    private int getBlackjackValue(Rank aRank) {
        switch (aRank) {
            case ACE:
                return 11;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                return aRank.ordinal() + 1;
        }
    }

}
