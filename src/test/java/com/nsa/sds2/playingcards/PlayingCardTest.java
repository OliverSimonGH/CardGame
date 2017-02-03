package com.nsa.sds2.playingcards;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Carl on 03/02/2017.
 */
public class PlayingCardTest {
    @Test
    public void aceOfSpacesEqualsAceOfSpades() throws Exception {
        PlayingCard card1 = new PlayingCard(Suit.SPADES, Rank.ACE);
        PlayingCard card2 = new PlayingCard(Suit.SPADES, Rank.ACE);

        assertTrue(card1.equals(card2));

    }

    @Test
    public void aceOfSpacesOutput() throws Exception {
        PlayingCard card1 = new PlayingCard(Suit.SPADES, Rank.ACE);
        assertEquals("ACE OF SPADES", card1.toString());


    }

}