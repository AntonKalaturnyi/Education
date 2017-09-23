package com.Ahtoh.company.Fifth;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * Task 5
 * @author Kalaturnui Anton
 */

public class Main {

    static {
        out.println("                                           From meeting :    tzzz ");
    }

    public static void main(String... args) {

        CriminalMeeting one = new CriminalMeeting();
        CriminalMeeting two = new CriminalMeeting();

        Thread first = new Thread(one, "One");
        Thread second = new Thread(two, "Two");

        first.start();
        second.start();


        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntelligenceService.printLogs();
        IntelligenceService.clearLogs();
        CriminalMeeting.registered();

        Scanner scan = new Scanner(System.in);
        out.println("And what now?" +
                "\n" + "1 + [name] - add spy " +
                "\n" + "2 + [name] - add criminal" +
                "\n" + "3 - run meeting as is" + "\n"
        );

        CriminalMeeting.continuE(scan.nextInt(), scan);

        one.runMeeting();


        IntelligenceService.printLogs();

        CriminalMeeting.registered();

        /*
        for (Criminal c : CriminalMeeting.getMembers()) {
            out.println(c.getName());
        }
        */
    }
}
