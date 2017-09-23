package com.Ahtoh.company.Fifth;

/**
 * Task 5
 * @author Kalaturnui Anton
 */

public interface Criminal {

void addInformation(String s);
String getName();
boolean isLeader();

}

interface Observer {

void handleEvent(Message mes);

}
