package com.Ahtoh.company.Second;

import java.util.ArrayList;
import static java.lang.System.out;

/**
 * Task 2
 * @author Kalaturnui Anton
 */

public class LinkedList {

    private ArrayList<Node> records = new ArrayList<>();

    /* Конструктор без аргументів */
    public LinkedList() {
    }

    /* Додати елемент в кінець списку */
    public void add(Integer data) {
        Node node = new Node();
        node.setData(data);
        if (records.size() > 0) {
            records.get(records.size() - 1).setNext(node);
        }
        records.add(node);
    }

    /* Отримати елемент по індексу, повертає null якщо такий елемент недоступний */
    public Integer get(int index) {

        if (validIndex(index)) {
            return records.get(index).getData();
        } else {
            return null;
        }
    }

    /* Вилучення елементу за індексом, повертає true у разі успіху або false в іншому випадку */
    public boolean delete(int index) {

        if (validIndex(index) && records.remove(index) != null) {
            return true;
        }
        return false;
    }

    /*Повертає розмір списку: якщо елементів в списку нема то повертає 0 (нуль)*/
    public int size() {
        return records.size();
    }

    private boolean validIndex(int index) {
        if (index >= 0 && index < records.size()) {
            return true;
        } else {
            return false;
        }
    }
}


class Node {

    private Node next;
    private Integer data;

    public Node() {
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Integer getData() {
        return data;
    }
    public void setData(Integer data) {
        this.data = data;
    }

}

class Test {

    public static void main(String... args) {

        LinkedList myList = new LinkedList();

        for (int i = 0; i < 6; i++) {
            myList.add(i);
        }

        out.println("Size before deleting: " + myList.size());

        myList.delete(0);
        myList.delete(2);

        out.println("Size after deleting: " + myList.size());

    }
}
