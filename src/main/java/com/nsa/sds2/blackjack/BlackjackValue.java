package com.nsa.sds2.blackjack;

/**
 * Enum to represent the possible values in a Blackjack hand.  Assumes Aces are always counted high
 * unless they need to be coverted down to keep the hand in the game.
 */
public enum BlackjackValue {
    BUST, _1_INVALID, _2_INVALID, _3_INVALID, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, BLACKJACK;
}
