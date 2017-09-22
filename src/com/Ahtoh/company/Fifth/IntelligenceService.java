package com.Ahtoh.company.Fifth;

import java.util.ArrayList;
import static java.lang.System.out;

public class IntelligenceService {

    private static String[] wantedInformation = new String[3];
    private static ArrayList<Log> logs = new ArrayList<>();
    private static ArrayList<Message> researchedData = new ArrayList<>();

    static {

    wantedInformation[0] = "expansion";
    wantedInformation[1] = "laundering";
    wantedInformation[2] = "sources";
 }


private static class Log {
        private String log;

    public Log(String log) {
        this.log = log;
    }

    public String getLog() {
        return log;
    }
}


    public static String[] getWantedInformation() {
        return wantedInformation;
    }

    public static void receiveData(Message mes) {

        researchedData.add(mes);
    }

    public static void log(String line) {
        logs.add(new Log(line));
    }

    public static void printLogs() {
        for (int i = 0; i < logs.size(); i++ ) {
            out.println("Log " + i + ": " + logs.get(i).getLog());
        }

    }

}
