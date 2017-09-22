package com.Ahtoh.company.Fifth;

import java.util.ArrayList;

public class SuspiciousElement implements Criminal {

    private String name;
    private ArrayList<String> hearedInfo = new ArrayList<>();

    public SuspiciousElement(String name) {
        this.name = name;
    }

    @Override
    public void addInformation(String peaceOfInf) {
        hearedInfo.add(peaceOfInf);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLeader() {
        return false;
    }
}


