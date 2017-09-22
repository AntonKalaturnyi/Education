package com.Ahtoh.company.Fifth;

import static java.lang.System.out;

public class Main {
    public static void main(String ... args) {
        CriminalMeeting activity = new CriminalMeeting();
        CriminalMeeting main = new CriminalMeeting();
        Thread thread = new Thread(activity, "activity");
        thread.start();
        main.registerMembers();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.runMeeting();
       out.println(CriminalMeeting.getMembers().size());

        IntelligenceService.printLogs();

        /*
        for (int i = 0; i < CriminalMeeting.getMembers().size() ; i++) {
    out.println("" + i + CriminalMeeting.getMembers().get(i).getName());

}
*/
    }
}
