package com.nsa.sds2.playingcards;

import java.util.ArrayList;

/**
 * Class to represent the role of a dealer in any game
 */
public class Dealer {

    public void deal(Deck aDeck, ArrayList<Hand> someHands, int noOfCards) {
        for (int deal = 0; deal < noOfCards; deal++) {
            for (Hand aHand : someHands) {
                aHand.addCard(aDeck.deal());
            }
        }
    }

}
