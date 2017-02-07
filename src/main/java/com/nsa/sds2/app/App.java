package com.nsa.sds2.app;

import com.nsa.sds2.playingcards.PlayingCard;
import com.nsa.sds2.playingcards.Rank;
import com.nsa.sds2.playingcards.Suit;

/**
 * Created by Carl on 06/02/2017.
 */
public class App {

    public static void main(String args[]) {
        PlayingCard aCard = new PlayingCard(Suit.SPADES, Rank.ACE);
        PlayingCard bCard = new PlayingCard(Suit.SPADES, Rank.ACE);
        PlayingCard cCard = new PlayingCard(Suit.DIAMONDS, Rank.KING);

        System.out.println(aCard.toString().equals("ACE OF SPADES"));
        System.out.println(aCard.equals(bCard));
        System.out.println(aCard.equals(cCard));


    }

}
