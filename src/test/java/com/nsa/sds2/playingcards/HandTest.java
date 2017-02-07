package com.nsa.sds2.playingcards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Carl on 07/02/2017.
 */
public class HandTest {

    private Hand aHand;

    @Before
    public void setup() throws Exception {
        aHand = new Hand();

        PlayingCard aceOfClubs = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard fiveOfClubs = new PlayingCard(Suit.CLUBS, Rank.FIVE);
        PlayingCard nineOfClubs = new PlayingCard(Suit.CLUBS, Rank.NINE);
        PlayingCard kingOfClubs = new PlayingCard(Suit.CLUBS, Rank.KING);
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.DIAMONDS, Rank.FOUR);

        aHand.addCard(aceOfClubs);
        aHand.addCard(fiveOfClubs);
        aHand.addCard(nineOfClubs);
        aHand.addCard(kingOfClubs);
        aHand.addCard(fourOfDiamonds);
    }


    @Test
    public void handIsCorrectSize() throws Exception {
        assertEquals(5, aHand.getSize());
    }

    @Test
    public void firstCardIsAceOfClubs() throws Exception {
        PlayingCard aceOfClubs2 = new PlayingCard(Suit.CLUBS, Rank.ACE);
        assertEquals(aceOfClubs2, aHand.getCardAt(0));
    }

    @Test
    public void handHasMaxSize() throws Exception {

        Hand limitedHand = new Hand(4);

        PlayingCard aceOfClubs = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard fiveOfClubs = new PlayingCard(Suit.CLUBS, Rank.FIVE);
        PlayingCard nineOfClubs = new PlayingCard(Suit.CLUBS, Rank.NINE);
        PlayingCard kingOfClubs = new PlayingCard(Suit.CLUBS, Rank.KING);
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.DIAMONDS, Rank.FOUR);

        limitedHand.addCard(aceOfClubs);
        limitedHand.addCard(fiveOfClubs);
        limitedHand.addCard(nineOfClubs);
        limitedHand.addCard(kingOfClubs);
        limitedHand.addCard(fourOfDiamonds);//should be ignored

        assertEquals(4, limitedHand.getSize());

    }


}