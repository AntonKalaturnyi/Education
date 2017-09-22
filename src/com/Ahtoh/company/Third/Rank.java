package com.Ahtoh.company.Third;

/**
 * Task 3
 * @author Kalaturnui Anton
 */

public class Rank {

    public static final Rank ACE = new Rank("Ace", 1);
    public static final Rank KING = new Rank("King", 2);
    public static final Rank QUEEN = new Rank("Queen", 3);
    public static final Rank JACK = new Rank("Jack", 4);
    public static final Rank TEN = new Rank("10",5);
    public static final Rank NINE = new Rank("9",6);
    public static final Rank EIGHT = new Rank("8",7);
    public static final Rank SEVEN = new Rank("7",8);
    public static final Rank SIX = new Rank("6",9);

    public static Rank[] values = { ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX };

    private String name;
    private int priority;

    public Rank() {
    }

    Rank(String name) {
        this.name = name;
    }

    public Rank(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return " " + name;
    }
}
