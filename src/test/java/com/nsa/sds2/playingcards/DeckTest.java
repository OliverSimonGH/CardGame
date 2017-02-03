package com.nsa.sds2.playingcards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Carl on 03/02/2017.
 */
public class DeckTest {

    @Test
    public void shuffledIsDifferentWhileFreshDeckIsTheSame() throws Exception {
        Deck newDeck = new Deck();
        Deck shuffledDeck = new Deck();
        Deck freshDeck = new Deck();
        shuffledDeck.shuffle(10);
        assertNotEquals(newDeck, shuffledDeck);
        assertEquals(newDeck, freshDeck);
    }

    @Test
    public void sizeAtStartEquals52() throws Exception {
        Deck newDeck = new Deck();
        assertEquals(52, newDeck.size());
    }

    @Test
    public void dealSortedPackGetsAceOfClubsAndLeaves51Cards() throws Exception {
        Deck newDeck = new Deck();
        Deck freshDeck = new Deck();
        PlayingCard topCard = freshDeck.deal();
        PlayingCard aceOfClubs = new PlayingCard(Suit.CLUBS, Rank.ACE);
        assertEquals(aceOfClubs, topCard);
        assertEquals(51, freshDeck.size());
    }

}