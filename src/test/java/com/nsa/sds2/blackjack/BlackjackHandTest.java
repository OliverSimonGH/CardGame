package com.nsa.sds2.blackjack;

import com.nsa.sds2.playingcards.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Carl on 07/02/2017.
 */
public class BlackjackHandTest {
    @Test
    public void getBestValueForAceAndTwo() throws Exception {

        BlackjackHand aBjHand = new BlackjackHand();
        ArrayList<Hand> hands = new ArrayList<Hand>();
        Deck aDeck = new Deck();
        Dealer aDealer = new Dealer();
        hands.add(aBjHand);

        aDealer.deal(aDeck, hands, 2);



        assertEquals(BlackjackValue._13, aBjHand.getBestHandValue());
    }

    @Test
    public void getBestValueForAceAndKing() throws Exception {

        BlackjackHand aBjHand = new BlackjackHand();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.KING));




        assertEquals(BlackjackValue.BLACKJACK, aBjHand.getBestHandValue());
    }

    @Test
    public void getBestValueForThreeSevens() throws Exception {

        BlackjackHand aBjHand = new BlackjackHand();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));
        aBjHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.SEVEN));

        aBjHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));




        assertEquals(BlackjackValue._21, aBjHand.getBestHandValue());
    }

    @Test
    public void getBestValueForThreeAces() throws Exception {

        BlackjackHand aBjHand = new BlackjackHand();
        ArrayList<Hand> hands = new ArrayList<Hand>();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        aBjHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.ACE));

        aBjHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));





        assertEquals(BlackjackValue._13, aBjHand.getBestHandValue());
    }

    @Test
    public void blackjackBeats21() throws Exception {

        BlackjackHand aBjHand = new BlackjackHand();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));
        aBjHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.SEVEN));

        aBjHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));


        BlackjackHand bBjHand = new BlackjackHand();

        bBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        bBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.KING));

        //assertEquals(1, bBjHand.compareTo(aBjHand));
    }

    @Test
    public void a21Beats20() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));
        aBjHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.SEVEN));

        aBjHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));


        Hand bHand = new Hand();
        BlackjackHand bBjHand = new BlackjackHand();

        bHand.addCard(new PlayingCard(Suit.CLUBS, Rank.QUEEN));
        bHand.addCard(new PlayingCard(Suit.CLUBS, Rank.KING));

        //assertEquals(1, aBjHand.compareTo(bBjHand));
        //assertEquals(-1, bBjHand.compareTo(aBjHand));
        //assertEquals(0, aBjHand.compareTo(aBjHand));


    }

    @Test
    public void goBustWithAces() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.TEN));
        aBjHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.TEN));

        aBjHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));
        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));


        assertEquals(BlackjackValue.BUST, aBjHand.getBestHandValue());


    }


    @Test
    public void goBustWithoutAces() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand();

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.TEN));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.TEN));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.TWO));


        assertEquals(BlackjackValue.BUST, aBjHand.getBestHandValue());


    }

    @Test
    public void testLowestValidScore() throws Exception {

        BlackjackHand aBjHand = new BlackjackHand();

        aBjHand.addCard(new PlayingCard(Suit.CLUBS, Rank.TWO));
        aBjHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.TWO));

        assertEquals(BlackjackValue._4, aBjHand.getBestHandValue());

    }


}