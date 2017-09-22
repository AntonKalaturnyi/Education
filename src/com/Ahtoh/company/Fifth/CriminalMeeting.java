package com.Ahtoh.company.Fifth;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.System.out;


public class CriminalMeeting extends Observable implements Runnable {

    private static String notification;
    private static ArrayList<Criminal> members = new ArrayList<Criminal>(26);

    static {
        Spy first = new Spy("Batman");
        members.add(first);
        notification = "Registered member: " + first.getName();
        notifyMembers();
    }

    private  void registerMember(Criminal c) {
        members.add(c);
        notification = "Registered member: " + c.getName();
        notifyMembers();
    }

    private void removeMember(Criminal c) {
        members.remove(c);
        notification = "Removed member: " + c.getName();
        notifyMembers();
    }

    private synchronized static void notifyMembers() {
if (members.size() == 0) return;
boolean firstSpy = true;
        for (Criminal c : members) {
            if (c instanceof Observer ) {
                if (((Spy) c).interpreteNotification(notification)) {
                    ((Observer) c).handleEvent(new Message(notification));
                }
            }
        }

        for (Criminal c : members) {
            if(c instanceof Spy && firstSpy) {
                c.addInformation(notification);
                firstSpy = false;
            }
            if(!(c instanceof Spy)) {
                c.addInformation(notification);
            }
            }
notification = "";
    }

    public void registerMembers() {

        File membersList = new File("src/com/Ahtoh/company/Fifth/members.txt");

        try ( BufferedReader criminalReader = new BufferedReader(new FileReader(membersList)) ) {
            for (int i = 0; i < 15; i++) {
                this.registerMember(new SuspiciousElement(criminalReader.readLine()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public void runMeeting() {

        File speechList = new File("src/com/Ahtoh/company/Fifth/SuspiciousConversations.txt");

        try ( BufferedReader speechReader = new BufferedReader(new FileReader(speechList)) ) {
            for (int i = 0; i < 5; i++) {
                notification = speechReader.readLine();
                notifyMembers();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Criminal> getMembers() {
        return new ArrayList<Criminal>(members);
    }

    @Override
    public void run() {

        Criminal leader = new Leader("Vito Corleone");
        this.registerMember(leader);

        File spiesList = new File("src/com/Ahtoh/company/Fifth/spies.txt");
        try (BufferedReader spyReader = new BufferedReader(new FileReader(spiesList))) {
            for (int i = 0; i < 9; i++) {
                this.registerMember(new Spy(spyReader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}