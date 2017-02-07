package com.nsa.sds2.blackjack;

import com.nsa.sds2.playingcards.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Carl on 07/02/2017.
 */
public class BlackjackHandTest {
    @Test
    public void getBestValueForAceAndTwo() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);
        ArrayList<Hand> hands = new ArrayList<Hand>();
        Deck aDeck = new Deck();
        Dealer aDealer = new Dealer();
        hands.add(aHand);

        aDealer.deal(aDeck, hands, 2);

        System.out.println(aHand);


        assertEquals(13, aBjHand.getBestValue());
    }


    @Test
    public void getBestValueForAceAndKing() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);
        ArrayList<Hand> hands = new ArrayList<Hand>();

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.KING));

        hands.add(aHand);


        System.out.println(aHand);


        assertEquals(21, aBjHand.getBestValue());
    }

    @Test
    public void getBestValueForThreeSevens() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);
        ArrayList<Hand> hands = new ArrayList<Hand>();

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.SEVEN));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));


        hands.add(aHand);


        System.out.println(aHand);


        assertEquals(21, aBjHand.getBestValue());
    }


}