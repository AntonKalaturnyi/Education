package com.Ahtoh.company.Fifth;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.*;
import static java.lang.System.out;

/**
 * Task 5
 * @author Kalaturnui Anton
 */

public class CriminalMeeting extends Observable implements Runnable {

    private static String notification;
    private static List<Criminal> members = Collections.synchronizedList(new ArrayList<Criminal>());

    static {
        Spy first = new Spy("Batman");
        members.add(first);
        notification = "Registered member: " + first.getName();
        notifyMembers();
    }

    private  void registerMember(Criminal c) {
        members.add(c);
        notification = "Registered member: " + c.getName();
        if (members.size() > 26 && c instanceof  Spy) {
            SOS();
            return;
        }
        notifyMembers();
    }

    private void removeMember(Criminal c) {
        members.remove(c);
        notification = "Removed member: " + c.getName();
        notifyMembers();
        notification = "";
    }

    private static int notifyMembers() {
        if (members.size() == 0) return 0;
        boolean firstSpy = true;
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            for (Criminal c : members) {
                if (c instanceof Observer) {
                    if (((Spy) c).interpreteNotification(notification)) {
                        ((Observer) c).handleEvent(new Message(notification));
                    }
                }
            }

            for (Criminal c : members) {
                if (c instanceof Spy && firstSpy) {
                    c.addInformation(notification);
                    firstSpy = false;
                }
                if (!(c instanceof Spy)) {
                    c.addInformation(notification);
                }
            }
        } finally {
            lock.unlock();
            notification = "";
            return 1;
        }
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
            for (int i = 0; i < 6; i++) {
                notification = speechReader.readLine();
                notifyMembers();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Criminal> getMembers() {
        return new ArrayList<>(members);
    }

    public static int continuE(int param, Scanner scan) {

        switch (param ) {

            case 1 : {
                new CriminalMeeting().registerMember(new Spy(scan.nextLine()));
                break;
            }

            case 2 : {
                new CriminalMeeting().registerMember(new SuspiciousElement(scan.nextLine()));
                CriminalMeeting.registered();
                break;
            }

            case 3 : {
                return 0;
            }
        }

        return 1;
    }

    public static void registered() {
        out.println("\n" + "Registered: " + CriminalMeeting.getMembers().size() + "\n");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("One")) {

            File spiesList = new File("src/com/Ahtoh/company/Fifth/spies.txt");
            try (BufferedReader spyReader = new BufferedReader(new FileReader(spiesList))) {
                for (int i = 0; i < 9; i++) {
                    this.registerMember(new Spy(spyReader.readLine()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Criminal leader = new Leader("Vito Corleone");
            this.registerMember(leader);
            registerMembers();
        }
    }

    private void SOS() {
        out.println("\n" + "=====Hey, here's the spies!=====" + "\n" + "========Let's show them!========" + "\n"  +  "\n" + "   ︻デ┳═ー  - - - - - - - - - -  " + "\n");
        for (Criminal c : getMembers()) {
            if(c instanceof Spy) {
                removeMember(c);
            }
        }
    }
}