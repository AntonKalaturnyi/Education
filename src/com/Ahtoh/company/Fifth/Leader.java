package com.Ahtoh.company.Fifth;

class Leader extends SuspiciousElement {

    public Leader(String name) {
        super(name);
    }

    @Override
    public boolean isLeader() {
        return true;
    }
}