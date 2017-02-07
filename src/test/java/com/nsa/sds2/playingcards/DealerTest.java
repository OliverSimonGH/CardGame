package com.nsa.sds2.playingcards;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Carl on 07/02/2017.
 */
public class DealerTest {

    //create a dealer
    private Dealer aDealer;
    private ArrayList<Hand> hands;
    private Deck aDeck;
    private Hand hand1, hand2, hand3, hand4;

    @Before
    public void setup() throws Exception {
        aDealer = new Dealer();
        //create 4 hands
        hand1 = new Hand();
        hand2 = new Hand();
        hand3 = new Hand();
        hand4 = new Hand();
        //add hands to an ArrayList
        hands = new ArrayList<Hand>();

        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);

        //create a deck - DO NOT SHUFFLE!!!
        aDeck = new Deck();

        //deal 5 cards each to the 4 hands

        aDealer.deal(aDeck, hands, 5);
    }


    @Test
    public void deckHasExpectedSize() throws Exception {

        //if 4 hands have had 5 cards each, then there should be 52 - (4*5) left = 32

        assertEquals(32, aDeck.size());
    }

    @Test
    public void handHasExpectedCards() throws Exception {

        //since the deck was sorted, the following cards should be in the first hand

        PlayingCard aceOfClubs = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard fiveOfClubs = new PlayingCard(Suit.CLUBS, Rank.FIVE);
        PlayingCard nineOfClubs = new PlayingCard(Suit.CLUBS, Rank.NINE);
        PlayingCard kingOfClubs = new PlayingCard(Suit.CLUBS, Rank.KING);
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.DIAMONDS, Rank.FOUR);

        Hand expectedHand = new Hand();

        expectedHand.addCard(aceOfClubs);
        expectedHand.addCard(fiveOfClubs);
        expectedHand.addCard(nineOfClubs);
        expectedHand.addCard(kingOfClubs);
        expectedHand.addCard(fourOfDiamonds);

        // check hand1

        Hand dealtHand = hands.get(0);
        assertEquals(dealtHand, expectedHand);


    }

    @Test
    public void handsAreDifferent() throws Exception {
        PlayingCard aceOfClubs = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard fiveOfClubs = new PlayingCard(Suit.CLUBS, Rank.FIVE);
        PlayingCard nineOfClubs = new PlayingCard(Suit.CLUBS, Rank.NINE);
        PlayingCard kingOfClubs = new PlayingCard(Suit.CLUBS, Rank.KING);
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.DIAMONDS, Rank.FOUR);

        Hand expectedHand = new Hand();

        expectedHand.addCard(aceOfClubs);
        expectedHand.addCard(fiveOfClubs);
        expectedHand.addCard(nineOfClubs);
        expectedHand.addCard(kingOfClubs);
        expectedHand.addCard(fourOfDiamonds);

        assertNotEquals(hand2, expectedHand);


    }


    //TODO research JUnit best practices.  why is this test bad (in terms of best practice)?
    //TODO write more tests.  vary the number of hands, and the number of cards per hand


}