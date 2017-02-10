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

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);
        ArrayList<Hand> hands = new ArrayList<Hand>();
        Deck aDeck = new Deck();
        Dealer aDealer = new Dealer();
        hands.add(aHand);

        aDealer.deal(aDeck, hands, 2);

        System.out.println(aHand);


        assertEquals(BlackjackValue._13, aBjHand.getBestHandValue());
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


        assertEquals(BlackjackValue.BLACKJACK, aBjHand.getBestHandValue());
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


        assertEquals(BlackjackValue._21, aBjHand.getBestHandValue());
    }

    @Test
    public void getBestValueForThreeAces() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);
        ArrayList<Hand> hands = new ArrayList<Hand>();

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.ACE));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));


        hands.add(aHand);


        System.out.println(aHand);


        assertEquals(BlackjackValue._13, aBjHand.getBestHandValue());
    }

    @Test
    public void blackjackBeats21() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.SEVEN));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));


        Hand bHand = new Hand();
        BlackjackHand bBjHand = new BlackjackHand(bHand);

        bHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        bHand.addCard(new PlayingCard(Suit.CLUBS, Rank.KING));

        assertEquals(1, bBjHand.compareTo(aBjHand));
    }

    @Test
    public void a21Beats20() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.SEVEN));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));


        Hand bHand = new Hand();
        BlackjackHand bBjHand = new BlackjackHand(bHand);

        bHand.addCard(new PlayingCard(Suit.CLUBS, Rank.QUEEN));
        bHand.addCard(new PlayingCard(Suit.CLUBS, Rank.KING));

        assertEquals(1, aBjHand.compareTo(bBjHand));
        assertEquals(-1, bBjHand.compareTo(aBjHand));
        assertEquals(0, aBjHand.compareTo(aBjHand));


    }

    @Test
    public void goBustWithAces() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.TEN));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.TEN));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));
        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));


        assertEquals(BlackjackValue.BUST, aBjHand.getBestHandValue());


    }


    @Test
    public void goBustWithoutAces() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.TEN));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.TEN));

        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.TWO));


        assertEquals(BlackjackValue.BUST, aBjHand.getBestHandValue());


    }

    @Test
    public void testLowestValidScore() throws Exception {

        Hand aHand = new Hand();
        BlackjackHand aBjHand = new BlackjackHand(aHand);

        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.TWO));
        aHand.addCard(new PlayingCard(Suit.DIAMONDS, Rank.TWO));

        assertEquals(BlackjackValue._4, aBjHand.getBestHandValue());

    }


}