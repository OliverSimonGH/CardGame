package com.nsa.sds2.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Carl on 10/02/2017.
 */
public class BlackjackValueTest {


    @Test
    public void testOrder() throws Exception {
        assertEquals(1, Integer.signum(BlackjackValue.BLACKJACK.compareTo(BlackjackValue._4)));
    }

}