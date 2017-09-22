package com.Ahtoh.company.Fifth;

public interface Criminal {

void addInformation(String s);
String getName();
boolean isLeader();

}

interface Observer {

void handleEvent(Message mes);

}
