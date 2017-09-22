package com.Ahtoh.company.Third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.lang.System.out;

/**
 * Task 3
 * @author Kalaturnui Anton
 */

public class Deck {

    private static ArrayList<Card> deck = new ArrayList<>(36);
    private static java.util.LinkedList<Card> deckList;
    private static boolean isSorted;

    static {

        for (int i = 0; i < Suit.values.length; i++) {
            for (int j = 0; j < Rank.values.length; j++) {
                deck.add(new Card(Rank.values[j], Suit.values[i]));
            }
        }

    }

    public Deck() {
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Collections.shuffle(deck);
    }


    /* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {

        ArrayList<Card> temp;
        ArrayList<Card> sorted = new ArrayList<>();

        for (int j = 1; j < 5; j++) {
            temp = new ArrayList<>();
            for (int i = 0; i < deck.size(); i++) {
                if (deck.get(i).getSuit().getPriority() == j) {
                    temp.add(deck.get(i));
                }
            }
            Collections.sort(temp, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    if (o1.getRank().getPriority() > o2.getRank().getPriority()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            sorted.addAll(temp);
        }
        deck = sorted;
        isSorted = true;
    }
    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return !(deck.isEmpty());
    }


    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
   public Card drawOne() {
        if (!hasNext()) {
            return null;
        }
        if(isSorted) {
           Collections.reverse(deck);
        }

        deckList = new java.util.LinkedList<>(deck);
        Card drawed = deckList.pop();
        deck = new ArrayList<>(deckList);
        isSorted = false;
        return drawed;
    }

    private static void printDeck() {
        out.println("        Size of deck: " + deck.size() + '\n');
        for (Card c : deck) {
            out.println(c);
        }
        out.println();
    }

    public static void main(String... args) {

        Deck theDeck = new Deck();

        theDeck.shuffle();
        out.println("                               After shuffle: ");
        printDeck();

        out.println('\n' + '\n');

        theDeck.order();
        out.println("                               After sorting: ");
        printDeck();

        out.println("                               After drawing: " + '\n');

        for (int i = 0; i < 3; i++ ) {
            out.println("  Drawed card: " + theDeck.drawOne());
        }

        out.println('\n' + "        Size of deck: " + deck.size());

    }
}

