package com.nsa.sds2.blackjack;

import com.nsa.sds2.playingcards.Hand;
import com.nsa.sds2.playingcards.PlayingCard;
import com.nsa.sds2.playingcards.Rank;

import java.util.Comparator;

/**
 * Represents a Blackjack hand
 */
public class BlackjackHand extends Hand {

    private boolean inGame;
    private boolean hasStuck;


    public BlackjackHand() {
        super();
        inGame = true;
        hasStuck = false;

    }


    public boolean isInGame() {
        return inGame;
    }

    public void outOfGame() {
        this.inGame = false;
    }


    public boolean hasStuck() {
        return hasStuck;
    }

    public void stick() {
        this.hasStuck = true;
    }

    private int getTotal() {
        int total = 0;
        for (PlayingCard card : this.getCards()) {
            total += this.getBlackjackCardValue(card.getRank());
        }
        return total;
    }

    private int getAceCount() {
        int count = 0;
        for (PlayingCard card : this.getCards()) {
            if (card.getRank().equals(Rank.ACE)) {
                count++;
            }
        }
        return count;
    }

    public BlackjackValue getBestHandValue() {

        int total = getTotal();
        int aces = getAceCount();

        int over = total - 21;
        int numberOfAcesToSave = Math.floorDiv(over, 10) + 1; //how many aces do I play as 1 rather than 11 in order to stay in the game?

        if (total > 21) {
            if (aces < numberOfAcesToSave) {
                return BlackjackValue.BUST;
            } else total = total - (numberOfAcesToSave * 10);
        }

        if (total == 21 && this.getSize() == 2) {
            return BlackjackValue.BLACKJACK;
        }


        return BlackjackValue.values()[total];

    }




    private int getBlackjackCardValue(Rank aRank) {
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

    public String toString() {
        return getBestHandValue().toString();
    }

}
