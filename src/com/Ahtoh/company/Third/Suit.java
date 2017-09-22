package com.Ahtoh.company.Third;

/**
 * Task 3
 * @author Kalaturnui Anton
 */

public class Suit {

    public static final Suit HEARTS = new Suit("HEARTS", 1);
    public static final Suit DIAMONDS = new Suit("DIAMONDS", 2);
    public static final Suit CLUBS = new Suit("CLUBS", 3);
    public static final Suit SPADES = new Suit("SPADES", 4);

    public static Suit[] values = { HEARTS, DIAMONDS, CLUBS, SPADES};

    private String name;
    private int priority;

    public Suit() {
    }

    Suit(String name) {
        this.name = name;
    }

    public Suit(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return " " + name;
    }
}
