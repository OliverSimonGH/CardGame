package com.nsa.sds2.blackjack;

import com.nsa.sds2.playingcards.Dealer;
import com.nsa.sds2.playingcards.Deck;
import com.nsa.sds2.playingcards.Hand;

import java.util.*;

/**
 * Main game class with game loop
 */
public class BlackjackGame {

    private ArrayList<BlackjackHand> handsIn;

    private Deck theDeck;
    private Dealer dealer;


    public BlackjackGame(String... names) {
        handsIn = new ArrayList<BlackjackHand>();

        for (String name : names) {
            BlackjackHand aHand = new BlackjackHand();
            aHand.setPlayer(name);
            handsIn.add(aHand);
        }
        theDeck = new Deck();
        dealer = new Dealer();

    }

    public void initialDeal() {

        theDeck.shuffle(100);
        dealer.deal(theDeck, handsIn, 2);
    }

    public void gameLoop() {

        int playersInGame = handsIn.size();

        while (playersInGame > 1) {
            for (BlackjackHand aHand : handsIn) {
                if (shouldStick(aHand.getBestHandValue())) {
                    aHand.stick();
                    playersInGame--;
                } else if (aHand.isInGame()) {
                    dealer.dealTopCardToHand(theDeck, aHand);

                    if (aHand.getBestHandValue().compareTo(BlackjackValue.BUST) == 0) {
                        aHand.outOfGame();
                        playersInGame--;
                    }

                }
            }
        }
    }

    private boolean shouldStick(BlackjackValue bjV) {
        if (bjV.compareTo(BlackjackValue._12) >= 1) {
            return (Math.random() > 0.5);
        }
        return false;
    }


    public BlackjackHand getWinner() {

        System.out.println("------------------------------------------------------" +
                "");

        BlackjackHand winner = new BlackjackHand();
        BlackjackValue best = BlackjackValue.BUST;

        for (BlackjackHand hand : handsIn) {

            System.out.println(hand.getPlayer() + " has hand " + hand + " with value " + hand.getBestHandValue());
            if (hand.getBestHandValue().compareTo(best) >= 1) {
                winner = hand;
                best = hand.getBestHandValue();
            }
        }
        return winner;
        //TO DO : HANDLE DRAW
    }

    public static void main(String... args) {
        String[] players = {"Carl", "Ian", "Chris"};
        BlackjackGame game = new BlackjackGame(players);
        game.initialDeal();
        game.gameLoop();
        System.out.println("Winner is " + game.getWinner().getPlayer());
    }


}
