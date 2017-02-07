package com.nsa.sds2.playingcards;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Carl on 07/02/2017.
 */
public class DealerTest {
    @Test
    public void deal() throws Exception {

        //create a dealer
        Dealer aDealer = new Dealer();


        //create 4 hands
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        Hand hand3 = new Hand();
        Hand hand4 = new Hand();

        //add hands to an ArrayList
        ArrayList<Hand> hands = new ArrayList<Hand>();

        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);

        //create a deck - DO NOT SHUFFLE!!!
        Deck aDeck = new Deck();

        //deal the cards to the 4 hands
        aDealer.deal(aDeck, hands, 5);


        //if 4 hands have had 5 cards each, then there should be 52 - (4*5) left = 32

        assertEquals(32, aDeck.size());

        //since the deck was sorted, the following cards should be in the first hand

        PlayingCard aceOfClubs = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard fiveOfClubs = new PlayingCard(Suit.CLUBS, Rank.FIVE);
        PlayingCard nineOfClubs = new PlayingCard(Suit.CLUBS, Rank.NINE);
        PlayingCard kingOfClubs = new PlayingCard(Suit.CLUBS, Rank.KING);
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.DIAMONDS, Rank.FOUR);


        // check hand1

        assertEquals(hand1.getCardAt(0), aceOfClubs);
        assertEquals(hand1.getCardAt(1), fiveOfClubs);
        assertEquals(hand1.getCardAt(2), nineOfClubs);
        assertEquals(hand1.getCardAt(3), kingOfClubs);
        assertEquals(hand1.getCardAt(4), fourOfDiamonds);


        //check size of hand2

        assertEquals(5, hand2.getSize());

        assertNotEquals(hand1, hand2);

    }
    //TODO research JUnit best practices.  why is this test bad (in terms of best practice)?
    //TODO write more tests.  vary the number of hands, and the number of cards per hand


}