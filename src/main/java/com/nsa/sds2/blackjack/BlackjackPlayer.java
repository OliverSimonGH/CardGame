package com.nsa.sds2.blackjack;

/**
 * Created by Carl on 10/02/2017.
 */
public class BlackjackPlayer implements Comparable {
    private String name;


    public BlackjackPlayer(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Object o) {
        BlackjackPlayer p = (BlackjackPlayer) o;
        return name.compareTo(p.getName());
    }


    @Override
    public String toString() {
        return "BlackjackPlayer{" +
                "name='" + name + '\'' +
                '}';
    }
}
