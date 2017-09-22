package com.Ahtoh.company.Fifth;

import java.util.Observable;


public class Spy implements Observer, Criminal {

private String name;

    public Spy(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(Message mes) {
      IntelligenceService.receiveData(mes);

    }

    @Override
    public void addInformation(String s) {
   if(s != "") {
       IntelligenceService.log(s);
   }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLeader() {
        return false;
    }

    protected boolean interpreteNotification(String  notific) {

      String[] wantedInf = IntelligenceService.getWantedInformation();
        for ( int i = 0; i < wantedInf.length; i++ ) {
            if (notific.contains(wantedInf[i])) {
                return true;
            }
        }
        return false;
    }
}



