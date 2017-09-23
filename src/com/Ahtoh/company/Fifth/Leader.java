package com.Ahtoh.company.Fifth;

/**
 * Task 5
 * @author Kalaturnui Anton
 */

class Leader extends SuspiciousElement {

    public Leader(String name) {
        super(name);
    }

    @Override
    public boolean isLeader() {
        return true;
    }
}