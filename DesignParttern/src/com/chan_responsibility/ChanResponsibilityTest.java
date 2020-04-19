package com.chan_responsibility;

public class ChanResponsibilityTest {

    public static void main(String[] args) {
        Leader p7Leader = new P7Leader();
        Leader p8Leader = new P8Leader();
        p7Leader.setNextLeader(p8Leader);

        p7Leader.handleLeaveRequest("Lily", 1);
        p7Leader.handleLeaveRequest("Ben", 5);
        p7Leader.handleLeaveRequest("Sofia", 6);
    }

}

abstract class Leader {
    private Leader nextLeader;

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public abstract void handleLeaveRequest(String student, int days);

}

class P7Leader extends Leader {

    @Override
    public void handleLeaveRequest(String student, int days) {
        if (days <= 2) {
            System.out.println(String.format("P7 leader 批准 %s 请假 %d 天", student, days));
        } else {
            if (getNextLeader() != null) {
                getNextLeader().handleLeaveRequest(student, days);
            } else {
                System.out.println(student + " 请假天数太多，审批不通过！");
            }
        }
    }

}

class P8Leader extends Leader {

    @Override
    public void handleLeaveRequest(String student, int days) {
        if (days <= 5) {
            System.out.println(String.format("P8 leader 批准 %s 请假 %d 天", student, days));
        } else {
            if (getNextLeader() != null) {
                getNextLeader().handleLeaveRequest(student, days);
            } else {
                System.out.println(student + " 请假天数太多，审批不通过！");
            }
        }
    }

}